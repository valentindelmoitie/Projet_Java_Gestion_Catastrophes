package view.panels;

import controller.ApplicationController;
import model.Disaster;
import model.Region;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class FormPanel extends JPanel {
    public enum Type {
        INSERTION,
        MODIFICATION
    }

    // ajouter constante valeur min spinner + spinner intensity + starting value
    private Type formType;
    private Disaster disasterToModify;
    private ApplicationController controller;
    private JPanel titlePanel, formPanel, formSubPanel, regionPanel,  buttonsPanel;
    private JLabel idLbl, titleLbl, nameLbl, descriptionLbl, typeLbl, dateLbl, endDateLbl, intensityLbl,
            impactedPeopleLbl, directCasualtiesLbl, indirectCasualtiesLbl, isNaturalLbl, regionbl;
    private JTextField nameTF, descriptionTF, startDateTF, endDateTF;
    private JSpinner idSpinner, intensitySpinner, impactedPeopleSpinner, directCasualtiesSpinner, indirectCasualtiesSpinner;
    private JButton sendBtn, selectionnerBtn;
    private DateFormat dateFormat;
    private JComboBox typeComboBox, isNaturalComboBox;
    private JList regions, chosenRegions;
    private Calendar startDate, endDate;

    public FormPanel(Type formType) {
        this.formType = formType;

        this.setLayout(new BorderLayout());

        setController(new ApplicationController());

        titlePanelCreation();
        formPanelCreation();
        buttonsPanelCreation();

        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
    }

    public FormPanel(Disaster disasterToModify) {
        this(Type.MODIFICATION);
        this.disasterToModify = disasterToModify;
        fillForm();
    }

    public void setController(ApplicationController controller) {
        this.controller = controller;
    }

    private void titlePanelCreation() {
        titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());

        titleLbl = new JLabel();
        if (formType == Type.INSERTION)
            titleLbl.setText("<html><h3>Ajout d'une catastrophe à la base de données</h3></html>");
        else
            titleLbl.setText("<html><h3>Modification d'une catastrophe dans la base de données</h3></html>");

        titlePanel.add(titleLbl);

        this.add(titlePanel, BorderLayout.NORTH);
    }

    private void formPanelCreation() {
        formPanel = new JPanel();
        formPanel.setLayout(new BorderLayout());

        subFormPanelCreation();
        regionPanelCreation();

        this.add(formPanel, BorderLayout.CENTER);
    }

    private void subFormPanelCreation() {
        formSubPanel = new JPanel();
        formSubPanel.setLayout(new GridLayout(10, 2));

        nameLbl = new JLabel("Nom de la catastrophe : ");
        nameTF = new JTextField();
        formSubPanel.add(nameLbl);
        formSubPanel.add(nameTF);

        descriptionLbl = new JLabel("Description de la catastrophe* : ");
        descriptionTF = new JTextField();
        formSubPanel.add(descriptionLbl);
        formSubPanel.add(descriptionTF);

        typeLbl = new JLabel("Type de la catastrophe* : ");
        String[] types = {"Humanitaire","Incendie","Industriel", "Naufrage","Nucléaire","Ouragan","Tremblement de terre", "Tsunami"};
        typeComboBox = new JComboBox(types);
        typeComboBox.setSelectedItem("Humanitaire");
        typeComboBox.setMaximumRowCount(4);
        formSubPanel.add(typeLbl);
        formSubPanel.add(typeComboBox);

        dateLbl = new JLabel("Date de début (dd/mm/yyyy)* : ");
        startDateTF = new JTextField();
        formSubPanel.add(dateLbl);
        formSubPanel.add(startDateTF);

        endDateLbl = new JLabel("Date de fin (dd/mm/yyyy): ");
        endDateTF = new JTextField();
        formSubPanel.add(endDateLbl);
        formSubPanel.add(endDateTF);

        intensityLbl = new JLabel("Intensité de la catastrophe (0 si pas nécessaire) : ");
        intensitySpinner = new JSpinner(new SpinnerNumberModel(0,0,7,1));  // ADDED
        formSubPanel.add(intensityLbl);
        formSubPanel.add(intensitySpinner);

        impactedPeopleLbl = new JLabel("Nombre de personnes touchées* : ");
        impactedPeopleSpinner = new JSpinner(new SpinnerNumberModel(0,0,Integer.MAX_VALUE,1));
        formSubPanel.add(impactedPeopleLbl);
        formSubPanel.add(impactedPeopleSpinner);


        directCasualtiesLbl = new JLabel("Nombre de victimes directes* : ");
        directCasualtiesSpinner = new JSpinner(new SpinnerNumberModel(0,0,Integer.MAX_VALUE,1));
        formSubPanel.add(directCasualtiesLbl);
        formSubPanel.add(directCasualtiesSpinner);

        indirectCasualtiesLbl = new JLabel("Nombre de victimes indirectes* : ");
        indirectCasualtiesSpinner = new JSpinner(new SpinnerNumberModel(0,0,Integer.MAX_VALUE,1));
        formSubPanel.add(indirectCasualtiesLbl);
        formSubPanel.add(indirectCasualtiesSpinner);

        isNaturalLbl = new JLabel("La catastrophe est-elle naturelle* ? ");
        String[] isNaturalValues = {"Oui","Non"};
        isNaturalComboBox = new JComboBox(isNaturalValues);
        isNaturalComboBox.setSelectedItem("Oui");
        isNaturalComboBox.setMaximumRowCount(2);
        formSubPanel.add(isNaturalLbl);
        formSubPanel.add(isNaturalComboBox);

        formPanel.add(formSubPanel, BorderLayout.CENTER);
    }

    private void regionPanelCreation() {
        regionPanel = new JPanel();

        regionbl = new JLabel("Région(s) impactée(s)* : ");
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
            selectionnerBtn.addActionListener(new FormPanel.SelectButtonListener());
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

        formPanel.add(regionPanel, BorderLayout.SOUTH);
    }

    private void buttonsPanelCreation() {
        buttonsPanel = new JPanel();

        sendBtn = new JButton("Envoyer");
        buttonsPanel.add(sendBtn);

        this.add(buttonsPanel, BorderLayout.SOUTH);
        sendBtn.addActionListener(new FormPanel.InsertButtonListener());
    }

    private void fillForm() {
        nameTF.setText(disasterToModify.getName());
        descriptionTF.setText(disasterToModify.getDescription());
        typeComboBox.setSelectedItem(disasterToModify.getType());
        startDateTF.setText(disasterToModify.getDateString());
        endDateTF.setText(disasterToModify.getEndDateString());
        intensitySpinner.setValue(disasterToModify.getIntensity() == null ? 0 : disasterToModify.getIntensity());
        impactedPeopleSpinner.setValue(disasterToModify.getImpactedPeople());
        directCasualtiesSpinner.setValue(disasterToModify.getDirectCasualties());
        indirectCasualtiesSpinner.setValue(disasterToModify.getIndirectCasualties());
        isNaturalComboBox.setSelectedItem(disasterToModify.getNatural() ? "Oui" : "Non");
    }

    private class InsertButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            //Garnir avec les élements du formulaire
            Integer impactedPeople      = (Integer) impactedPeopleSpinner.getValue();
            Integer directCasualties    = (Integer) directCasualtiesSpinner.getValue();
            Integer indirectCasualties  = (Integer) indirectCasualtiesSpinner.getValue();
            String type                 = (String) typeComboBox.getSelectedItem();
            String description             = descriptionTF.getText();
            String name                 = nameTF.getText();
            Integer intensity           = (Integer) intensitySpinner.getValue();
            Boolean isNatural           = (isNaturalComboBox.getSelectedItem() == "Oui");

            // Verification des dates du formulaire
            try {
                Date date = dateFormat.parse(startDateTF.getText());
                if(!startDateTF.getText().isEmpty()){
                    startDate = new GregorianCalendar();
                    startDate.setTime(date);
                    startDate.add(Calendar.MONTH, 1);
                }
                if(!endDateTF.getText().isEmpty()) {
                    endDate = new GregorianCalendar();
                    date = dateFormat.parse(endDateTF.getText());
                    endDate.setTime(date);
                    endDate.add(Calendar.MONTH, 1);
                }
                // Garnir avec les regions choisies par l'utilisateur
                ArrayList<Region> disasterRegions = new ArrayList<>();
                ListModel model = chosenRegions.getModel();
                int i = 0;
                while(i < model.getSize() && model.getElementAt(i) != null){
                    disasterRegions.add(new Region((String)model.getElementAt(i)));
                    i++;
                }

                //Créer l'objet disaster
                Disaster disaster = new Disaster(impactedPeople,directCasualties,indirectCasualties,
                        type,description, (GregorianCalendar) startDate,isNatural,disasterRegions);

                //Ajouts des attributs facultatifs via les setters
                if(!nameTF.getText().isEmpty())
                    disaster.setName(name);
                if(intensity > 0)
                    disaster.setIntensity(intensity);

                if(!endDateTF.getText().isEmpty())
                    disaster.setEndDate((GregorianCalendar)endDate);
                //Envoie vers les couches inférieures
                if (formType == Type.INSERTION) {
                    int nbInsertedData = controller.addDisaster(disaster); // Possible de récupérer un int ici indiquant le nombre de ligne ajouté
                    if(nbInsertedData == 1)
                        JOptionPane.showMessageDialog(null, "Catastrophe ajoutée", "Ajout catastrophe", JOptionPane.INFORMATION_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(null, "Erreur (non gérée) lors de l'ajout", "Erreur ajout", JOptionPane.ERROR_MESSAGE); // Ne doit jamais apparaitre
                }
                else {
                    controller.modifyDisaster(disaster);
                }

            }
            catch (Exception exception){
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Erreur formulaire", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class SelectButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            ArrayList<Object> selectedRegions = new ArrayList<>();
            for (Object region : regions.getSelectedValuesList()){
                selectedRegions.add(region);
            }
            chosenRegions.setListData(selectedRegions.toArray());
            FormPanel.this.repaint();
        }
    }
}
