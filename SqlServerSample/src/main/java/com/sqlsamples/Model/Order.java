package com.sqlsamples.Model;

import java.sql.Date;

public class Order
{
    int oCode;
    int pCode;
    String productName;
    int basePrice;
    String supplierName;
    int dCode;
    Date orderDate;
    String customerName;
    String orderStatus;


    public Order(int oCode, int pCode, String productName, int basePrice,
                 String supplierName, int dCode, Date orderDate, String customerName, String orderStatus) {
        this.oCode = oCode;
        this.pCode = pCode;
        this.productName = productName;
        this.basePrice = basePrice;
        this.supplierName = supplierName;
        this.dCode = dCode;
        this.orderDate = orderDate;
        this.customerName = customerName;
        this.orderStatus = orderStatus;
    }

    public int getoCode() {
        return oCode;
    }

    public void setoCode(int oCode) {
        this.oCode = oCode;
    }

    public int getpCode() {
        return pCode;
    }

    public void setpCode(int pCode) {
        this.pCode = pCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public int getdCode() {
        return dCode;
    }

    public void setdCode(int dCode) {
        this.dCode = dCode;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String[] toStringArray()
    {
        return new String[]{"" + oCode, + pCode +"", productName, basePrice +"", supplierName,""+ dCode,
                orderDate.toString(), customerName, orderStatus};
    }
}
