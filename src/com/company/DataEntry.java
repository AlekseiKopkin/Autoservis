package com.company;

import java.util.ArrayList;
import static com.company.Main.Connection;

public class DataEntry {
    private ArrayList<String> values = new ArrayList<>();

    public ArrayList<String> get() {
        return values;
    }

    public void set(String value) {
        values.add(value);
    }

    public int DataEntryAdd(int arraySize, ArrayList<String> valuesFrom, ArrayList<String> columns, String tableName) {
        for (int i = 0; i < arraySize; i++) {
            values.add(valuesFrom.get(i));
        }
        FourFunction fourFunction = new FourFunction();
        return fourFunction.Add(Connection(), columns, tableName, valuesFrom);
    }
}