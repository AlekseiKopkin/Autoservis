package com.company;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.util.ArrayList;

public class AddRemontForm {
    private JTextField textFieldPrice;
    private JTextField textFieldAuto;
    private JTextField textFieldBreaking;
    private JTextField textFieldDateIn;
    private JTextField textFieldDateOut;
    private JButton OKButton;
    private JPanel panel;
    private JButton exitButton;
    private JFrame frame;
    private ArrayList<String> values;
    private ArrayList<String> columnsName;

    public void Gui() {
        columnsName = new ArrayList<>();
        columnsName.add("price");
        columnsName.add("auto_id");
        columnsName.add("breaking");
        columnsName.add("date_in");
        columnsName.add("date_out");
        Frame();
        Action();
    }

    private void Action() {
        OKButton.addActionListener(actionEvent -> {
            values = new ArrayList<>();
            DataEntry dataEntry = new DataEntry();
            values.add(textFieldPrice.getText());
            values.add(textFieldAuto.getText());
            values.add(textFieldBreaking.getText());
            values.add(textFieldDateIn.getText());
            values.add(textFieldDateOut.getText());
            int flag = dataEntry.DataEntryAdd(columnsName.size(), values, columnsName, "remont");
            if (flag == 0) {
                frame.dispose();
            }
        });
        exitButton.addActionListener(actionEvent -> {
            Actions actions = new Actions();
            int flag = actions.Read("remont");
            if (flag == 0)
                frame.dispose();
        });
        textFieldPrice.setDocument(new PlainDocument() {
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
        textFieldAuto.setDocument(new PlainDocument() {
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
        textFieldBreaking.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (getLength() < 11) {
                    super.insertString(offs, str, a);
                }
            }
        });
        textFieldDateIn.setDocument(new PlainDocument() {
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
        textFieldDateOut.setDocument(new PlainDocument() {
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

    private void Frame() {
        frame = new JFrame("Add Remont");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500, 300));
        frame.add(panel);
        frame.setVisible(true);
    }
}