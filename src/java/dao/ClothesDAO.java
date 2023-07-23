/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Clothes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utils.DBUtils;

/**
 *
 * @author thien
 */
public class ClothesDAO {

    public static ArrayList<Clothes> getClothes(String keyword, String searchby) {
        ArrayList<Clothes> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null && searchby != null) {
                String sql = "select clothesID, clothesName, price, imgPath, description, status, Clothes.typeID as 'typeID', typeName\n"
                        + "from Clothes join Type on Clothes.typeID = Type.typeID ";
                if (searchby.equalsIgnoreCase("byname")) {
                    sql = sql + "where Clothes.clothesName like ?";
                } else {
                    sql = sql + "where typeName like ?";
                }
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + keyword + "%");
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int Id = rs.getInt("clothesID");
                        String Name = rs.getString("clothesName");
                        int Price = rs.getInt("price");
                        String Imgpath = rs.getString("imgPath");
                        String Description = rs.getString("description");
                        int Status = rs.getInt("status");
                        int Typeid = rs.getInt("typeID");
                        String Typename = rs.getString("typeName");
                        Clothes clothes = new Clothes(Id, Name, Price, Imgpath, Description, Status, Typeid, Typename);
                        list.add(clothes);
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
        return list;
    }

    public static Clothes getClothes(int cid) {
        Clothes c = null;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select clothesID, clothesName, price, imgPath, description, status, Clothes.typeID as 'typeID', typeName\n"
                        + "from Clothes join Type on Clothes.typeID = Type.typeID\n"
                        + "where clothesID=?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, cid);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    int id = rs.getInt("clothesID");
                    String name = rs.getString("clothesName");
                    int price = rs.getInt("price");
                    String imgpath = rs.getString("imgPath");
                    String description = rs.getString("description");
                    int status = rs.getInt("status");
                    int typeid = rs.getInt("typeID");
                    String typename = rs.getString("typeName");
                    c = new Clothes(id, name, price, imgpath, description, status, typeid, typename);

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
        return c;
    }

    public static ArrayList<Clothes> getClothes(String typename) {
        ArrayList<Clothes> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select clothesID, clothesName, price, imgPath, description, status, Clothes.typeID as 'typeID', typeName\n"
                        + "from Clothes join Type on Clothes.typeID = Type.typeID where typeName like ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + typename + "%");
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int Id = rs.getInt("clothesID");
                        String Name = rs.getString("clothesName");
                        int Price = rs.getInt("price");
                        String Imgpath = rs.getString("imgPath");
                        String Description = rs.getString("description");
                        int Status = rs.getInt("status");
                        int Typeid = rs.getInt("typeID");
                        String Typename = rs.getString("typeName");
                        Clothes clothes = new Clothes(Id, Name, Price, Imgpath, Description, Status, Typeid, Typename);
                        list.add(clothes);
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
        return list;
    }

    public static boolean updateClothesStatus(int clothesid, int status) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "update Clothes\n"
                        + "set status = ?\n"
                        + "where clothesID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, status);
                pst.setInt(2, clothesid);

                pst.executeUpdate();
                if (pst.getUpdateCount() == 0) {
                    return false;
                } else {
                    return true;
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
        return true;
    }

    public static void updateClothes(String name, int price, String des, int clothesid) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "update Clothes\n"
                        + "set clothesName = ?, price = ?, description = ?\n"
                        + "where clothesID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, name);
                pst.setInt(2, price);
                pst.setString(3, des);
                pst.setInt(4, clothesid);
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

    public static boolean insertClothes(String name, int price, String img, String des, int status, int type) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "insert into Clothes (clothesName, price, imgPath, description, status, typeID) values (?, ?, ?, ?, ?, ?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, name);
                pst.setInt(2, price);
                pst.setString(3, img);
                pst.setString(4, des);
                pst.setInt(5, status);
                pst.setInt(6, type);
                if(pst.executeUpdate()>0){
                    return true;
                }else return false;
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
        return false;
    }
}
