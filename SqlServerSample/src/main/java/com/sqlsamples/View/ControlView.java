package com.sqlsamples.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlView extends JFrame
{
    private JButton btnRefresh = new JButton("Refresh");
    private JButton editStock = new JButton("Edit stock");
    private TableView tableView;

    public ControlView(TableView tableView)
    {
        this.tableView = tableView;
        this.setPreferredSize(new Dimension());
        this.add(btnRefresh);
        this.add(editStock);
        this.setVisible(true);
    }

    private class btnRefreshListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {

        }
    }
}
