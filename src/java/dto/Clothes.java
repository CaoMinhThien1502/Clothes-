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
public class Clothes {
    private int ClothesID;
    private  String ClothesName;
    private int price;
    private String ImgPath;
    private String Description;
    private int Status;
    private int TypeID;
    private String TypeName;

    public Clothes() {
    }

    public Clothes(int ClothesID, String ClothesName, int price, String ImgPath, String Description, int Status, int TypeID, String TypeName) {
        this.ClothesID = ClothesID;
        this.ClothesName = ClothesName;
        this.price = price;
        this.ImgPath = ImgPath;
        this.Description = Description;
        this.Status = Status;
        this.TypeID = TypeID;
        this.TypeName = TypeName;
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
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImgPath() {
        return ImgPath;
    }

    public void setImgPath(String ImgPath) {
        this.ImgPath = ImgPath;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public int getTypeID() {
        return TypeID;
    }

    public void setTypeID(int TypeID) {
        this.TypeID = TypeID;
    }

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String TypeName) {
        this.TypeName = TypeName;
    }

    @Override
    public String toString() {
        return "Clothes{" + "ClothesID=" + ClothesID + ", ClothesName=" + ClothesName + ", price=" + price + ", ImgPath=" + ImgPath + ", Description=" + Description + ", Status=" + Status + ", TypeID=" + TypeID + ", TypeName=" + TypeName + '}';
    }
}
