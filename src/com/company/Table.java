package com.company;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Table {
    public void FormationTable(ArrayList<String> columnsName, ArrayList<String> values, DefaultTableModel dtm) {
        String[] NameColumn = columnsName.toArray(new String[columnsName.size()]);
        String[] mass = values.toArray(new String[values.size()]);
        String[] mas = new String[columnsName.size()];
        for (int i = 0; i < columnsName.size(); i++) {
            dtm.addColumn(NameColumn[i]);
        }
        int k = 0;
        for (int j = 0; j < values.size() / columnsName.size(); j++) {
            for (int i = 0; i < columnsName.size(); i++) {
                mas[i] = mass[k];
                k = k + 1;
            }
            dtm.addRow(mas);
        }
    }
}
