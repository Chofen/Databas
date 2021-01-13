package com.sqlsamples.View;

import com.sqlsamples.Control.ConnectionSQL;
import com.sqlsamples.Model.Product;
import com.sqlsamples.View.LoginView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerView extends JPanel
{
    ConnectionSQL connection;
    String result;
    LoginView loginView;
    ButtonListener addButtonListener = new ButtonListener();
    com.sqlsamples.View.MainView mainView;
    JTextField tfCode = new JTextField();
    JTextField tfName = new JTextField();
    JTextField tfSupplier = new JTextField();
    JTextField tfPrice = new JTextField();
    JLabel lblName = new JLabel("name:");
    JLabel lblCode = new JLabel("Code:");
    JLabel lblSupplier = new JLabel("Supplier:");
    JLabel lblPrice = new JLabel("Price:");
    JList listProducts = new JList();



    JTextArea taResult =new JTextArea(result);

    JButton btnGetList = new JButton("Get List");

    JPanel rightPanel = new JPanel();
    JPanel leftPanel = new JPanel();




    public CustomerView(MainView mainView) {

        this.loginView = loginView;
        this.mainView = mainView;
        setSize(new Dimension(800, 600));

        rightPanel.setPreferredSize(new Dimension(400, 600));
        leftPanel.setPreferredSize(new Dimension(400, 600));
        btnGetList.setPreferredSize(new Dimension(150,35));
        tfPrice.setPreferredSize(new Dimension(100,25));
        tfCode.setPreferredSize(new Dimension(100,25));
        tfName.setPreferredSize(new Dimension(100,25));
        tfSupplier.setPreferredSize(new Dimension(100,25));
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));


        btnGetList.addActionListener(addButtonListener);

        add(lblName);
        add(tfName);
        add(lblCode);
        add(tfCode);
        add(tfPrice);
        add(lblSupplier);
        add(tfSupplier);
        add(lblPrice);
        add(tfPrice);
        add(btnGetList);
        add(taResult);
        setBackground(Color.GREEN);
        setVisible(true);

    }


    private void addToList()
    {
        String name = tfName.getText();
        int price = Integer.parseInt(tfPrice.getText());
        int code = Integer.parseInt(tfCode.getText());
        String supplier = tfSupplier.getText();

    }
    public void addProduct(Product product)
    {
        connection.addProduct(product);
        mainView.refresh();
    }
    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

}


