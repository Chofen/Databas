package com.sqlsamples.View;

import com.sqlsamples.Model.Discount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class DiscountView extends JPanel
{
    JLabel lblName = new JLabel("Name");
    JLabel lblPercentage = new JLabel("Percentage");
    JLabel lblStartDate = new JLabel("Start date");
    JLabel lblEndDate = new JLabel("End date");

    AddListener addListener = new AddListener();

    JTextField tfName = new JTextField();
    JTextField tfPercentage = new JTextField();
    JTextField tfStartDate = new JTextField();
    JTextField tfEndDate = new JTextField();

    JButton btnAddDiscount = new JButton("Add discount");
    AdminView adminView;

    public DiscountView(AdminView adminView)
    {
        this.adminView = adminView;
        setPreferredSize(new Dimension(700, 100));
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        btnAddDiscount.addActionListener(addListener);
        lblName.setPreferredSize(new Dimension(100, 25));
        tfName.setPreferredSize(new Dimension(100, 25));
        lblStartDate.setPreferredSize(new Dimension(100, 25));
        tfEndDate.setPreferredSize(new Dimension(100, 25));
        lblEndDate.setPreferredSize(new Dimension(100, 25));
        tfStartDate.setPreferredSize(new Dimension(100, 25));
        lblPercentage.setPreferredSize(new Dimension(100, 25));
        tfPercentage.setPreferredSize(new Dimension(100, 25));
        btnAddDiscount.setPreferredSize(new Dimension(100, 25));

        add(lblName);
        add(tfName);
        add(lblStartDate);
        add(tfStartDate);
        add(lblEndDate);
        add(tfEndDate);
        add(lblPercentage);
        add(tfPercentage);
        add(btnAddDiscount);
        setVisible(true);
    }

    private class AddListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String name = tfName.getText();
            Date startDate = Date.valueOf(tfStartDate.getText());
            Date endDate = Date.valueOf(tfEndDate.getText());
            int percentage = Integer.parseInt(tfPercentage.getText());
            Discount discount = new Discount(name, startDate, endDate, percentage);
            adminView.addDiscount(discount);
        }
    }
}
