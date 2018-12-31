package com.company;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.util.ArrayList;

public class AddDealindForm {
    private JPanel panel;
    private JTextField textFieldGoods;
    private JTextField textFieldClient;
    private JTextField textFieldDateBuy;
    private JButton okButton;
    private JButton exitButton;
    private ArrayList<String> values;
    private ArrayList<String> columnsName;
    private JFrame frame;

    public void Gui() {
        columnsName = new ArrayList<>();
        columnsName.add("goods");
        columnsName.add("client_id");
        columnsName.add("date_buy");
        Frame();
        Action();
    }

    public void Action() {
        okButton.addActionListener(actionEvent -> {
            values = new ArrayList<>();
            DataEntry dataEntry = new DataEntry();
            values.add(textFieldGoods.getText());
            values.add(textFieldClient.getText());
            values.add(textFieldDateBuy.getText());
            int flag = dataEntry.DataEntryAdd(columnsName.size(), values, columnsName, "dealind");
            if (flag == 0) {
                frame.dispose();
            }
        });
        exitButton.addActionListener(actionEvent -> {
            Actions actions = new Actions();
            int flag = actions.Read("dealind");
            if (flag == 0)
                frame.dispose();
        });
        textFieldGoods.setDocument(new PlainDocument() {
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
        textFieldDateBuy.setDocument(new PlainDocument() {
            String chars = "0123456789-";

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
        frame = new JFrame("Add Dealind");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500, 300));
        frame.add(panel);
        frame.setVisible(true);
    }
}
