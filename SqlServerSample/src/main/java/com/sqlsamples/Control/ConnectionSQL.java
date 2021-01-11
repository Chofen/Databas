package com.sqlsamples.Control;

import com.sqlsamples.Model.Discount;
import com.sqlsamples.Model.Product;
import com.sqlsamples.Model.Supplier;

import java.sql.*;
import java.util.ArrayList;

public class ConnectionSQL
{
    java.sql.Connection connection = null;
    String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=OnlineStore;user=sa;password=reallyStrongPwd#123";

    public ConnectionSQL()
    {

    }

    public void getConnection()
    {
            // Load SQL Server JDBC driver and establish connection.
            System.out.print("Connecting to SQL Server ... ");
            Statement statement = null;
            try (java.sql.Connection connection = DriverManager.getConnection(connectionUrl))
            {
                System.out.println("Done.");
                try
                {
                    statement = connection.createStatement();
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }


            }
            catch (Exception e)
            {
                System.out.println(e);
            }
    }

    public ArrayList<Product> getProducts()
    {
        ArrayList<Product> products = new ArrayList<Product>();
        try
        {
            connection = DriverManager.getConnection(connectionUrl);
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM Product");

            while(res.next())
            {
                Product product;
                int code = res.getInt("code");
                String name = res.getString("name");
                int quantity = res.getInt("quantity");
                int basePrice = res.getInt("basePrice");
                String suppName = res.getString("suppName");
                int discountCode = res.getInt("dCode");
                Date date = res.getDate("date");

                product = new Product(name, quantity, basePrice, suppName, date, discountCode);
                product.setCode(code);
                products.add(product);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return products;
    }

    public ArrayList<Supplier> getSuppliers()
    {
        ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
        try
        {
            connection = DriverManager.getConnection(connectionUrl);
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM Supplier");
            while(res.next())
            {
                Supplier supplier;
                String name = res.getString("suppName");
                String phoneNbr = res.getString("phoneNbr");
                String address = res.getString("address");
                supplier = new Supplier(name, phoneNbr, address);
                suppliers.add(supplier);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return suppliers;
    }

    public ArrayList<Discount> getDiscounts()
    {
        ArrayList<Discount> discounts = new ArrayList<Discount>();
        try
        {
            connection = DriverManager.getConnection(connectionUrl);
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM Discount");
            while(res.next())
            {
                Discount discount;
                int dCode = res.getInt("dCode");
                String discountName = res.getString("discountName");
                Date startDate = res.getDate("startDate");
                Date endDate = res.getDate("endDate");
                int percentage = res.getInt("percentage");
                discount = new Discount(dCode, discountName, startDate, endDate, percentage);
                discounts.add(discount);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return discounts;
    }

    public void addProduct(Product product)
    {
        try {
            connection = DriverManager.getConnection(connectionUrl);
            String query = "{call AddProduct(?, ?, ?)}";
            CallableStatement statement = connection.prepareCall(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void editQuantity(int quantity, String productID)
    {

    }

    public void removeProduct(String productID)
    {

    }

    /*public Product getProducts(String query)
    {
        return; // code
    }

     */

    public void addDiscount()
    {
        // code
    }

}
