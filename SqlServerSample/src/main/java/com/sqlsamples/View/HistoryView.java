package com.sqlsamples.View;

import com.sqlsamples.Model.Discount;
import com.sqlsamples.Model.DiscountHistory;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HistoryView extends JPanel
{
    ArrayList<DiscountHistory> discountHistories;
    JTable discountHistoryTable;

    public HistoryView(ArrayList<DiscountHistory> discountHistories)
    {
        this.discountHistories = discountHistories;
        addTable();
        isVisible();
    }

    private void addTable()
    {
        String[][] discountHistoryData = new String[100][100];
        String[] discountHistoryTableNames = {"Code", "Product Name", "Discount Name", "Date"};
        for (int i = 0; i < discountHistories.size(); i++)
        {
            discountHistoryData[i] =  discountHistories.get(i).toStringArray();
        }
        discountHistoryTable = new JTable(discountHistoryData, discountHistoryTableNames);
        this.add(new JScrollPane(discountHistoryTable));
    }


}
