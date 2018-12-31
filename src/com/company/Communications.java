package com.company;

public class Communications {
    public String Communication(String tableName1, String tableName2) {
        if ((tableName2.equals("auto")) && (tableName1.equals("client"))) {
            return "client_id";
        }
        if ((tableName1.equals("auto")) && (tableName2.equals("remont"))) {
            return "auto_id";
        }
        if ((tableName1.equals("client")) && (tableName2.equals("register"))) {
            return "client_id";
        }
        if ((tableName1.equals("client")) && (tableName2.equals("dealind"))) {
            return "client_id";
        }
        if ((tableName1.equals("dealind")) && (tableName2.equals("goods"))) {
            return "goods_id";
        }
        return null;
    }
}
