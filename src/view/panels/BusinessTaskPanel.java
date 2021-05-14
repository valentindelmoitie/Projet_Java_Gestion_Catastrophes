package view.panels;

import controller.ApplicationController;
import model.Region;
import model.SearchByRegionAndType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class BusinessTaskPanel extends JPanel {
    private ApplicationController controller;
    private JLabel resultLbl;
    JComboBox typeComboBox, regionComboBox;

    public BusinessTaskPanel() {
        this.setLayout(new BorderLayout());
        setController(new ApplicationController());
        titlePanelCreation();
        formPanelCreation();
        buttonPanelCreation();
        resultPanelCreation();
    }

    private void titlePanelCreation(){
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        JLabel titleLbl = new JLabel("<html><h3>Tâche métier : Afficher un % de population affecté par un type de catastrophe au sein d'un region</h3></html>");
        titlePanel.add(titleLbl);
        this.add(titlePanel, BorderLayout.NORTH);
    }

    private void formPanelCreation(){
        try {
            JPanel formPanel = new JPanel();
            JLabel regionLbl = new JLabel("Region : ");
            ArrayList<Region> regionsAL = controller.getAllRegion();
            String[] regions = new String[regionsAL.size()];
            int i = 0;
            for(Region region : regionsAL){
                regions[i] = region.getName();
                i++;
            }
            regionComboBox = new JComboBox<>(regions);
            formPanel.add(regionLbl);
            formPanel.add(regionComboBox);

            JLabel typeLbl = new JLabel("Type : ");
            String[] types = {"Humanitaire","Incendie","Industriel", "Naufrage","Nucléaire","Ouragan","Tremblement de terre", "Tsunami"};
            typeComboBox = new JComboBox(types);
            formPanel.add(typeLbl);
            formPanel.add(typeComboBox);
            this.add(formPanel,BorderLayout.CENTER);

        }catch(Exception exception){
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Exception levée", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buttonPanelCreation(){
        JPanel buttonPanel = new JPanel();
        JButton sendButton = new JButton("Calculer");
        sendButton.addActionListener(new BusinessButtonListener());
        buttonPanel.add(sendButton);
        this.add(buttonPanel, BorderLayout.EAST);
    }

    private void resultPanelCreation(){
        JPanel resultPanel = new JPanel();
        resultLbl = new JLabel("Les résultats de la recherche apparaitront ici");
        resultPanel.add(resultLbl);
        this.add(resultPanel,BorderLayout.SOUTH);
    }


    public void setController(ApplicationController controller) {
        this.controller = controller;
    }

    private class BusinessButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            try {
                SearchByRegionAndType search = new SearchByRegionAndType(regionComboBox.getSelectedItem().toString(), typeComboBox.getSelectedItem().toString());
                Double pourc = controller.getPourcOfPopulationOfRegionImpactedByType(search);
                DecimalFormat df = new DecimalFormat();
                df.setMaximumFractionDigits(2);
                resultLbl.setText("Le pourcentage de la population impacté par des catastrophes de type " + search.getType() + " en " + search.getRegionName() + " est de " +  df.format(pourc) + '%');

            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Exception levée", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
