package com.company;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class JOINFunction {
    public int Join(Connection connection, ArrayList<String> columnsTableAuto, ArrayList<String> columnsTableClients, ArrayList<String> columnsTableDealind, ArrayList<String> columnsTableGoods, ArrayList<String> columnsTableRegister, ArrayList<String> columnsTableRemont, ArrayList<String> tableName) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet;
            ArrayList<String> columnNames = new ArrayList<>();
            String columnName;
            DataEntry dataEntry = new DataEntry();
            Communications communications = new Communications();
            String executeString = "select ";
            for (String column : columnsTableAuto) {
                executeString += "auto." + column + ",";
            }
            for (String column : columnsTableClients) {
                executeString += "client." + column + ",";
            }
            for (String column : columnsTableDealind) {
                executeString += "dealind." + column + ",";
            }
            for (String column : columnsTableGoods) {
                executeString += "goods." + column + ",";
            }
            for (String column : columnsTableRegister) {
                executeString += "register." + column + ",";
            }
            for (String column : columnsTableRemont) {
                executeString += "remont." + column + ",";
            }
            executeString = executeString.replaceFirst(".$", "");
            executeString += " from " + tableName.get(0) + " ";
            if (tableName.size() > 1) {
                for (int j = 0; j < tableName.size(); j++) {
                    for (int k = j + 1; k < tableName.size(); k++) {
                        columnName = communications.Communication(tableName.get(j), tableName.get(k));
                        if (columnName != null) {
                            executeString += "join " + tableName.get(k) + " " + "on " + tableName.get(j) + "." + columnName + "=" + tableName.get(k) + "." + columnName + " ";
                        }
                    }
                }
            }
            executeString = executeString.replaceFirst(".$", "");
            resultSet = statement.executeQuery(executeString);
            columnNames.addAll(columnsTableClients);
            columnNames.addAll(columnsTableAuto);
            columnNames.addAll(columnsTableRegister);
            columnNames.addAll(columnsTableDealind);
            columnNames.addAll(columnsTableRemont);
            columnNames.addAll(columnsTableGoods);
            while (resultSet.next()) {
                for (String value : columnNames
                        ) {
                    dataEntry.set(resultSet.getString(value));
                }
            }
            statement.execute(executeString);
            JOINFormTable joinFormTable = new JOINFormTable();
            joinFormTable.Gui(columnNames, dataEntry.get());
            return 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "В вашем выборе существует не связанные таблицы!");
            return 1;
        }
    }
}
