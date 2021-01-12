package com.sqlsamples.Model;

import java.sql.Date;

public class DiscountHistory
{
    int code;
    String productName;
    String discountName;
    Date startDate;
    Date endDate;
    int percentage;
    int basePrice;
    int finalPrice;

    public DiscountHistory(int code, String productName, String discountName, Date startDate,
                           Date endDate, int percentage, int basePrice, int finalPrice) {

        this.code = code;
        this.productName = productName;
        this.discountName = discountName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.percentage = percentage;
        this.basePrice = basePrice;
        this.finalPrice = finalPrice;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String[] toStringArray()
    {
        return new String[]{code +"", productName, discountName, startDate.toString(), endDate.toString(),
                percentage +"" + basePrice +"", + finalPrice + ""};
    }
}
