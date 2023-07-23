/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.ManageOrder;
import dto.Order;
import dto.OrderDetail;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import utils.DBUtils;

/**
 *
 * @author thien
 */
public class OrderDAO {

    public static boolean insertOrder(String email, HashMap<String, Integer> cart) {
        Connection cn = null;
        boolean result = false;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                int accid = 0, orderid = 0;
                cn.setAutoCommit(false);
                String sql = "select accID from Account where Account.email=? ";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    accid = rs.getInt("accID");
                }
                System.out.println("accountid:" + accid);
                Date d = new Date(System.currentTimeMillis());
                System.out.println("order date:" + d);
                sql = "insert Orders(orderDate,status,accID) values(?,?,?) ";
                pst = cn.prepareStatement(sql);
                pst.setDate(1, d);
                pst.setInt(2, 1);
                pst.setInt(3, accid);
                pst.executeUpdate();

                sql = "select top 1 orderID from Orders order by orderID desc ";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    orderid = rs.getInt("orderID");
                }
                //insert order details
                System.out.println("orderid:" + orderid);
                Set<String> cids = cart.keySet();
                for (String cid : cids) {
                    sql = "insert OrderDetails values(?,?,?) ";
                    pst = cn.prepareStatement(sql);
                    pst.setInt(1, orderid);
                    pst.setInt(2, Integer.parseInt(cid.trim()));
                    pst.setInt(3, cart.get(cid));
                    pst.executeUpdate();
                    cn.commit();
                    cn.setAutoCommit(true);
                }
                return true;
            } else {
                System.out.println("Can't insert order");
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (cn != null) {
                    cn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            result = false;
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public static ArrayList<Order> getOrders(String email) {
        ArrayList<Order> orderList = new ArrayList<>();
        Connection cn = null;

        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select * from Orders where accID = (select accID from Account where email = ?)";

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                ResultSet rs = pst.executeQuery();
                while (rs != null && rs.next()) {
                    int orderID = rs.getInt("orderID");
                    String orderDate = rs.getString("orderDate");
                    String shipDate = rs.getString("shipDate");
                    int status = rs.getInt("status");
                    int accID = rs.getInt("accID");
                    Order order = new Order(orderID, orderDate, shipDate, status, accID);
                    orderList.add(order);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return orderList;
    }

    public static ArrayList<OrderDetail> getOrderDetail(int orderID) {
        Connection cn = null;
        ArrayList<OrderDetail> orderDetailList = new ArrayList<>();

        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select detailID, orderID, OrderDetails.clothesID as clothesID, clothesName, price, imgPath, quantity\n"
                        + "from OrderDetails, Clothes\n"
                        + "where orderID=? and OrderDetails.clothesID=Clothes.clothesID";

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, orderID);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int DetailID = rs.getInt("detailID");
                        int OrderID = rs.getInt("orderID");
                        int ClothesID = rs.getInt("clothesID");
                        String ClothesName = rs.getString("clothesName");
                        int Price = rs.getInt("price");
                        String ImgPath = rs.getString("imgPath");
                        int Quantity = rs.getInt("quantity");
                        OrderDetail orderdetail = new OrderDetail(DetailID, OrderID, Quantity, ClothesName, Price, ImgPath, Quantity);
                        orderDetailList.add(orderdetail);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return orderDetailList;
    }

    public static void cancelOrder(int orderID) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            String sql = "delete from OrderDetails where orderID=?\n"
                    + "delete from Orders where orderID=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, orderID);
            pst.setInt(2, orderID);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static ArrayList<ManageOrder> getAlltOrder() {
        ArrayList<ManageOrder> orderList = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select orderID, orderDate, shipDate, Orders.status as status, fullname, phone\n" +
                             "from Orders join Account on Orders.accID=Account.accID";
                PreparedStatement pst = cn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while (rs != null && rs.next()) {
                    int orderID = rs.getInt("orderID");
                    String orderDate = rs.getString("orderDate");
                    String shipDate = rs.getString("shipDate");
                    int status = rs.getInt("status");
                    String fullname = rs.getString("fullname");
                    String phone = rs.getString("phone");
                    ManageOrder order = new ManageOrder(orderID, orderDate, shipDate, status, fullname, phone);
                    orderList.add(order);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return orderList;
    }
    
    public static void updateStatusOrder(int status, int orderid) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "update Orders\n" +
                             "set status = ?, shipDate = ?\n" +
                             "where orderID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                Date d = new Date(System.currentTimeMillis());
                System.out.println("order date:" + d);
                pst.setInt(1, status);
                pst.setDate(2, d);
                pst.setInt(3, orderid);
                pst.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
