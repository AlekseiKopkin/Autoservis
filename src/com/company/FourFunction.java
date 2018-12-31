package com.company;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class FourFunction {
    private Statement statement = null;
    private DataEntry dataEntry = new DataEntry();

    // Добаление данных в бд
    public int Add(Connection connection, ArrayList<String> columns, String tableName, ArrayList<String> values) {
        try {
            statement = connection.createStatement();
            String executeString = "insert into autoservis." + tableName + "(";
            for (String column : columns) {
                executeString = executeString + column + ",";
            }
            executeString = executeString.replaceFirst(".$", "");
            executeString += ") values(";
            for (String value : values
                    ) {
                executeString += "'" + value + "'" + ",";
            }
            executeString = executeString.replaceFirst(".$", "");
            executeString += ");";
            statement.execute(executeString);
            Actions actions = new Actions();
            actions.Read(tableName);
            return 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Заполнены не все поля!");
            return 1;
        }
    }

    //Изменение данных в бд
    public int Update(Connection connection, String tableName, String columnName, String value, String idName, String id) {
        try {
            statement = connection.createStatement();
            String executeString = ("update autoservis." + tableName + " set " + columnName + "=" + "'" + value + "'" + " where " + idName + "=" + "'" + id + "'");
            statement.execute(executeString);
            return 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Вы ввели не привильно данные!");
            return 1;
        }
    }

    //Удаление данных в бд
    public void Delete(Connection connection, String tableName, String columnName, String[] id) {
        try {
            statement = connection.createStatement();
            int i = 0;
            do {
                String SQL = ("DELETE FROM autoservis." + tableName + " WHERE " + columnName + "=" + id[i] + "");

                statement.executeUpdate(SQL);

                i = i + 1;
            }
            while (id[i] != null);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ошибка связи с бд!");
        }
    }

    //Чтение бд
    public int Read(Connection connection, String tableName, ArrayList<String> columnName) {
        try {
            String executeString = "select * from " + tableName;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(executeString);
            while (resultSet.next()) {
                for (String value : columnName
                        ) {
                    dataEntry.set(resultSet.getString(value));
                }
            }
            TableForm frames = new TableForm();
            frames.Gui(columnName, dataEntry.get(), tableName);
            return 0;
        } catch (SQLException e) {
            return 1;
        }
    }
}







