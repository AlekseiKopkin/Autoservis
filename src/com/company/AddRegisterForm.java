package com.company;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.util.ArrayList;

public class AddRegisterForm {
    private JPanel panel;
    private JTextField textFieldClient;
    private JTextField textFieldRegisterDate;
    private JButton OKButton;
    private JButton exitButton;
    private JFrame frame;
    private ArrayList<String> values;
    private ArrayList<String> columnsName;

    public void Gui() {
        columnsName = new ArrayList<>();
        columnsName.add("client_id");
        columnsName.add("register_date");
        Frame();
        Action();
    }

    private void Action() {
        OKButton.addActionListener(actionEvent -> {
            values = new ArrayList<>();
            DataEntry dataEntry = new DataEntry();
            values.add(textFieldClient.getText());
            values.add(textFieldRegisterDate.getText());
            int flag = dataEntry.DataEntryAdd(columnsName.size(), values, columnsName, "register");
            if (flag == 0) {
                frame.dispose();
            }
        });
        exitButton.addActionListener(actionEvent -> {
            Actions actions = new Actions();
            int flag = actions.Read("register");
            if (flag == 0)
                frame.dispose();
        });
        textFieldRegisterDate.setDocument(new PlainDocument() {
            String chars = "0123456789.: -";

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

    private void Frame() {
        frame = new JFrame("Add register");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500, 200));
        frame.add(panel);
        frame.setVisible(true);
    }
}
