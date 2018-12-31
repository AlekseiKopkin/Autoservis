package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import static com.company.Main.Connection;

public class JOINForm {
    private JPanel panel;
    private JButton OKButton;
    private JButton exitButton;
    private JList<Object> listAuto;
    private JList<Object> listClient;
    private JList<Object> listRemont;
    private JList<Object> listDealind;
    private JList<Object> listGoods;
    private JList<Object> listRegister;
    private JList<Object> listAutoSelect;
    private JList<Object> listClientSelect;
    private JList<Object> listRemontSelect;
    private JList<Object> listDealindSelect;
    private JList<Object> listGoodsSelect;
    private JList<Object> listRegisterSelect;
    private JFrame frame;
    private ArrayList<String> columnsTableAuto = new ArrayList<>();
    private ArrayList<String> columnsTableClients = new ArrayList<>();
    private ArrayList<String> columnsTableDealind = new ArrayList<>();
    private ArrayList<String> columnsTableGoods = new ArrayList<>();
    private ArrayList<String> columnsTableRegister = new ArrayList<>();
    private ArrayList<String> columnsTableRemont = new ArrayList<>();
    private ArrayList<String> tableName = new ArrayList<>();
    private DefaultListModel<Object> dlmAuto = new DefaultListModel<>();
    private DefaultListModel<Object> dlmClient = new DefaultListModel<>();
    private DefaultListModel<Object> dlmRemont = new DefaultListModel<>();
    private DefaultListModel<Object> dlmRegister = new DefaultListModel<>();
    private DefaultListModel<Object> dlmDealind = new DefaultListModel<>();
    private DefaultListModel<Object> dlmGoods = new DefaultListModel<>();
    private DefaultListModel<Object> dlmAutoSelect = new DefaultListModel<>();
    private DefaultListModel<Object> dlmClientSelect = new DefaultListModel<>();
    private DefaultListModel<Object> dlmDealindSelect = new DefaultListModel<>();
    private DefaultListModel<Object> dlmGoodsSelect = new DefaultListModel<>();
    private DefaultListModel<Object> dlmRemontSelect = new DefaultListModel<>();
    private DefaultListModel<Object> dlmRegisterSelect = new DefaultListModel<>();

    public void Gui() {
        DataColumns();
        Frame();
        Action();
    }

    private void DataColumns() {
        listClient.setModel(dlmClient);
        dlmClient.addElement("client_id");
        dlmClient.addElement("name");
        dlmClient.addElement("fam");
        dlmClient.addElement("otch");
        dlmClient.addElement("seria");
        dlmClient.addElement("nomer");
        listAuto.setModel(dlmAuto);
        dlmAuto.addElement("auto_id");
        dlmAuto.addElement("marka");
        dlmAuto.addElement("probeg");
        dlmAuto.addElement("color");
        dlmAuto.addElement("client_id");
        listGoods.setModel(dlmGoods);
        dlmGoods.addElement("goods_id");
        dlmGoods.addElement("name");
        dlmGoods.addElement("price");
        dlmGoods.addElement("status");
        listDealind.setModel(dlmDealind);
        dlmDealind.addElement("dealind_id");
        dlmDealind.addElement("goods_id");
        dlmDealind.addElement("client_id");
        dlmDealind.addElement("date_buy");
        listRegister.setModel(dlmRegister);
        dlmRegister.addElement("register_id");
        dlmRegister.addElement("client_id");
        dlmRegister.addElement("register_date");
        listRemont.setModel(dlmRemont);
        dlmRemont.addElement("remont_id");
        dlmRemont.addElement("price");
        dlmRemont.addElement("auto_id");
        dlmRemont.addElement("breaking");
        dlmRemont.addElement("date_in");
        dlmRemont.addElement("date_out");
    }

    private void DlmSelect(JList<Object> listSelect, JList<Object> list, DefaultListModel<Object> dlm, DefaultListModel<Object> dlmSelect, ArrayList<String> columnsTable) {
        try {
            Object sel = null;
            int[] selectedIx = listSelect.getSelectedIndices();
            for (int aSelectedIx : selectedIx) {
                sel = listSelect.getModel().getElementAt(aSelectedIx);
            }
            list.setModel(dlm);
            dlm.addElement(sel);
            dlmSelect.remove(listSelect.getSelectedIndex());
            columnsTable.remove(sel);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Вы удалили все поля");
        }
    }

    private void Dlm(JList<Object> listSelect, JList<Object> list, DefaultListModel<Object> dlm, DefaultListModel<Object> dlmSelect, ArrayList<String> columnsTable) {
        try {
            Object sel = null;
            int[] selectedIx = list.getSelectedIndices();
            for (int aSelectedIx : selectedIx) {
                sel = list.getModel().getElementAt(aSelectedIx);
            }
            if (sel != null) {
                columnsTable.add(sel.toString());
            }
            listSelect.setModel(dlmSelect);
            dlmSelect.addElement(sel);
            dlm.remove(list.getSelectedIndex());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Вы выбрали все поля");
        }
    }

    public void Action() {
        listRemontSelect.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                DlmSelect(listRemontSelect, listRemont, dlmRemont, dlmRemontSelect, columnsTableRemont);
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
        listRegisterSelect.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                DlmSelect(listRegisterSelect, listRegister, dlmRegister, dlmRegisterSelect, columnsTableRegister);
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
        listGoodsSelect.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                DlmSelect(listGoodsSelect, listGoods, dlmGoods, dlmGoodsSelect, columnsTableGoods);
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
        listDealindSelect.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                DlmSelect(listDealindSelect, listDealind, dlmDealind, dlmDealindSelect, columnsTableDealind);
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
        listClientSelect.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                DlmSelect(listClientSelect, listClient, dlmClient, dlmClientSelect, columnsTableClients);
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
        listAutoSelect.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                DlmSelect(listAutoSelect, listAuto, dlmAuto, dlmAutoSelect, columnsTableAuto);
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
        listGoods.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                Dlm(listGoodsSelect, listGoods, dlmGoods, dlmGoodsSelect, columnsTableGoods);
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
        listDealind.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                Dlm(listDealindSelect, listDealind, dlmDealind, dlmDealindSelect, columnsTableDealind);
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
        listRegister.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                Dlm(listRegisterSelect, listRegister, dlmRegister, dlmRegisterSelect, columnsTableRegister);
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
        listRemont.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                Dlm(listRemontSelect, listRemont, dlmRemont, dlmRemontSelect, columnsTableRemont);
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
        listClient.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                Dlm(listClientSelect, listClient, dlmClient, dlmClientSelect, columnsTableClients);
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
        listAuto.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                Dlm(listAutoSelect, listAuto, dlmAuto, dlmAutoSelect, columnsTableAuto);
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
        exitButton.addActionListener(actionEvent -> {
            ReadForm readForm = new ReadForm();
            readForm.Gui();
            frame.dispose();
        });
        OKButton.addActionListener(actionEvent -> {
            JOINFunction joinFunction = new JOINFunction();
            DataTable();
            int flag = joinFunction.Join(Connection(), columnsTableAuto, columnsTableClients, columnsTableDealind, columnsTableGoods, columnsTableRegister, columnsTableRemont, tableName);
            if (flag == 0) {
                frame.dispose();
            } else {
                tableName.clear();
            }
        });
    }

    private void DataTable() {
        if (columnsTableClients.size() != 0) {
            tableName.add("client");
        }
        if (columnsTableAuto.size() != 0) {
            tableName.add("auto");
        }
        if (columnsTableRegister.size() != 0) {
            tableName.add("register");
        }
        if (columnsTableDealind.size() != 0) {
            tableName.add("dealind");
        }
        if (columnsTableRemont.size() != 0) {
            tableName.add("remont");
        }
        if (columnsTableGoods.size() != 0) {
            tableName.add("goods");
        }
    }

    public void Frame() {
        frame = new JFrame("JOIN");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(1200, 350));
        frame.add(panel);
        frame.setVisible(true);
    }

}