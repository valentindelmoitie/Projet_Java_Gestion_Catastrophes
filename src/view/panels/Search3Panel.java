package view.panels;

import controller.ApplicationController;
import model.Disaster;
import model.Region;
import view.AllDisastersModel;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Search3Panel extends JPanel {
    private JLabel descriptionLabel, disasterLabel;
    private JComboBox disasterCb;
    private JPanel titlePanel, formPanel, buttonPanel;
    private JButton sendButton;
    private ApplicationController controller;
    private JPanel tablePanel;
    private JTable disasterTable;
    private AllDisastersModel model;
    private JScrollPane scrollPane;

    public Search3Panel() {
        this.setLayout(new BorderLayout());
        setController(new ApplicationController());
        titlePanelCreation();
        formPanelCreation();
        buttonPanelCreation();
        tablePanelCreation();
    }

    private void titlePanelCreation() {
        titlePanel = new JPanel();
        descriptionLabel = new JLabel("<html><h3>Rechercher les catastrophes ayant touché un site dangereux</h3></html>");
        titlePanel.add(descriptionLabel);
        this.add(titlePanel, BorderLayout.NORTH);
    }

    private void formPanelCreation() {
        formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(1, 2, 5, 5));

        disasterLabel = new JLabel("Catastrophe : ");
        formPanel.add(disasterLabel);

        try {
            ArrayList<Integer> disastersArrayList = new ArrayList<>();
            for (Disaster disaster : controller.getAllDisaster()) {
                disastersArrayList.add(disaster.getId());
            }

            Integer[] disasters = new Integer[disastersArrayList.size()];
            for(int i = 0; i < disasters.length; i++) {
                disasters[i] = disastersArrayList.get(i);
            }
            disasterCb = new JComboBox(disasters);
        }catch (Exception exception){
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Exception levée", JOptionPane.ERROR_MESSAGE);
        }

        formPanel.add(disasterCb);
        this.add(formPanel, BorderLayout.CENTER);
    }

    private void buttonPanelCreation() {
        buttonPanel = new JPanel();

        sendButton = new JButton("Envoyer !");
        sendButton.setHorizontalAlignment(JButton.CENTER);

        buttonPanel.add(sendButton);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void tablePanelCreation(){
        tablePanel = new JPanel();
        try {
            ArrayList<Disaster> disasters = controller.getAllDisaster();
            for(Disaster disaster : disasters){
                disaster.correctDateForDisplay();
            }
            model = new AllDisastersModel(disasters);

            disasterTable = new JTable(model);
            scrollPane = new JScrollPane(disasterTable);
            scrollPane.setPreferredSize(new Dimension(1300, 400));

            disasterTable.getColumnModel().getColumn(0).setPreferredWidth(5);
            disasterTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            disasterTable.getColumnModel().getColumn(3).setPreferredWidth(200);
            disasterTable.getColumnModel().getColumn(6).setPreferredWidth(5);

            tablePanel.add(scrollPane);
            this.add(tablePanel, BorderLayout.SOUTH);
        } catch (Exception exception){
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Exception levée", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setController(ApplicationController controller) {
        this.controller = controller;
        try {
/*            Disaster disaster = new Disaster((Integer) disasterCb.getSelectedItem());
            ArrayList<Disaster> disasters = controller.getDangerousSitesByDisaster(disaster);
            for(Disaster disaster : disasters){
                disaster.correctDateForDisplay();
            }
            model = new AllDisastersModel(disasters);
            disasterTable.setModel(model);
            repaint();
            validate();*/

        } catch(Exception exception){
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Exception levée", JOptionPane.ERROR_MESSAGE);
        }
    }
}

