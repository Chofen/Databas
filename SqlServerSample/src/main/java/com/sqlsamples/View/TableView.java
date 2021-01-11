package com.sqlsamples.View;

import com.sqlsamples.Model.Discount;
import com.sqlsamples.Model.Product;
import com.sqlsamples.Model.Supplier;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.ArrayList;

public class TableView extends JPanel
{
    private ArrayList<Supplier> suppliers;
    private ArrayList<Product> products;
    private ArrayList<Discount> discounts;
    private JTable supplierTable;
    private JTable productTable;
    private JTable discountTable;

    private JLabel lblSupplier = new JLabel("Supplier");
    private JLabel lblProduct = new JLabel("Product");
    private JLabel lblDiscount = new JLabel("Discount");

    public TableView(ArrayList<Supplier> suppliers, ArrayList<Product> products, ArrayList<Discount> discounts)
    {
        this.suppliers = suppliers;
        this.products = products;
        this.discounts = discounts;
        setLayout(new BorderLayout());
        setupTables();
        setSize(1400, 500);
        lblSupplier.setPreferredSize(new Dimension(100, 50));
        lblProduct.setPreferredSize(new Dimension(100, 50));
        lblDiscount.setPreferredSize(new Dimension(100, 50));
        supplierTable.setPreferredSize(new Dimension(400, 300));
        productTable.setPreferredSize(new Dimension(500, 300));
        discountTable.setPreferredSize(new Dimension(300, 300));

        productTable.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(
                Color.BLACK), "Product", 5, 5));

        supplierTable.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(
                Color.BLACK), "Supplier", 5, 5));

        discountTable.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(
                Color.BLACK), "Discount", 5, 5));

        setVisible(true);
    }

    public void setupTables() {
        String[][] supplierData = new String[100][100];
        String[] supplierTableNames = {"Name", "Phone Number", "Address"};
        for (int i = 0; i < suppliers.size(); i++)
        {
            supplierData[i] =  suppliers.get(i).toStringArray();
        }
        supplierTable = new JTable(supplierData, supplierTableNames);
        this.add(new JScrollPane(supplierTable), BorderLayout.WEST);

        String[][] productData = new String[100][100];
        String[] productTableNames = {"Code", "Name", "Quantity", "Base Price", "Supplier", "Discount"};
        for (int i = 0; i < products.size(); i++)
        {
            productData[i] = products.get(i).toStringArray();
        }
        productTable = new JTable(productData, productTableNames);
        this.add(new JScrollPane(productTable), BorderLayout.CENTER);
        String[][] discountData = new String[100][100];
        String[] discountTableNames = {"Code", "Name", "Start Date", "End Date", "Percentage"};
        for (int i = 0; i < discounts.size(); i++)
        {
            discountData[i] = discounts.get(i).toStringArray();
        }
        discountTable = new JTable(discountData, discountTableNames);
        this.add(new JScrollPane(discountTable), BorderLayout.EAST);
    }



   
}
