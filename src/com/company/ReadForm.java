package com.company;

import javax.swing.*;
import java.awt.*;

public class ReadForm {
    private JButton exitButton;
    private JPanel panel;
    private JButton okButton;
    private JComboBox comboBox;
    private JButton JOINButton;
    private JFrame frame;
    private DefaultComboBoxModel dtm1 = (DefaultComboBoxModel) comboBox.getModel();
    private int flag = 0;

    public void Gui() {
        Frame();
        Action();
    }

    public void Action() {
        exitButton.addActionListener(e -> frame.dispose());
        okButton.addActionListener(actionEvent -> {
            Actions actions = new Actions();
            flag = actions.Read((String) dtm1.getSelectedItem());
            if (flag == 0) {
                frame.dispose();
            }
        });
        JOINButton.addActionListener(actionEvent -> {
            JOINForm joiNnForm = new JOINForm();
            joiNnForm.Gui();
            frame.dispose();
        });
    }

    public void Frame() {
        frame = new JFrame("Read Table");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(400, 150));
        frame.add(panel);
        frame.setVisible(true);
    }
}
