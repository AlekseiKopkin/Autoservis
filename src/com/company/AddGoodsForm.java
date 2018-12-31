package com.company;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.util.ArrayList;

public class AddGoodsForm {
    private JPanel panel;
    private JTextField textFieldName;
    private JTextField textFieldPrice;
    private JTextField textFieldStatus;
    private JButton OKButton;
    private JButton exitButton;
    private JFrame frame;
    private ArrayList<String> values;
    private ArrayList<String> columnsName;

    public void Gui() {
        columnsName = new ArrayList<>();
        columnsName.add("name");
        columnsName.add("price");
        columnsName.add("status");
        Frame();
        Action();
    }

    public void Action() {
        OKButton.addActionListener(actionEvent -> {
            values = new ArrayList<>();
            DataEntry dataEntry = new DataEntry();
            values.add(textFieldName.getText());
            values.add(textFieldPrice.getText());
            values.add(textFieldStatus.getText());
            int flag = dataEntry.DataEntryAdd(columnsName.size(), values, columnsName, "goods");
            if (flag == 0) {
                frame.dispose();
            }
        });
        exitButton.addActionListener(actionEvent -> {
            Actions actions = new Actions();
            int flag = actions.Read("goods");
            if (flag == 0)
                frame.dispose();
        });
        textFieldStatus.setDocument(new PlainDocument() {
            String chars = "01";

            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (chars.contains(str)) {
                    if (getLength() < 11) {
                        super.insertString(offs, str, a);
                    }
                }
            }
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
        textFieldName.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {

                if (getLength() < 11) {
                    super.insertString(offs, str, a);
                }
            }
        });
    }

    public void Frame() {
        frame = new JFrame("Add Goods");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500, 300));
        frame.add(panel);
        frame.setVisible(true);
    }
}
