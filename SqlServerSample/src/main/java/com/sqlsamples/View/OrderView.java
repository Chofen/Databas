package com.sqlsamples.View;

import com.sqlsamples.Model.DiscountHistory;
import com.sqlsamples.Model.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

public class OrderView extends JPanel
{
    ArrayList<Order> orders;
    JTable orderTable;
    JButton btnAccept = new JButton("Accept order");
    AdminView adminView;

    AcceptListener acceptListener = new AcceptListener();

    public OrderView(ArrayList<Order> orders, AdminView adminView)
    {
        this.adminView = adminView;
        this.orders = orders;
        btnAccept.addActionListener(acceptListener);
        add(btnAccept);
        addTable();
        isVisible();
    }

    private void addTable()
    {
        String[][] orderData = new String[100][100];
        String[] orderTableNames = {"Order code", "Product code", "Product", "Base Price", "Supplier",
                "Discount code", "OrderDate", "Customer", "Status" };
        for (int i = 0; i < orders.size(); i++)
        {
            orderData[i] =  orders.get(i).toStringArray();
        }
        orderTable = new JTable(orderData, orderTableNames);
        orderTable.setPreferredSize(new Dimension(1200, 1000));
        this.add(new JScrollPane(orderTable));
    }

    private class AcceptListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            int orderNumber = Integer.parseInt(JOptionPane.showInputDialog("Order Number:"));
            adminView.acceptOrder(orderNumber);
        }
    }

}