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
    MainView mainView;
    JButton btnAddProduct = new JButton("Add Product");
    AddProductListener addProductListener = new AddProductListener();
    EditProductListener editProductListener = new EditProductListener();

    JLabel lblProduct = new JLabel("[PRODUCT]");
    JLabel lblProName = new JLabel("Name");
    JLabel lblProQuantity = new JLabel("Quantity");
    JLabel lblBasePrice = new JLabel("Base Price");
    JLabel lblSupplierName = new JLabel("Supplier");
    JLabel lblDate = new JLabel("Date");
    JLabel lblDisscount = new JLabel("Discount");

    JTextField tfProName = new JTextField();
    JTextField tfProQuantity = new JTextField();
    JTextField tfBasePrice = new JTextField();
    JTextField tfSupplier = new JTextField();
    JTextField tfDate = new JTextField();
    JTextField tfDiscount = new JTextField();

    JButton btnEditQuantity = new JButton("Edit");

    public ProductView(MainView mainView)
    {
        this.mainView = mainView;
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(700, 100));
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        btnEditQuantity.setPreferredSize(new Dimension(100, 25));
        btnEditQuantity.addActionListener(editProductListener);
        
        btnAddProduct.addActionListener(addProductListener);
        lblProduct.setPreferredSize(new Dimension(100, 25));
        lblProName.setPreferredSize(new Dimension(75, 25));
        lblProQuantity.setPreferredSize(new Dimension(100, 25));
        lblBasePrice.setPreferredSize(new Dimension(75, 25));
        lblSupplierName.setPreferredSize(new Dimension(100, 25));
        lblDate.setPreferredSize(new Dimension(75, 25));
        lblDisscount.setPreferredSize(new Dimension(75, 25));
        tfBasePrice.setPreferredSize(new Dimension(150, 25));
        tfDate.setPreferredSize(new Dimension(150, 25));
        tfDiscount.setPreferredSize(new Dimension(150, 25));
        tfProName.setPreferredSize(new Dimension(150, 25));
        tfProQuantity.setPreferredSize(new Dimension(150, 25));
        tfSupplier.setPreferredSize(new Dimension(150, 25));
        btnAddProduct.setPreferredSize(new Dimension(150, 25));
        JButton btnEditQuantity = new JButton("EDIT");
        EditProductListener editSupplierListener = new EditProductListener();
        btnEditQuantity.addActionListener(editProductListener);

        add(lblProduct);
        add(lblProName);
        add(tfProName);
        add(lblProQuantity);
        add(tfProQuantity);
        add(lblBasePrice);
        add(tfBasePrice);
        add(lblSupplierName);
        add(tfSupplier);
        add(lblDate);
        add(tfDate);
        add(lblDisscount);
        add(tfDiscount);
        add(btnEditQuantity);
        add(btnAddProduct);
        setVisible(true);
    }

    private void addProduct()
    {
        String name = tfProName.getText();
        int quantity = Integer.parseInt(tfProQuantity.getText());
        int basePrice = Integer.parseInt(tfBasePrice.getText());
        String supplier = tfSupplier.getText();
        Date date = null;
        Product product = null;
        int discount = Integer.parseInt(tfDiscount.getText());
        try {
            date = Date.valueOf(tfDate.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            product = new Product(name, quantity, basePrice, supplier, date, discount);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        mainView.addProduct(product);
    }

    private class AddProductListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            addProduct();
        }
    }

    private class EditProductListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            int quantity  = Integer.parseInt(JOptionPane.showInputDialog("Quantity (new value):"));
            //mainView.editQuantity(quantity);
        }
    }
}
