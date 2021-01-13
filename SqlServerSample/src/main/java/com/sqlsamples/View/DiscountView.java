package com.sqlsamples.View;

import javax.swing.*;
import java.awt.*;

public class DiscountView extends JPanel
{
    JLabel lblName = new JLabel("Name");
    JLabel lblPercentage = new JLabel("Percentage");
    JLabel lblCode = new JLabel("Code");
    JLabel lblStartDate = new JLabel("Start date");
    JLabel lblEndDate = new JLabel("End date");

    JTextField tfName = new JTextField();
    JTextField tfPercentage = new JTextField();
    JTextField tfCode = new JTextField();
    JTextField tfStartDate = new JTextField();
    JTextField tfEndDate = new JTextField();
    AdminView adminView;

    public DiscountView(AdminView adminView)
    {
        this.adminView = adminView;
        setPreferredSize(new Dimension(700, 100));
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        lblCode.setPreferredSize(new Dimension(100, 25));
        tfCode.setPreferredSize(new Dimension(100, 25));
        lblName.setPreferredSize(new Dimension(100, 25));
        tfName.setPreferredSize(new Dimension(100, 25));
        lblStartDate.setPreferredSize(new Dimension(100, 25));
        tfEndDate.setPreferredSize(new Dimension(100, 25));
        lblEndDate.setPreferredSize(new Dimension(100, 25));
        tfStartDate.setPreferredSize(new Dimension(100, 25));
        lblPercentage.setPreferredSize(new Dimension(100, 25));
        tfPercentage.setPreferredSize(new Dimension(100, 25));

        add(lblCode);
        add(tfCode);
        add(lblName);
        add(tfName);
        add(lblStartDate);
        add(tfStartDate);
        add(lblEndDate);
        add(tfEndDate);
        add(lblPercentage);
        add(tfPercentage);
        setVisible(true);
    }
}
