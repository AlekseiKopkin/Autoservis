package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class JOINFormTable {
    private JPanel panel;
    private JTable table;
    private JButton exitButton;
    private JFrame frame;
    private DefaultTableModel dtm = (DefaultTableModel) table.getModel();

    private void Frame() {
        frame = new JFrame("Table");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(600, 500));
        table.setDefaultEditor(Object.class, null);
        frame.add(panel);
        frame.setVisible(true);
    }

    private void Table(ArrayList<String> columnsName, ArrayList<String> values) {
        Table table = new Table();
        table.FormationTable(columnsName, values, dtm);
    }

    public void Gui(ArrayList<String> columnsName, ArrayList<String> values) {
        Frame();
        Table(columnsName, values);
        Action();
    }

    private void Action() {
        exitButton.addActionListener(e -> {
            JOINForm joinForm = new JOINForm();
            joinForm.Gui();
            frame.dispose();
        });
    }
}