package com.sqlsamples.Model;


import java.sql.Date;

public class Discount
{
    private int code;
    private String name;
    private Date startDate;
    private Date endDate;
    private int percentage;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Discount(String name, java.sql.Date startDate, java.sql.Date endDate, int percentage) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String[] toStringArray()
    {
        if(startDate == null || endDate == null)
        {
            return new String[]{""+code, name, "null", "null", "" + percentage};
        }
        return new String[]{""+code, name, startDate.toString(), endDate.toString(), ""+ percentage};
    }
}
