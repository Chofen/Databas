package com.sqlsamples.View;

import com.sqlsamples.View.AdminView;
import com.sqlsamples.View.CustomerView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JPanel {
    MainView mainView;
    String firstname = "";
    String lastname = "";
    String email = "";
    String address = "";
    String city = "";
    String country = "";
    String phone = "";

    JTextField tfUserName = new JTextField();
    JTextField tfPassword = new JTextField();
    JLabel lblUsername = new JLabel("Username");
    JLabel lblPassword = new JLabel("Password");
    JButton btnLogin = new JButton("Login");

    ButtonListener buttonListener = new ButtonListener();

    public LoginView(MainView mainView) {
        this.mainView = mainView;
        setLayout(new FlowLayout());
        setSize(300, 300);
        lblUsername.setPreferredSize(new Dimension(200, 50));
        tfUserName.setPreferredSize(new Dimension(200, 50));
        lblPassword.setPreferredSize(new Dimension(200, 50));
        tfPassword.setPreferredSize(new Dimension(200, 50));
        btnLogin.setPreferredSize(new Dimension(100, 50));
        btnLogin.addActionListener(buttonListener);
        add(lblUsername);
        add(tfUserName);
        add(lblPassword);
        add(tfPassword);
        add(btnLogin);
        setVisible(true);
    }


    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (!tfPassword.getText().isEmpty() && !tfUserName.getText().isEmpty()) {
                if (tfPassword.getText().equals("admin") && tfUserName.getText().equals("admin")) {
                    btnLogin.setVisible(false);

                    mainView.login(true); // admin
                    lblUsername.setText("Logged in as ADMIN");
                } else {

                    btnLogin.setVisible(false);
                    mainView.login(false); // user
                    lblUsername.setText("Logged in as USER");

                    firstname = JOptionPane.showInputDialog("Enter Firstname");
                    lastname = JOptionPane.showInputDialog("Enter Lastname");
                    email = JOptionPane.showInputDialog("Enter Email");
                    address = JOptionPane.showInputDialog("Enter Address");
                    city = JOptionPane.showInputDialog("Enter City");
                    country = JOptionPane.showInputDialog("Enter Country");
                    phone = JOptionPane.showInputDialog("Enter Phone");
                    System.out.println(firstname);

                }

                tfPassword.setVisible(false);
                tfUserName.setVisible(false);

                lblPassword.setText("Press [OK] to proceed...");
            }
        }
    }
}