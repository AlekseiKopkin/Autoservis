package com.company;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddAutoForm {
    private JTextField textFieldMarka;
    private JTextField textFieldProbeg;
    private JTextField textFieldColor;
    private JTextField textFieldClient;
    private JButton buttonOk;
    private JPanel panel;
    private JButton exitButton;
    private JFrame frame;
    private ArrayList<String> values;
    private ArrayList<String> columnsName;

    public void Gui() {
        columnsName = new ArrayList<>();
        columnsName.add("marka");
        columnsName.add("probeg");
        columnsName.add("color");
        columnsName.add("client_id");
        Frame();
        Action();
    }

    public void Action() {
        buttonOk.addActionListener(actionEvent -> {
            values = new ArrayList<>();
            DataEntry dataEntry = new DataEntry();
            values.add(textFieldMarka.getText());
            values.add(textFieldProbeg.getText());
            values.add(textFieldColor.getText());
            values.add(textFieldClient.getText());
            int flag = dataEntry.DataEntryAdd(columnsName.size(), values, columnsName, "auto");
            if (flag == 0) {
                frame.dispose();
            }
        });
        exitButton.addActionListener(actionEvent -> {
            Actions actions = new Actions();
            int flag = actions.Read("auto");
            if (flag == 0)
                frame.dispose();
        });
        textFieldMarka.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (getLength() < 255) {
                    super.insertString(offs, str, a);
                }
            }
        });
        textFieldColor.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (getLength() < 255) {
                    super.insertString(offs, str, a);
                }
            }
        });
        textFieldProbeg.setDocument(new PlainDocument() {
            String chars = "0123456789";

            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (chars.contains(str)) {
                    if (getLength() < 11) {
                        super.insertString(offs, str, a);
                    }
                }
            }
        });
        textFieldClient.setDocument(new PlainDocument() {
            String chars = "0123456789";

            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (chars.contains(str)) {
                    if (getLength() < 11) {
                        super.insertString(offs, str, a);
                    }
                }
            }
        });
    }

    public void Frame() {
        frame = new JFrame("Add Auto");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500, 300));
        frame.add(panel);
        frame.setVisible(true);
    }
}