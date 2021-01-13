package com.sqlsamples.View;

import com.sqlsamples.Control.ConnectionSQL;
import com.sqlsamples.Model.Customer;
import com.sqlsamples.Model.Product;
import com.sqlsamples.Model.Supplier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminView extends JPanel
{
    MainView mainView;

    ProductView productView;
    SupplierView supplierView;
    ControlView controlView;
    ConnectionSQL connection;
    HistoryView historyView;

    public AdminView(MainView mainView, ConnectionSQL connectionSQL)
    {
        this.connection = connectionSQL;
        this.mainView = mainView;
        productView = new ProductView(this);
        supplierView = new SupplierView(this);
        setLayout(new BorderLayout());
        add(supplierView, BorderLayout.NORTH);
        add(productView, BorderLayout.CENTER);
        setBackground(Color.RED);
        setVisible(true);
    }

    public void addProduct(Product product)
    {
        connection.addProduct(product);
        mainView.refresh();
    }

    public void deleteProduct(int code)
    {
        connection.deleteProduct(code);
        mainView.refresh();
    }

    public void editQuantity(int quantity, int productID)
    {
        connection.editQuantity(quantity, productID);
        mainView.refresh();
    }

    public void removeProduct(String productID)
    {

    }

    public void showHistory()
    {
        historyView = new HistoryView(connection.getDiscountHistory());
        JOptionPane.showMessageDialog(null, historyView);
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

    public void search()
    {
        int code = Integer.parseInt(JOptionPane.showInputDialog(null, "Code:"));
        String name = JOptionPane.showInputDialog(null, "Name:");
        String supplier = JOptionPane.showInputDialog(null, "Supplier");
        connection.search(code, name, supplier);

    }

    public void addCustomer(Customer customer)
    {
        connection.addCustomer(customer);
    }
}
