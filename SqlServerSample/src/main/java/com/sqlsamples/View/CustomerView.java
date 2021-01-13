package com.sqlsamples.View;

import com.sqlsamples.Control.ConnectionSQL;
import com.sqlsamples.Model.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerView extends JPanel
{
    JPanel pane = new JPanel();

    ConnectionSQL connection;
    String shoppingCart;
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

    DefaultListModel<String> model = new DefaultListModel<>();

    JList<String> listProducts = new JList<>(model);

    JTextArea taShoppingCart =new JTextArea(shoppingCart);


    JButton btnGetList = new JButton("Get List");
    JButton btnConfirmPurchase = new JButton ("Confirm Purchase");

    JPanel rightPanel = new JPanel();
    JPanel leftPanel = new JPanel();




    public CustomerView(MainView mainView) {

        setLayout(new FlowLayout());

        this.mainView = mainView;
        setSize(new Dimension(800, 600));

        rightPanel.setPreferredSize(new Dimension(400, 600));
        leftPanel.setPreferredSize(new Dimension(400, 600));
        btnGetList.setPreferredSize(new Dimension(150,35));
        btnConfirmPurchase.setPreferredSize(new Dimension(150,35));
        tfPrice.setPreferredSize(new Dimension(100,25));
        tfCode.setPreferredSize(new Dimension(100,25));
        tfName.setPreferredSize(new Dimension(100,25));
        tfSupplier.setPreferredSize(new Dimension(100,25));
        listProducts.setPreferredSize(new Dimension(100,25));
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
        add(taShoppingCart);
        add(btnConfirmPurchase);
        add(listProducts);
        setBackground(Color.GREEN);
        setVisible(true);

    }
    //needs work
    private void addToList()
    {
        String name = tfName.getText();
        String price = tfPrice.getText();
        String code = tfCode.getText();
        String supplier = tfSupplier.getText();
        model.addElement(name + price + code + supplier);
        try {
            model.addElement(name + price + code + supplier);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }
    /*
    behöver koppla denna till en connectionSQL så att shoppinglistan registreras
     */
    private void addToShoppingCart()
    {
        shoppingCart = listProducts.getSelectedValue();
        String input = JOptionPane.showInputDialog("How many?");
        int value = Integer.parseInt(input);
        taShoppingCart.append(shoppingCart + value);
    }



    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

}
