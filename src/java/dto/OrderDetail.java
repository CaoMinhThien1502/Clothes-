/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author thien
 */
public class OrderDetail {

    private int OrderDetailID;
    private int OrderID;
    private int ClothesID;
    private String ClothesName;
    private int Price;
    private String ImgPath;
    private int Quantity;

    public OrderDetail() {
    }

    public OrderDetail(int OrderDetailID, int OrderID, int ClothesID, String ClothesName, int Price, String ImgPath, int Quantity) {
        this.OrderDetailID = OrderDetailID;
        this.OrderID = OrderID;
        this.ClothesID = ClothesID;
        this.ClothesName = ClothesName;
        this.Price = Price;
        this.ImgPath = ImgPath;
        this.Quantity = Quantity;
    }

    public int getOrderDetailID() {
        return OrderDetailID;
    }

    public void setOrderDetailID(int OrderDetailID) {
        this.OrderDetailID = OrderDetailID;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public int getClothesID() {
        return ClothesID;
    }

    public void setClothesID(int ClothesID) {
        this.ClothesID = ClothesID;
    }

    public String getClothesName() {
        return ClothesName;
    }

    public void setClothesName(String ClothesName) {
        this.ClothesName = ClothesName;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public String getImgPath() {
        return ImgPath;
    }

    public void setImgPath(String ImgPath) {
        this.ImgPath = ImgPath;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

}
