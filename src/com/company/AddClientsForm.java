package com.company;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.util.ArrayList;

public class AddClientsForm {
    private JPanel panel;
    private JTextField textFieldName;
    private JTextField textFieldFam;
    private JTextField textFieldOtch;
    private JTextField textFieldSeria;
    private JTextField textFieldNomer;
    private JButton okButton;
    private JButton exitButton;
    private JFrame frame;
    private ArrayList<String> values;
    private ArrayList<String> columnsName;

    public void Gui(){
        columnsName=new ArrayList<>();
        columnsName.add("name");
        columnsName.add("fam");
        columnsName.add("otch");
        columnsName.add("seria");
        columnsName.add("nomer");
        Frame();
        Action();
    }

    public void Action(){
        okButton.addActionListener(actionEvent -> {
            values=new ArrayList<>();
            DataEntry dataEntry=new DataEntry();
            values.add(textFieldName.getText());
            values.add(textFieldFam.getText());
            values.add(textFieldOtch.getText());
            values.add(textFieldSeria.getText());
            values.add(textFieldNomer.getText());
            int flag = dataEntry.DataEntryAdd(columnsName.size(),values,columnsName,"clients");
            if(flag==0) {
                frame.dispose();
            }
        });
        exitButton.addActionListener(actionEvent -> {
            Actions actions=new Actions();
            int flag=actions.Read("clients");
            if(flag==0)
            frame.dispose();
        });
        textFieldSeria.setDocument(new PlainDocument() {
            String chars = "0123456789";
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (chars.contains(str)) {
                    if (getLength()< 4) {
                        super.insertString(offs, str, a);
                    }
                }
            }
        });
        textFieldNomer.setDocument(new PlainDocument() {
            String chars = "0123456789";
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (chars.contains(str)) {
                    if (getLength()< 6) {
                        super.insertString(offs, str, a);
                    }
                }
            }
        });
        textFieldName.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                    if (getLength()< 20) {
                        super.insertString(offs, str, a);
                    }
            }
        });
        textFieldFam.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (getLength()< 20) {
                    super.insertString(offs, str, a);
                }
            }
        });
        textFieldOtch.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (getLength()< 20) {
                    super.insertString(offs, str, a);
                }
            }
        });
    }

    public void Frame(){
        frame = new JFrame("Add Client");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500, 300));
        frame.add(panel);
        frame.setVisible(true);
    }
}