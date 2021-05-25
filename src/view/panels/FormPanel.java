package view.panels;

import controller.ApplicationController;
import exception.FormException;
import model.Disaster;
import model.Region;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
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
    public final int NUM_SPINNER_START_VALUE = 0;
    public final int NUM_SPINNER_MIN_VALUE = 0;
    public final int INTENSITY_SPINNER_MAX_VALUE = 7;
    public final int NUM_SPINNER_STEP = 1;
    private Type formType;
    private Disaster disasterToModify;
    private ApplicationController controller;
    private JPanel formPanel;
    private JTextField nameTF, descriptionTF, startDateTF, endDateTF;
    private JSpinner intensitySpinner, impactedPeopleSpinner, directCasualtiesSpinner, indirectCasualtiesSpinner;
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
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new GridLayout(2,1));

        JLabel titleLbl = new JLabel();
        if (formType == Type.INSERTION)
            titleLbl.setText("<html><h3><center>Ajout d'une catastrophe à la base de données</h3></html>");
        else
            titleLbl.setText("<html><h3>Modification d'une catastrophe dans la base de données</h3></html>");

        titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
        titlePanel.add(titleLbl);

        JLabel descriptionLbl = new JLabel("<html><b>Les champs marqués d'une * sont obligatoires.</b></html>");
        descriptionLbl.setHorizontalAlignment(SwingConstants.CENTER);
        titlePanel.add(descriptionLbl);

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
        JPanel formSubPanel = new JPanel();
        formSubPanel.setLayout(new GridLayout(10, 2));

        JLabel nameLbl = new JLabel("Nom de la catastrophe : ");
        nameTF = new JTextField();
        formSubPanel.add(nameLbl);
        formSubPanel.add(nameTF);

        JLabel descriptionLbl = new JLabel("Description de la catastrophe* : ");
        descriptionTF = new JTextField();
        formSubPanel.add(descriptionLbl);
        formSubPanel.add(descriptionTF);

        JLabel typeLbl = new JLabel("Type de la catastrophe* : ");
        String[] types = {"Humanitaire","Incendie","Industriel", "Naufrage","Nucléaire","Ouragan","Tremblement de terre", "Tsunami"};
        typeComboBox = new JComboBox(types);
        typeComboBox.setSelectedItem("Humanitaire");
        typeComboBox.setMaximumRowCount(4);
        formSubPanel.add(typeLbl);
        formSubPanel.add(typeComboBox);

        JLabel dateLbl = new JLabel("Date de début (dd/mm/yyyy)* : ");
        startDateTF = new JTextField();
        formSubPanel.add(dateLbl);
        formSubPanel.add(startDateTF);

        JLabel endDateLbl = new JLabel("Date de fin (dd/mm/yyyy): ");
        endDateTF = new JTextField();
        formSubPanel.add(endDateLbl);
        formSubPanel.add(endDateTF);

        JLabel intensityLbl = new JLabel("Intensité de la catastrophe (0 si pas nécessaire) : ");
        intensitySpinner = new JSpinner(new SpinnerNumberModel(NUM_SPINNER_START_VALUE,NUM_SPINNER_MIN_VALUE,INTENSITY_SPINNER_MAX_VALUE,NUM_SPINNER_STEP));
        formSubPanel.add(intensityLbl);
        formSubPanel.add(intensitySpinner);

        JLabel impactedPeopleLbl = new JLabel("Nombre de personnes touchées* : ");
        impactedPeopleSpinner = new JSpinner(new SpinnerNumberModel(NUM_SPINNER_START_VALUE,NUM_SPINNER_MIN_VALUE,Integer.MAX_VALUE,NUM_SPINNER_STEP));
        formSubPanel.add(impactedPeopleLbl);
        formSubPanel.add(impactedPeopleSpinner);


        JLabel directCasualtiesLbl = new JLabel("Nombre de victimes directes* : ");
        directCasualtiesSpinner = new JSpinner(new SpinnerNumberModel(NUM_SPINNER_START_VALUE,NUM_SPINNER_MIN_VALUE,Integer.MAX_VALUE,NUM_SPINNER_STEP));
        formSubPanel.add(directCasualtiesLbl);
        formSubPanel.add(directCasualtiesSpinner);

        JLabel indirectCasualtiesLbl = new JLabel("Nombre de victimes indirectes* : ");
        indirectCasualtiesSpinner = new JSpinner(new SpinnerNumberModel(NUM_SPINNER_START_VALUE,NUM_SPINNER_MIN_VALUE,Integer.MAX_VALUE,NUM_SPINNER_STEP));
        formSubPanel.add(indirectCasualtiesLbl);
        formSubPanel.add(indirectCasualtiesSpinner);

        JLabel isNaturalLbl = new JLabel("La catastrophe est-elle naturelle* ? ");
        String[] isNaturalValues = {"Oui","Non"};
        isNaturalComboBox = new JComboBox(isNaturalValues);
        isNaturalComboBox.setSelectedItem("Oui");
        isNaturalComboBox.setMaximumRowCount(2);
        formSubPanel.add(isNaturalLbl);
        formSubPanel.add(isNaturalComboBox);

        formPanel.add(formSubPanel, BorderLayout.CENTER);
    }

    private void regionPanelCreation() {
        JPanel regionPanel = new JPanel();

        JLabel regionbl = new JLabel("Région(s) impactée(s)* : ");
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

            JButton selectionnerBtn = new JButton("Selectionner");
            selectionnerBtn.addActionListener(new FormPanel.SelectButtonListener());
            regionPanel.add(selectionnerBtn);

            chosenRegions = new JList();
            chosenRegions.setVisibleRowCount(5);
            chosenRegions.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            regionPanel.add(new JScrollPane(chosenRegions));

        }catch(Exception exception){
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Exception levée", JOptionPane.ERROR_MESSAGE);
        }

        formPanel.add(regionPanel, BorderLayout.SOUTH);
    }

    private void buttonsPanelCreation() {
        JPanel buttonsPanel = new JPanel();

        JButton sendBtn = new JButton("Envoyer");
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

    private class InsertButtonListener implements ActionListener {
        private String description;
        private String type;
        private String dateString;
        private GregorianCalendar startDate;
        private Integer impactedPeople;
        private Integer directCasualties;
        private Integer indirectCasualties;
        private Boolean isNatural;
        private ArrayList<Region> regions;
        private ListModel regionsModel;

        private String name;
        private String endDateString;
        private GregorianCalendar endDate;
        private Integer intensity;

        public void actionPerformed(ActionEvent event){
            try {
                getMandatoryInputs();
                mandatoryInputsVerification();

                Date date = dateFormat.parse(startDateTF.getText());
                if(!startDateTF.getText().isEmpty()){
                    startDate = new GregorianCalendar();
                    startDate.setTime(date);
                }

                Calendar today = new GregorianCalendar();
                if(startDate.compareTo(today) <= 0) { // Continue si la date n'est pas supérieure à la date du jour
                    int i = 0;
                    while (i < regionsModel.getSize() && regionsModel.getElementAt(i) != null) {
                        regions.add(new Region((String) regionsModel.getElementAt(i)));
                        i++;
                    }

                    Disaster disaster = new Disaster(impactedPeople,directCasualties,indirectCasualties,
                            type, description, (GregorianCalendar) startDate, isNatural, regions);

                    getOptionalInputs();
                    optionalInputsVerification();

                    if (!name.equals("")) {
                        disaster.setName(name);
                    }

                    if (!endDateString.equals("")) {
                        endDate = new GregorianCalendar();
                        date = dateFormat.parse(endDateString);
                        endDate.setTime(date);
                        if (endDate.compareTo(startDate) <= 0) {
                            disaster.setEndDate(endDate);
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Erreur : La date de fin ne peut pas être supérieure à la date de début. La date de fin n'a donc pas été appliquée. Veuillez modifier le désastre ultérieurement pour ajouter une date de fin.", "Erreur ajout", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                    if (intensity != 0) {
                        disaster.setIntensity(intensity);
                    }

                    if (formType == Type.INSERTION) {
                        int nbInsertedData = controller.addDisaster(disaster);
                        if(nbInsertedData == 1)
                            JOptionPane.showMessageDialog(null, "Catastrophe ajoutée", "Ajout catastrophe", JOptionPane.INFORMATION_MESSAGE);
                        else
                            JOptionPane.showMessageDialog(null, "Erreur (non gérée) lors de l'ajout", "Erreur ajout", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        disaster.setId(disasterToModify.getId());
                        int nbModifiedData = controller.modifyDisaster(disaster);
                        if(nbModifiedData == 1)
                            JOptionPane.showMessageDialog(null, "Catastrophe modifiée", "Modification catastrophe catastrophe", JOptionPane.INFORMATION_MESSAGE);
                        else
                            JOptionPane.showMessageDialog(null, "Erreur (non gérée) lors de la modification", "Erreur ajout", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else
                    JOptionPane.showMessageDialog(null, "La date entrée ne peut être supérieure à la date du jour.", "Erreur formulaire", JOptionPane.ERROR_MESSAGE);

            }catch(ParseException exception){
                JOptionPane.showMessageDialog(null, "Le format de date entré ne correspond aux valeurs normalement attendues : " + exception.getMessage(), "Erreur formulaire", JOptionPane.ERROR_MESSAGE);
            }catch (Exception exception){
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Erreur formulaire", JOptionPane.ERROR_MESSAGE);
            }
        }

        private void getMandatoryInputs() {
            description         = descriptionTF.getText();
            type                = (String) typeComboBox.getSelectedItem();
            dateString          = startDateTF.getText();
            impactedPeople      = (Integer) impactedPeopleSpinner.getValue();
            directCasualties    = (Integer) directCasualtiesSpinner.getValue();
            indirectCasualties  = (Integer) indirectCasualtiesSpinner.getValue();
            isNatural           = (isNaturalComboBox.getSelectedItem() == "Oui");
            regions             = new ArrayList<>();
            regionsModel        = chosenRegions.getModel();
        }

        private void mandatoryInputsVerification() throws FormException {
            StringBuilder errorMessage = new StringBuilder("Erreur : ");
            ArrayList<String> errorFields = new ArrayList<>();

            if (description == null || description.equals(""))
                errorFields.add("description,");

            if (dateString.equals(""))
                errorFields.add("date,");

            if (regionsModel.getSize() == 0)
                errorFields.add("région(s) impactée(s)");

            if (errorFields.size() == 0) {
                if (!Disaster.getAllowedTypes().contains(type))
                    errorFields.add("Le type entré n'est pas repris dans la liste des types");

                if (directCasualties < 0)
                    errorFields.add("La nombre de victimes directes ne peut être inférieur à 0");


                if (indirectCasualties < 0)
                    errorFields.add("Le nombre de victimes indirectes ne peut être inférieur à 0");


                if (impactedPeople < 0)
                    errorFields.add("Le nombre de personnes touchées ne peut être inférieur à 0");

                if (impactedPeople  < directCasualties + indirectCasualties)
                    errorFields.add("Le nombre de personnes touchées doit être supérieur au nombre de victimes");


                if (errorFields.size() != 0) {
                    errorMessage.append("Vous n'avez pas respecté les conditions des champs suivants : \n");

                    for (String errorString : errorFields) {
                        errorMessage.append("- " + errorString + "\n");
                    }

                    throw new FormException(errorMessage.toString());
                }
            }
            else {
                errorMessage.append("Vous n'avez pas remplis tous les champs obligatoires. Voici ceux que vous n'avez pas remplis ; ");

                for (String string : errorFields)
                    errorMessage.append(string + " ");

                throw new FormException(errorMessage.toString());
            }
        }

        private void getOptionalInputs() {
            name = nameTF.getText();
            endDateString = endDateTF.getText();
            intensity = (Integer) intensitySpinner.getValue();
        }

        private void optionalInputsVerification() throws FormException {
            StringBuilder errorMessage = new StringBuilder("Erreur : ");
            ArrayList<String> errorFields = new ArrayList<>();

            if (intensity < 0 || intensity > 7)
                errorFields.add("L'intensité ne peut être inférieure à 0 ou supérieure à 7");

            if (errorFields.size() != 0) {
                errorMessage.append("Un ou plusieurs paramètre facultatif est incorrect :\n");
                for (String errorString : errorFields) {
                    errorMessage.append("- " + errorString + "\n");
                }
                throw new FormException(errorMessage.toString());
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
