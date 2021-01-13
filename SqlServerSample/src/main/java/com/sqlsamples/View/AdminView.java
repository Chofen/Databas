package com.sqlsamples.View;

import com.sqlsamples.Control.ConnectionSQL;
import com.sqlsamples.Model.Customer;
import com.sqlsamples.Model.Discount;
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
    ConnectionSQL connection;
    HistoryView historyView;
    DiscountView discountView;
    OrderView orderView;

    public AdminView(MainView mainView, ConnectionSQL connectionSQL)
    {
        this.connection = connectionSQL;
        this.mainView = mainView;
        productView = new ProductView(this);
        supplierView = new SupplierView(this);
        discountView = new DiscountView(this);
        setLayout(new BorderLayout());
        add(supplierView, BorderLayout.NORTH);
        add(productView, BorderLayout.CENTER);
        add(discountView, BorderLayout.SOUTH);
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

    public void showOrders()
    {
        orderView = new OrderView(connection.getOrders(), this);
        JOptionPane.showMessageDialog(orderView, orderView);
    }

    public void editQuantity(int quantity, int productID)
    {
        connection.editQuantity(quantity, productID);
        mainView.refresh();
    }


    public void showHistory()
    {
        historyView = new HistoryView(connection.getDiscountHistory());
        JOptionPane.showMessageDialog(null, historyView);
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

    public void addSupplier(Supplier supplier)
    {
        connection.addSupplier(supplier);
    }

    public void addDiscount(Discount discount)
    {
        connection.addDiscount(discount);
    }

    public void acceptOrder(int orderNumber)
    {
        connection.acceptOrder(orderNumber);
    }

}
