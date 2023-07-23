/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utils.DBUtils;

/**
 *
 * @author thien
 */
public class AccountDAO {

    public static Account getAccount(String email, String password) throws Exception {
        Connection cn = null;
        Account acc = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select accID,email,password,fullname,phone,status,role,token\n"
                        + "from dbo.Account\n"
                        + "where status=1 and email=? and password=? COLLATE Latin1_General_CS_AS";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                pst.setString(2, password);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    int AccID = rs.getInt("accID");
                    String Email = rs.getString("email");
                    String Password = rs.getString("password");
                    String Fullname = rs.getString("fullname");
                    String Phone = rs.getString("phone");
                    int Status = rs.getInt("status");
                    int Role = rs.getInt("role");
                    String Token = rs.getString("token");
                    acc = new Account(AccID, Email, Password, Fullname, Status, Phone, Role, Token);
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
        return acc;
    }

    public static Account getAccount(String token) throws Exception {
        Connection cn = null;
        Account acc = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select accID,email,password,fullname,phone,status,role,token\n"
                        + "from dbo.Account\n"
                        + "where status=1 and token=? COLLATE Latin1_General_CS_AS";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, token);

                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    int AccID = rs.getInt("accID");
                    String Email = rs.getString("email");
                    String Password = rs.getString("password");
                    String Fullname = rs.getString("fullname");
                    String Phone = rs.getString("phone");
                    int Status = rs.getInt("status");
                    int Role = rs.getInt("role");
                    String Token = rs.getString("token");
                    acc = new Account(AccID, Email, Password, Fullname, Status, Phone, Role, Token);
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
        return acc;
    }

    public static boolean updateToken(String token, String email) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "UPDATE dbo.Account "
                        + "SET token = ?\n"
                        + "WHERE email = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, token);
                pst.setString(2, email);
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

    public static boolean insertAccount(String newEmail, String newPassword, String newFullname, String newPhone, int newSatus, int newRole) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "insert into Account (email,password,fullname, phone, status, role)\n"
                        + "values(?, ?, ?, ?, ?, ?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, newEmail);
                pst.setString(2, newPassword);
                pst.setString(3, newFullname);
                pst.setString(4, newPhone);
                pst.setInt(5, newSatus);
                pst.setInt(6, newRole);
                pst.execute();
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
        return false;
    }
    
    public static Account getAccountByEmail(String email) throws Exception {
        Connection cn = null;
        Account acc = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select accID,email,password,fullname,phone,status,role,token\n"
                        + "from dbo.Account\n"
                        + "where status=1 and email=? COLLATE Latin1_General_CS_AS";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    int AccID = rs.getInt("accID");
                    String Email = rs.getString("email");
                    String Password = rs.getString("password");
                    String Fullname = rs.getString("fullname");
                    String Phone = rs.getString("phone");
                    int Status = rs.getInt("status");
                    int Role = rs.getInt("role");
                    String Token = rs.getString("token");
                    acc = new Account(AccID, Email, Password, Fullname, Status, Phone, Role, Token);
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
        return acc;
    }
    public static ArrayList<Account> getAccountListByEmail(String email) throws Exception {
        ArrayList<Account> accList = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select accID,email,password,fullname,phone,status,role,token\n"
                        + "from dbo.Account\n"
                        + "where email like ? COLLATE Latin1_General_CS_AS";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1,"%" + email + "%");
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                    int AccID = rs.getInt("accID");
                    String Email = rs.getString("email");
                    String Password = rs.getString("password");
                    String Fullname = rs.getString("fullname");
                    String Phone = rs.getString("phone");
                    int Status = rs.getInt("status");
                    int Role = rs.getInt("role");
                    String Token = rs.getString("token");
                    Account acc = new Account(AccID, Email, Password, Fullname, Status, Phone, Role, Token);
                    accList.add(acc);
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
        return accList;
    }
    
    public static boolean updateAccount(String email, String newPassword, String newFullname, String newPhone){
        Connection cn = null;
        try{
            cn = DBUtils.makeConnection();
            if(cn != null){
                String sql = "UPDATE dbo.Account "
                            + "SET password = ?, fullname = ?, phone = ?\n"
                            + "WHERE email = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, newPassword);
                pst.setString(2, newFullname);
                pst.setString(3, newPhone);
                pst.setString(4, email);
                pst.executeUpdate();
                if(pst.getUpdateCount()==0) return false;
                else return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(cn != null){
                try{
                    cn.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
    public static ArrayList<Account> getAccounts(){
        ArrayList<Account> accList = new ArrayList<>();
        Connection cn = null;
        
        try{
            cn = DBUtils.makeConnection();
            if(cn!=null){
                String sql= "select accID,email,password,fullname,phone,status,role,token\n" +
                            "from dbo.Account\n";                      
                PreparedStatement pst=cn.prepareStatement(sql);             
                ResultSet rs=pst.executeQuery();
                while(rs!=null && rs.next()){
                    Account acc=new Account();
                    int AccID=rs.getInt("accID");
                    String Email=rs.getString("email");                   
                    String Password=rs.getString("password");
                    String Fullname=rs.getString("fullname");
                    String Phone=rs.getString("phone");
                    int Status=rs.getInt("status");
                    int Role=rs.getInt("role");
                    String Token = rs.getString("token");
                    acc = new Account(AccID, Email, Password, Fullname, Status, Phone, Role, Token);
                    accList.add(acc);              
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            if(cn!=null){
                try{
                    cn.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }      
        return accList;
    }
    
    public static boolean updateAccountStatus(String email, int status){
        Connection cn = null;
        try{
            cn = DBUtils.makeConnection();
            if(cn != null){
                String sql = "UPDATE dbo.Account "
                            + "SET status = ? "
                            + "WHERE email = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, status);
                pst.setString(2, email);
                pst.executeUpdate();
                if(pst.getUpdateCount()==0) return false;
                else return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(cn != null){
                try{
                    cn.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

}
