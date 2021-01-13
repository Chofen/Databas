package com.sqlsamples.Control;

import com.sqlsamples.Model.*;

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
                int code = res.getInt("pCode");
                String name = res.getString("name");
                int quantity = res.getInt("quantity");
                int basePrice = res.getInt("basePrice");
                String suppName = res.getString("suppName");
                int discountCode = res.getInt("dCode");

                product = new Product(name, quantity, basePrice, suppName, discountCode);
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
                discount = new Discount(discountName, startDate, endDate, percentage);
                discount.setCode(dCode);
                discounts.add(discount);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return discounts;
    }

    public ArrayList<DiscountHistory> getDiscountHistory()
    {
        ArrayList<DiscountHistory> discountHistories = new ArrayList<DiscountHistory>();
        try
        {
            connection = DriverManager.getConnection(connectionUrl);
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM DiscountHistory");
            while(res.next())
            {
                DiscountHistory discountHistory;
                int code = res.getInt("code");
                String productName = res.getString("productName");
                String discountName = res.getString("discountName");
                Date startDate = res.getDate("startDate");
                Date endDate = res.getDate("endDate");
                int percentage = res.getInt("percentage");
                int basePrice = res.getInt("basePrice");
                int finalPrice = res.getInt("percentage");
               discountHistory = new DiscountHistory(code, productName, discountName, startDate, endDate, percentage, basePrice, finalPrice);
                discountHistories.add(discountHistory);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return discountHistories;
    }

    public ArrayList<Order> getOrders()
    {
        ArrayList<Order> orders = new ArrayList<Order>();
        try
        {
            connection = DriverManager.getConnection(connectionUrl);
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM CusOrder");
            while(res.next()) {
                Order order;
                int oCode = res.getInt("oCode");
                int pCode = res.getInt("pCode");
                String productName = res.getString("productName");
                int basePrice = res.getInt("basePrice");
                String supplierName = res.getString("suppName");
                int dCode = res.getInt("dCode");
                Date orderDate = res.getDate("orderDate");
                String customerName = res.getString("customerName");
                String orderStatus = res.getString("orderStatus");
                order = new Order(oCode, pCode, productName, basePrice, supplierName, dCode,
                        orderDate, customerName, orderStatus);
                orders.add(order);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return orders;
    }

    public void search(int code, String name, String supplier)
    {
        try {
            connection = DriverManager.getConnection(connectionUrl);
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM Product\nWHERE( name = '" + name +
                    "' AND pCode = " + code + " AND suppName = '" + supplier + "')");

            ResultSetMetaData rsmd = res.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (res.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = res.getString(i);
                    System.out.print(columnValue + " " + rsmd.getColumnName(i));
                }
                System.out.println("");
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public void addCustomer(Customer customer)
    {
        try {
            connection = DriverManager.getConnection(connectionUrl);
            String query = "{call createCustomer(?, ?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement statement = connection.prepareCall(query);
            statement.setString(1, customer.getUsername());
            statement.setString(2, customer.getFirstname());
            statement.setString(3, customer.getLastname());
            statement.setString(4, customer.getEmail());
            statement.setString(5, customer.getAddress());
            statement.setString(6, customer.getCity());
            statement.setString(7, customer.getCountry());
            statement.setString(8, customer.getPhone());
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addProduct(Product product)
    {
        try {
            connection = DriverManager.getConnection(connectionUrl);
            String query = "{call AddProduct(?, ?, ?, ?, ?)}";
            CallableStatement statement = connection.prepareCall(query);
            statement.setString(1, product.getName());
            statement.setInt(2, product.getQuantity());
            statement.setInt(3, product.getBasePrice());
            statement.setString(4, product.getSupplierName());
            statement.setInt(5, product.getDiscountCode());
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addSupplier(Supplier supplier)
    {
        try {
            connection = DriverManager.getConnection(connectionUrl);
            String query = "{call AddSupplier(?, ?, ?)}";
            CallableStatement statement = connection.prepareCall(query);
            statement.setString(1, supplier.getName());
            statement.setString(2, supplier.getPhoneNbr());
            statement.setString(3, supplier.getAddress());
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void addDiscount(Discount discount)
    {
        try {
            connection = DriverManager.getConnection(connectionUrl);
            String query = "{call AddDiscount(?, ?, ?, ?)}";
            CallableStatement statement = connection.prepareCall(query);
            statement.setString(1, discount.getName());
            statement.setDate(2, discount.getStartDate());
            statement.setDate(3, discount.getEndDate());
            statement.setInt(4, discount.getPercentage());
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void editQuantity(int productID, int quantity)
    {
        try {
            connection = DriverManager.getConnection(connectionUrl);
            String query = "{call dbo.editProductQuantity(?, ?)}";
            CallableStatement statement = connection.prepareCall(query);
            System.out.println(productID + " " + quantity);
            statement.setInt(1, productID);
            statement.setInt(2, quantity);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                System.out.println(rs.getInt("pCode"));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }

    public void deleteProduct(int productID)
    {
        try {
            connection = DriverManager.getConnection(connectionUrl);
            String query = "{call dbo.deleteProduct(?)}";
            CallableStatement statement = connection.prepareCall(query);;
            statement.setInt(1, productID);
            statement.executeQuery();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void acceptOrder(int orderNumber)
    {
        try
        {
            connection = DriverManager.getConnection(connectionUrl);
            String query = "{call changeToAccepted(?)}";
            CallableStatement statement = connection.prepareCall(query);
            statement.setInt(1, orderNumber);
            statement.executeQuery();

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }


}
