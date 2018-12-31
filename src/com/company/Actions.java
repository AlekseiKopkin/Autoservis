package com.company;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import static com.company.Main.Connection;

public class Actions {
    private FourFunction fourFunction = new FourFunction();
    private ArrayList<String> columnsName = new ArrayList<>();

    public int Read(String tableName) {
        switch (tableName) {
            case "auto":
                columnsName.add("auto_id");
                columnsName.add("marka");
                columnsName.add("probeg");
                columnsName.add("color");
                columnsName.add("client_id");
                return fourFunction.Read(Connection(), tableName, columnsName);
            case "remont":
                columnsName.add("remont_id");
                columnsName.add("price");
                columnsName.add("auto_id");
                columnsName.add("breaking");
                columnsName.add("date_in");
                columnsName.add("date_out");
                return fourFunction.Read(Connection(), tableName, columnsName);
            case "client":
                columnsName.add("client_id");
                columnsName.add("name");
                columnsName.add("fam");
                columnsName.add("otch");
                columnsName.add("seria");
                columnsName.add("nomer");
                return fourFunction.Read(Connection(), tableName, columnsName);
            case "dealind":
                columnsName.add("dealind_id");
                columnsName.add("goods_id");
                columnsName.add("client_id");
                columnsName.add("date_buy");
                return fourFunction.Read(Connection(), tableName, columnsName);
            case "goods":
                columnsName.add("goods_id");
                columnsName.add("name");
                columnsName.add("price");
                columnsName.add("status");
                return fourFunction.Read(Connection(), tableName, columnsName);
            case "register":
                columnsName.add("register_id");
                columnsName.add("client_id");
                columnsName.add("register_date");
                return fourFunction.Read(Connection(), tableName, columnsName);
            default:
                JOptionPane.showMessageDialog(null, "Нет такой таблицы!");
                return 1;
        }
    }

    public void Delete(String tableName, String[] id) {
        fourFunction.Delete(Connection(), tableName, tableName + "_id", id);
    }

    public int Update(String tableName, String columnName, String value, String idNomer) {
        return fourFunction.Update(Connection(), tableName, columnName, value, tableName + "_id", idNomer);
    }
}














































