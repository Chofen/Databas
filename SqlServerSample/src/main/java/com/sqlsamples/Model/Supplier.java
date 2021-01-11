package com.sqlsamples.Model;

public class Supplier
{
    private String name;
    private String phoneNbr;
    private String address;

    public Supplier(String name, String phoneNbr, String address) {
        this.name = name;
        this.phoneNbr = phoneNbr;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNbr() {
        return phoneNbr;
    }

    public void setPhoneNbr(String phoneNbr) {
        this.phoneNbr = phoneNbr;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String[] toStringArray()
    {
        return new String[]{name, phoneNbr, address};
    }

}
