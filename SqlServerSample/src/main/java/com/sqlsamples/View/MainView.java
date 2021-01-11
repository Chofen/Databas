package com.sqlsamples.View;

import com.sqlsamples.Control.ConnectionSQL;
import com.sqlsamples.Model.Product;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame
{
    ConnectionSQL connection;

    LoginView loginView;
    CustomerView customerView;
    AdminView adminView;
    TableView tableView;
    
    public MainView(ConnectionSQL connection)
    {
        this.connection = connection;
        setLayout(new BorderLayout());
        loginView = new LoginView(this);
        tableView = new TableView(connection.getSuppliers(), connection.getProducts(), connection.getDiscounts());
        JOptionPane.showInternalMessageDialog(null, loginView);
        tableView.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        setSize(1400, 800);
        setVisible(true);
    }

    public void login(boolean admin)
    {
        if (admin)
        {
            adminView = new AdminView(this, connection.getSuppliers());
            add(adminView);
            this.setTitle("Admin Edition");
        }
        else
        {
            customerView = new CustomerView(this);
            add(customerView);
            this.setTitle("User Edition");
        }

        add(tableView, BorderLayout.SOUTH); // show table when user has logged in
    }

    public void addProduct(Product product)
    {
        connection.addProduct(product);
    }

    public void editQuantity(int quantity, String productID)
    {
        connection.editQuantity(quantity, productID);
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
