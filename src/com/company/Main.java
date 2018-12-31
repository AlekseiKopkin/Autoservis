package com.company;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import javax.swing.*;
import java.sql.*;

public class Main {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "aleks";
    private static final String URL = "jdbc:mysql://localhost:3306/autoservis";

    static Connection Connection() {   // Создание связи с базой данных
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ошибка связи с бд!");
            return null;
        }
    }

    public static void main(String[] args) {
        ReadForm readForm = new ReadForm();   //Вызов формы с запросом наименования таблицы
        readForm.Gui();
    }
}
