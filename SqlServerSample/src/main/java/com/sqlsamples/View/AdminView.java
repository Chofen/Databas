package com.sqlsamples.View;

import com.sqlsamples.Control.ConnectionSQL;
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
    ArrayList<Supplier> suppliers;

    public AdminView(MainView mainView, ArrayList<Supplier> suppliers)
    {
        this.mainView = mainView;
        this.suppliers = suppliers;
        productView = new ProductView(mainView);
        supplierView = new SupplierView(mainView, suppliers);
        setLayout(new BorderLayout());
        add(supplierView, BorderLayout.NORTH);
        add(productView, BorderLayout.CENTER);
        setBackground(Color.RED);
        setVisible(true);
    }


}
