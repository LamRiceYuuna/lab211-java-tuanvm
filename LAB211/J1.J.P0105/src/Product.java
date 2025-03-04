
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Le Viet
 */
public class Product {
    private String ID;
    private String name;
    private String Category;
    private double price;
    private String storekeeper;
    private String location;
    private  Date dateOfManufacture;
    private  Date expiryDate;
    private  Date receiptDate;
    

    public Product() {
    }

    public Product(String ID, String name, String Category, double price, 
  String storekeeper, String location, Date expiryDate, Date dateOfManufacture, 
  Date receiptDate) {
        this.ID = ID;
        this.name = name;
        this.Category = Category;
        this.price = price;
        this.storekeeper = storekeeper;
        this.location = location;
        this.expiryDate = expiryDate;
        this.dateOfManufacture = dateOfManufacture;       
        this.receiptDate = receiptDate;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStorekeeper() {
        return storekeeper;
    }

    public void setStorekeeper(String storekeeper) {
        this.storekeeper = storekeeper;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(Date dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    
    
    
     
    
    
    
    
}
