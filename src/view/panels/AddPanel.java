package view.panels;

import controller.ApplicationController;
import exception.ConnectionException;
import exception.ReadingException;
import model.Disaster;
import model.Region;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class AddPanel extends JPanel {
    // ajouter constante valeur min spinner + spinner intensity + starting value
    private ApplicationController controller;
    private JPanel titlePanel, formPanel, buttonsPanel;
    private JLabel titleLbl, nameLbl, descriptionLbl, typeLbl, dateLbl, endDateLbl, intensityLbl,
                   impactedPeopleLbl, directCasualtiesLbl, indirectCasualtiesLbl, isNaturalLbl, regionbl;
    private JTextField nameTF, descriptionTF, endDateTF;
    private JSpinner dateSpinner, intensitySpinner, impactedPeopleSpinner, directCasualtiesSpinner, indirectCasualtiesSpinner;
    private JButton sendBtn, selectionnerBtn;
    private DateFormat dateFormat;
    private JComboBox typeComboBox, isNaturalComboBox;
    private JList regions, chosenRegions;
    private JPanel regionPanel;

    public AddPanel() {
        this.setLayout(new BorderLayout());
        setController(new ApplicationController());
        titlePanelCreation();
        formPanelCreation();
        buttonsPanelCreation();
    }

    public void setController(ApplicationController controller) {
        this.controller = controller;
    }

    private void titlePanelCreation() {
        titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());

        titleLbl = new JLabel("<html><h3>Ajout d'une catastrophe à la base de données</h3></html>");
        titlePanel.add(titleLbl);

        this.add(titlePanel, BorderLayout.NORTH);
    }

    private void formPanelCreation() {
        formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(12, 2));


        // On ne doit pas demander l'ID, il est incrémenté auto dans la BDD

        nameLbl = new JLabel("Nom de la catastrophe : ");
        nameTF = new JTextField();
        formPanel.add(nameLbl);
        formPanel.add(nameTF);

        descriptionLbl = new JLabel("Description de la catastrophe* : ");
        descriptionTF = new JTextField();
        formPanel.add(descriptionLbl);
        formPanel.add(descriptionTF);

        typeLbl = new JLabel("Type de la catastrophe* : ");
        String[] types = {"Humanitaire","Incendie","Industriel", "Naufrage","Nucléaire","Ouragan","Tremblement de terre", "Tsunami"};
        typeComboBox = new JComboBox(types);
        typeComboBox.setSelectedItem("Humanitaire");
        typeComboBox.setMaximumRowCount(4);
        formPanel.add(typeLbl);
        formPanel.add(typeComboBox);


        dateLbl = new JLabel("Date de début* : ");
        dateSpinner = new JSpinner(new SpinnerDateModel());
        dateSpinner.setEditor(new JSpinner.DateEditor(dateSpinner, "dd.MM.yyyy"));
        formPanel.add(dateLbl);
        formPanel.add(dateSpinner);

        endDateLbl = new JLabel("Date de fin (dd/mm/yyyy): ");
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        endDateTF= new JFormattedTextField(dateFormat);
        formPanel.add(endDateLbl);
        formPanel.add(endDateTF);

        intensityLbl = new JLabel("Intensité de la catastrophe (0 si pas nécessaire) : ");
        intensitySpinner = new JSpinner(new SpinnerNumberModel(0,0,7,1));  // ADDED
        formPanel.add(intensityLbl);
        formPanel.add(intensitySpinner);

        impactedPeopleLbl = new JLabel("Nombre de personnes touchées* : ");
        impactedPeopleSpinner = new JSpinner(new SpinnerNumberModel(0,0,Integer.MAX_VALUE,1));
        formPanel.add(impactedPeopleLbl);
        formPanel.add(impactedPeopleSpinner);


        directCasualtiesLbl = new JLabel("Nombre de victimes directes* : ");
        directCasualtiesSpinner = new JSpinner(new SpinnerNumberModel(0,0,Integer.MAX_VALUE,1));
        formPanel.add(directCasualtiesLbl);
        formPanel.add(directCasualtiesSpinner);

        indirectCasualtiesLbl = new JLabel("Nombre de victimes indirectes* : ");
        indirectCasualtiesSpinner = new JSpinner(new SpinnerNumberModel(0,0,Integer.MAX_VALUE,1));
        formPanel.add(indirectCasualtiesLbl);
        formPanel.add(indirectCasualtiesSpinner);

        isNaturalLbl = new JLabel("La catastrophe est-elle naturelle* ? ");
        String[] isNaturalValues = {"Oui","Non"};
        isNaturalComboBox = new JComboBox(isNaturalValues);
        isNaturalComboBox.setSelectedItem("Oui");
        isNaturalComboBox.setMaximumRowCount(2);
        formPanel.add(isNaturalLbl);
        formPanel.add(isNaturalComboBox);

        regionbl = new JLabel("Région(s) impactée(s)* : ");
        regionPanel = new JPanel();
        regionPanel.add(regionbl);

        try {
            ArrayList<String> regionsNames = new ArrayList<>();
            for (Region region : controller.getAllRegion()){
                regionsNames.add(region.getName());
            }

            regions = new JList(regionsNames.toArray());
            regions.setVisibleRowCount(5);
            regions.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            regionPanel.add(new JScrollPane(regions));

            selectionnerBtn = new JButton("Selectionner");
            selectionnerBtn.addActionListener(new SelectButtonListener());
            regionPanel.add(selectionnerBtn);

            chosenRegions = new JList();
            chosenRegions.setVisibleRowCount(5);
            //chosenRegions.setFixedCellHeight(30);
            //chosenRegions.setFixedCellWidth(75);
            chosenRegions.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            regionPanel.add(new JScrollPane(chosenRegions));


        }catch(Exception e){ //Change this
            e.printStackTrace();
        }
        formPanel.add(regionPanel);




        this.add(formPanel, BorderLayout.CENTER);
    }

    private void buttonsPanelCreation() {
        buttonsPanel = new JPanel();

        sendBtn = new JButton("Envoyer");
        buttonsPanel.add(sendBtn);

        this.add(buttonsPanel, BorderLayout.SOUTH);
        sendBtn.addActionListener(new InsertButtonListener());
    }

    private class InsertButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            Integer impactedPeople      = (Integer) impactedPeopleSpinner.getValue();
            Integer directCasualties    = (Integer) directCasualtiesSpinner.getValue();
            Integer indirectCasualties  = (Integer) indirectCasualtiesSpinner.getValue();
            Integer intensity           = (Integer) intensitySpinner.getValue();
            String type = (String) typeComboBox.getSelectedItem();
            String description = descriptionTF.getText();
            Boolean isNatural = (isNaturalComboBox.getSelectedItem() == "Oui");
            // date a faire
            ArrayList<Region> regions = new ArrayList<>();
            // Comment retouver la valeur des régions selectionnées ?

          //  Disaster disaster = new Disaster(null,);
        }
    }

    private class SelectButtonListener implements ActionListener{ // ???????????????
        public void actionPerformed(ActionEvent event){
            ArrayList<Object> selectedRegions = new ArrayList();
            for(Object region : regions.getSelectedValuesList()){
                selectedRegions.add(region);
            }
            chosenRegions.setListData(selectedRegions.toArray());
            AddPanel.this.repaint();
        }
    }

}
