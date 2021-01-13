package com.sqlsamples.View;

import com.sqlsamples.Control.ConnectionSQL;
import com.sqlsamples.Model.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ProductView extends JPanel
{
    AdminView adminView;
    JButton btnAddProduct = new JButton("Add Product");
    AddProductListener addProductListener = new AddProductListener();
    EditProductListener editProductListener = new EditProductListener();
    DeleteProductListener deleteProductListener = new DeleteProductListener();
    HistoryListener historyListener = new HistoryListener();
    SearchListener searchListener = new SearchListener();
    OrderListener orderListener = new OrderListener();

    JLabel lblProduct = new JLabel("[PRODUCT]");
    JLabel lblProName = new JLabel("Name");
    JLabel lblProQuantity = new JLabel("Quantity");
    JLabel lblBasePrice = new JLabel("Base Price");
    JLabel lblSupplierName = new JLabel("Supplier");
    JLabel lblDisscount = new JLabel("Discount");

    JTextField tfProName = new JTextField();
    JTextField tfProQuantity = new JTextField();
    JTextField tfBasePrice = new JTextField();
    JTextField tfSupplier = new JTextField();
    JTextField tfDiscount = new JTextField();

    JButton btnEditQuantity = new JButton("Edit");
    JButton btnDeleteProduct = new JButton(("Delete"));
    JButton btnHistory = new JButton(("History"));
    JButton btnSearch = new JButton("Search");
    JButton btnOrders = new JButton("Orders");

    public ProductView(AdminView adminView)
    {
        this.adminView = adminView;
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(700, 100));
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        btnEditQuantity.setPreferredSize(new Dimension(100, 25));
        btnHistory.setPreferredSize(new Dimension(100, 25));
        btnEditQuantity.addActionListener(editProductListener);
        btnDeleteProduct.addActionListener(deleteProductListener);
        btnAddProduct.addActionListener(addProductListener);
        btnOrders.addActionListener(orderListener);
        btnHistory.addActionListener(historyListener);
        btnSearch.addActionListener(searchListener);
        lblProduct.setPreferredSize(new Dimension(100, 25));
        lblProName.setPreferredSize(new Dimension(75, 25));
        lblProQuantity.setPreferredSize(new Dimension(100, 25));
        lblBasePrice.setPreferredSize(new Dimension(75, 25));
        lblSupplierName.setPreferredSize(new Dimension(100, 25));
        lblDisscount.setPreferredSize(new Dimension(75, 25));
        tfBasePrice.setPreferredSize(new Dimension(150, 25));
        tfDiscount.setPreferredSize(new Dimension(150, 25));
        tfProName.setPreferredSize(new Dimension(150, 25));
        tfProQuantity.setPreferredSize(new Dimension(150, 25));
        tfSupplier.setPreferredSize(new Dimension(150, 25));
        btnAddProduct.setPreferredSize(new Dimension(150, 25));
        btnDeleteProduct.setPreferredSize(new Dimension(150, 25));
        btnSearch.setPreferredSize(new Dimension(150, 25));

        add(lblProduct);
        add(lblProName);
        add(tfProName);
        add(lblProQuantity);
        add(tfProQuantity);
        add(lblBasePrice);
        add(tfBasePrice);
        add(lblSupplierName);
        add(tfSupplier);
        add(lblDisscount);
        add(tfDiscount);
        add(btnEditQuantity);
        add(btnAddProduct);
        add(btnDeleteProduct);
        add(btnHistory);
        add(btnSearch);
        add(btnOrders);
        setVisible(true);
    }

    private void addProduct()
    {
        String name = tfProName.getText();
        int quantity = Integer.parseInt(tfProQuantity.getText());
        int basePrice = Integer.parseInt(tfBasePrice.getText());
        String supplier = tfSupplier.getText();
        Product product = null;
        int discount = Integer.parseInt(tfDiscount.getText());

        try {
            product = new Product(name, quantity, basePrice, supplier, discount);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        adminView.addProduct(product);
    }

    private class AddProductListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            addProduct();
        }
    }

    private class DeleteProductListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            int code = Integer.parseInt(JOptionPane.showInputDialog("Product code:"));
            adminView.deleteProduct(code);
        }
    }

    private class EditProductListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            int code = Integer.parseInt(JOptionPane.showInputDialog("Product code:"));
            int quantity  = Integer.parseInt(JOptionPane.showInputDialog("Quantity (new value):"));
            adminView.editQuantity(code, quantity);
        }
    }

    private class HistoryListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            adminView.showHistory();
        }
    }

    private class OrderListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            adminView.showOrders();
        }
    }

    private class SearchListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            adminView.search();
        }
    }
}
