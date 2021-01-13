package com.sqlsamples.View;

import com.sqlsamples.Control.ConnectionSQL;
import com.sqlsamples.Model.Customer;
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
    
    public MainView(ConnectionSQL connection, boolean login)
    {
        this.connection = connection;
        setLayout(new BorderLayout());
        tableView = new TableView(connection.getSuppliers(), connection.getProducts(), connection.getDiscounts());
        tableView.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setSize(1400, 800);
        if (login)
        {
            loginView = new LoginView(this);
            JOptionPane.showInternalMessageDialog(null, loginView);
        }
        else
        {
           login(true);
        }

        setVisible(true);
    }

    public void login(boolean admin)
    {
        if (admin)
        {
            adminView = new AdminView(this, connection);
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

    public void addCustomer(Customer customer)
    {
        customerView.addCustomer(customer);
    }


    public void refresh()
    {
        dispose();
        MainView mainView = new MainView(connection, false);
    }
}
