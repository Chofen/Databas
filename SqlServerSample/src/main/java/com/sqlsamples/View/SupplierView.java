package com.sqlsamples.View;

import com.sqlsamples.Model.Supplier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SupplierView extends JPanel
{
    ArrayList<Supplier> suppliers;
    JButton btnAddSupplier = new JButton("Add Supplier");
    AddSupplierListener addSupplierListener = new AddSupplierListener();
    JLabel lblName = new JLabel("Name");
    JLabel lblPhoneNbr = new JLabel("Phone Number");
    JLabel lblAddress = new JLabel("Address");
    JLabel lblSupplier = new JLabel("[SUPPLIER]");

    JTextField tfName = new JTextField();
    JTextField tfPhoneNbr = new JTextField();
    JTextField tfAddress = new JTextField();

    public SupplierView(MainView mainView, ArrayList<Supplier> suppliers)
    {
        this.setPreferredSize(new Dimension(700, 100));
        this.suppliers = suppliers;
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        btnAddSupplier.addActionListener(addSupplierListener);

        lblSupplier.setPreferredSize(new Dimension(100, 25));
        lblName.setPreferredSize(new Dimension(75, 25));
        tfName.setPreferredSize(new Dimension(150, 25));
        lblPhoneNbr.setPreferredSize(new Dimension(100, 25));
        tfPhoneNbr.setPreferredSize(new Dimension(150, 25));
        lblAddress.setPreferredSize(new Dimension(75, 25));
        tfAddress.setPreferredSize(new Dimension(150, 25));

        add(lblSupplier);
        add(lblName);
        add(tfName);
        add(lblPhoneNbr);
        add(tfPhoneNbr);
        add(lblAddress);
        add(tfAddress);
        add(btnAddSupplier);
        this.setVisible(true);
    }

    private class AddSupplierListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {

        }
    }



}
