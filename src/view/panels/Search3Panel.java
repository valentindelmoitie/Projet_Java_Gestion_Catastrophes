package view.panels;

import controller.ApplicationController;
import model.DangerousSite;
import model.DisasterOnDangerousSite;
import view.tableModel.DisastersSearch3Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Search3Panel extends JPanel {
    private JLabel regionLbl;
    private JComboBox dangerousSiteCb;
    private ApplicationController controller;
    private JTable disasterTable;
    private DisastersSearch3Model model;

    public Search3Panel() {
        this.setLayout(new BorderLayout());
        setController(new ApplicationController());
        titlePanelCreation();
        formPanelCreation();
        buttonPanelCreation();
        tablePanelCreation();
        regionPanelCreation();
    }

    private void titlePanelCreation() {
        JPanel titlePanel = new JPanel();
        JLabel descriptionLabel = new JLabel("<html><h3>Rechercher les catastrophes ayant touché un site dangereux</h3></html>");
        titlePanel.add(descriptionLabel);
        this.add(titlePanel, BorderLayout.NORTH);
    }

    private void formPanelCreation() {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(1, 2, 5, 5));

        JLabel disasterLabel = new JLabel("Catastrophe : ");
        formPanel.add(disasterLabel);

       try {
            ArrayList<String> dangerousSiteArrayList = new ArrayList<>();
            for (DangerousSite dangerousSite : controller.getAllDangerousSites()) {
                dangerousSiteArrayList.add(dangerousSite.getId().toString() + "-"  + dangerousSite.getType() + "-" + dangerousSite.getRegion());
            }

            String[] disasters = new String[dangerousSiteArrayList.size()];
            for(int i = 0; i < disasters.length; i++) {
                disasters[i] = dangerousSiteArrayList.get(i);
            }
            dangerousSiteCb = new JComboBox(disasters);
        }catch (Exception exception){
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Exception levée", JOptionPane.ERROR_MESSAGE);
        }

        formPanel.add(dangerousSiteCb);
        this.add(formPanel, BorderLayout.CENTER);
    }

    private void buttonPanelCreation() {
        JPanel buttonPanel = new JPanel();

        JButton sendButton = new JButton("Recherche");
        sendButton.setHorizontalAlignment(JButton.CENTER);
        sendButton.addActionListener(new SearchButtonListener());
        buttonPanel.add(sendButton);
        this.add(buttonPanel, BorderLayout.EAST);
    }

    private void tablePanelCreation(){
        JPanel tablePanel = new JPanel();
        try {
            model = new DisastersSearch3Model(new ArrayList<>());

            disasterTable = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(disasterTable);
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

    private void regionPanelCreation(){
        JPanel regionPanel = new JPanel();
        regionLbl = new JLabel("Information sur la région du site dangereux ");
        regionPanel.add(regionLbl);
        this.add(regionPanel, BorderLayout.WEST);

    }

    public void setController(ApplicationController controller) {
        this.controller = controller;
    }

    private class SearchButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            try {
                String userChoice = dangerousSiteCb.getSelectedItem().toString();
                String[] parts = userChoice.split("-");
                String part1 = parts[0]; // ID
                String part2 = parts[1]; // TYPE
                String part3 = parts[2]; // CITY
                int id = Integer.parseInt(part1);

                DangerousSite dangerousSite = new DangerousSite(id,part2,part3);

                ArrayList<DisasterOnDangerousSite> disasters = controller.getDangerousSitesByDisaster(dangerousSite);
                for (DisasterOnDangerousSite disaster : disasters) {
                    disaster.correctDateForDisplay();
                }
                model = new DisastersSearch3Model(disasters);
                disasterTable.setModel(model);
                regionLbl.setText("Le site dangereux est situé dans la region : " + disasters.get(0).getRegionOfDangerousSite().getName() + ", ayant une population de " + String.format("%,d",disasters.get(0).getRegionOfDangerousSite().getPopulation()) + " et étant" + (disasters.get(0).getRegionOfDangerousSite().getWarZone() ? " en guerre" : " en paix"));
                repaint();
                validate();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Exception levée", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

