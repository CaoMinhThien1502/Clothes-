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
public class ManageOrder {

    private int OrderID;
    private String OrderDate;
    private String ShipDate;
    private int Status;
    private String Fullname;
    private String Phone;

    public ManageOrder() {
    }

    public ManageOrder(int OrderID, String OrderDate, String ShipDate, int Status, String Fullname, String Phone) {
        this.OrderID = OrderID;
        this.OrderDate = OrderDate;
        this.ShipDate = ShipDate;
        this.Status = Status;
        this.Fullname = Fullname;
        this.Phone = Phone;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String OrderDate) {
        this.OrderDate = OrderDate;
    }

    public String getShipDate() {
        return ShipDate;
    }

    public void setShipDate(String ShipDate) {
        this.ShipDate = ShipDate;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }
}
