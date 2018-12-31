package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;


public class TableForm {
    private JPanel panel;
    private JButton addButton;
    private JButton deleteButton;
    private JButton exitButton;
    private JTable table;
    private JFrame frame;
    private int flag = 0;
    private DefaultTableModel dtm = (DefaultTableModel) table.getModel();
    Actions actions = new Actions();
    private String oldValue;

    private void Frame() {
        frame = new JFrame("table");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(600, 500));
        table.setModel(dtm);
        frame.add(panel);
        frame.setVisible(true);
    }

    private void table(ArrayList<String> columnsName, ArrayList<String> values) {
        Table table = new Table();
        table.FormationTable(columnsName, values, dtm);
    }

    private void Action(ArrayList<String> values, String tableName, ArrayList<String> columnsName) {
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if (table.columnAtPoint(mouseEvent.getPoint()) == 0) {
                    JOptionPane.showMessageDialog(null, "Нельзя редактировать данный столбец");
                } else {
                    oldValue = (String) table.getModel().getValueAt(table.getSelectedRow(), table.getSelectedColumn());
                }
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
        addButton.addActionListener(actionEvent -> {
            AddAutoForm addAutoForm = new AddAutoForm();
            AddRemontForm addRemontForm = new AddRemontForm();
            AddDealindForm addDealindForm = new AddDealindForm();
            AddClientsForm addClientsForm = new AddClientsForm();
            AddGoodsForm addGoodsForm = new AddGoodsForm();
            AddRegisterForm addRegisterForm = new AddRegisterForm();
            switch (tableName) {
                case "auto": {
                    addAutoForm.Gui();
                    break;
                }
                case "remont": {
                    addRemontForm.Gui();
                    break;
                }
                case "dealind": {
                    addDealindForm.Gui();
                    break;
                }
                case "clients": {
                    addClientsForm.Gui();
                    break;
                }
                case "goods": {
                    addGoodsForm.Gui();
                    break;
                }
                case "register": {
                    addRegisterForm.Gui();
                    break;
                }
                default: {
                    break;
                }
            }
            frame.dispose();
        });
        deleteButton.addActionListener((ActionEvent e) -> {
            String[] id = new String[values.size() / columnsName.size()];
            int i = 0;
            try {
                do {
                    flag = 1;
                    id[i] = dtm.getValueAt(table.getSelectedRow(), 0).toString();
                    dtm.removeRow(table.getSelectedRow());
                    i = i + 1;
                }
                while (table.getSelectedRow() != -1);
                actions.Delete(tableName, id);
            } catch (ArrayIndexOutOfBoundsException ex) {
                JOptionPane.showMessageDialog(null, "Вы не выбрали строк для удаления!");
            }
        });
        exitButton.addActionListener(e -> {
            ReadForm readForm = new ReadForm();
            readForm.Gui();
            frame.dispose();
        });
        dtm.addTableModelListener(e -> {
            if (flag == 0) {
                String value = (String) table.getModel().getValueAt(e.getFirstRow(),
                        e.getColumn());
                int error=actions.Update(tableName, table.getColumnName(e.getColumn()), value, dtm.getValueAt(table.getSelectedRow(), 0).toString());
            if(error==1){
                table.setValueAt(oldValue,e.getFirstRow(),e.getColumn());
            }
            } else {
                flag = 0;
            }
        });
    }

    public void Gui(ArrayList<String> columnsName, ArrayList<String> values, String tableName) {
        Frame();
        table(columnsName, values);
        Action(values, tableName, columnsName);
    }
}