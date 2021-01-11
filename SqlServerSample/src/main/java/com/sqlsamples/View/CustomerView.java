package com.sqlsamples.View;

import com.sqlsamples.Model.Product;

import javax.swing.*;
import java.awt.*;

public class CustomerView extends JFrame
{
    MainView mainView;
    JPanel upperPanelRight = new JPanel();
    JPanel upperPanelLeft = new JPanel();
    JPanel underPanel = new JPanel();

    public CustomerView(MainView mainView)
    {
        this.mainView = mainView;
        setSize(new Dimension(800, 600));
        setLayout(new BorderLayout());
        upperPanelRight.setPreferredSize(new Dimension(400 ,400));
        upperPanelLeft.setPreferredSize(new Dimension(400, 300));
        underPanel.setPreferredSize(new Dimension(800, 300));

        upperPanelRight.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        upperPanelLeft.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        underPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        add(upperPanelRight, BorderLayout.WEST);
        add(upperPanelLeft, BorderLayout.EAST);
        add(underPanel, BorderLayout.SOUTH);
        setBackground(Color.GREEN);
        setVisible(true);
    }

}

