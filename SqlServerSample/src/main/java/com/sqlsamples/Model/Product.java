package com.sqlsamples.Model;


import java.sql.Date;

public class Product
{
    private String name;
    private int code;
    private int quantity;
    private int basePrice;
    private String supplierName;
    private Date date;
    private int discountCode;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Product(String name, int quantity, int basePrice, String supplierName, Date date, int discountCode)
    {
        this.name = name;
        this.quantity = quantity;
        this.basePrice = basePrice;
        this.supplierName = supplierName;
        this.date = date;
        this.discountCode = discountCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDiscountCode() {
        return discountCode;
    }



    public String[] toStringArray()
    {
        return new String[]{""+code, name, "" + quantity, "" +basePrice, supplierName, date.toString(),""+ discountCode};
    }
}
