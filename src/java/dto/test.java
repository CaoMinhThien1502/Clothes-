/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import dao.AccountDAO;
import dao.ClothesDAO;
import dao.OrderDAO;
import java.util.ArrayList;

/**
 *
 * @author thien
 */
public class test {
    public static void main(String[] args) throws Exception {
//        ArrayList<Clothes> list = ClothesDAO.getClothes("j", "byname");
//        for (Clothes clothes : list) {
//            System.out.println(clothes.getClothesName());
//        boolean a=AccountDAO.insertAccount("test1@gmail.com", "234d", "conmem", "24523523", 1, 0);
//        System.out.println(a);


//       Account acc = AccountDAO.getAccount("test1@gmail.com", "test1");
//        
//        System.out.println(acc.getFullname());
      //  System.out.println(AccountDAO.getAccount("aaa").getFullname());
       // System.out.println(OrderDAO.getOrders("test1@gmail.com"));
       
//       Account acc = new Account();
//       acc = AccountDAO.getAccountByEmail("test1@gmail.com");
//        System.out.println(acc.getFullname());
        
//        ArrayList<OrderDetail> o = OrderDAO.getOrderDetail(3);
//        for (OrderDetail orderDetail : o) {
//            System.out.println(orderDetail.getClothesName());
//        }
    //OrderDAO.cancelOrder(6);
//    ArrayList<Account> list = AccountDAO.getAccountListByEmail("1");
//        for (Account account : list) {
//            System.out.println(account.getEmail());
//        }
//        for (Account account : list) {
//            System.out.println(account.getFullname());
//        }
//AccountDAO.updateAccountStatus("test1@gmail.com", 1);
//ArrayList<ManageOrder> list = OrderDAO.getAlltOrder();
//        for (ManageOrder manageOrder : list) {
//            System.out.println(manageOrder.getFullname());
//        }
            Clothes c= ClothesDAO.getClothes(3);
            System.out.println(c.getClothesName());
            
}
}

