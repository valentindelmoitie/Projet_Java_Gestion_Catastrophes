package view.panels;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class AddPanel extends JPanel {
    private JPanel titlePanel, formPanel, buttonsPanel;
    private JLabel titleLbl, idLbl, nameLbl, descriptionLbl, typeLbl, dateLbl, endDateLbl, intensityLbl, impactedPeopleLbl, directCasualtiesLbl, indirectCasualtiesLbl, isNaturalLbl;
    private JTextField idTF, nameTF, descriptionTF, typeTF, impactedPeopleTF, directCasualtiesTF, indirectCasualtiesTF;
    private JSpinner dateSpinner, endDateSpinner, intensitySpinner;
    private JButton sendBtn;

    private JRadioButton isNaturalJRBYes, isNaturalJRBNo;
    private ButtonGroup buttonGroupIsNatural;

    public AddPanel() {
        this.setLayout(new BorderLayout());

        titlePanelCreation();
        formPanelCreation();
        buttonsPanelCreation();
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
        formPanel.setLayout(new GridLayout(11, 2));

        
        idLbl = new JLabel("Id de la catastrophe : ");
        idTF = new JTextField();
        formPanel.add(idLbl);
        formPanel.add(idTF);


        nameLbl = new JLabel("Nom de la catastrophe (facultatif) : ");
        nameTF = new JTextField();
        formPanel.add(nameLbl);
        formPanel.add(nameTF);


        descriptionLbl = new JLabel("Description de la catastrophe : ");
        descriptionTF = new JTextField();
        formPanel.add(descriptionLbl);
        formPanel.add(descriptionTF);


        typeLbl = new JLabel("Type de la catastrophe : ");
        typeTF = new JTextField();
        formPanel.add(typeLbl);
        formPanel.add(typeTF);


        dateLbl = new JLabel("Date de début : ");
        dateSpinner = new JSpinner(new SpinnerDateModel());
        dateSpinner.setEditor(new JSpinner.DateEditor(dateSpinner, "dd.MM.yyyy"));
        formPanel.add(dateLbl);
        formPanel.add(dateSpinner);


        endDateLbl = new JLabel("Date de fin : ");
        endDateSpinner = new JSpinner(new SpinnerDateModel());
        endDateSpinner.setEditor(new JSpinner.DateEditor(endDateSpinner, "dd.MM.yyyy"));
        formPanel.add(endDateLbl);
        formPanel.add(endDateSpinner);


        intensityLbl = new JLabel("Intensité de la catastrophe (0 si pas nécessaire) : ");
        intensitySpinner = new JSpinner();
        formPanel.add(intensityLbl);
        formPanel.add(intensitySpinner);


        impactedPeopleLbl = new JLabel("Nombre de personnes touchées : ");
        impactedPeopleTF = new JTextField();
        formPanel.add(impactedPeopleLbl);
        formPanel.add(impactedPeopleTF);


        directCasualtiesLbl = new JLabel("Nombre de personnes directement touchées : ");
        directCasualtiesTF = new JTextField();
        formPanel.add(directCasualtiesLbl);
        formPanel.add(directCasualtiesTF);


        indirectCasualtiesLbl = new JLabel("Nombre de personnes indirectement touchées : ");
        indirectCasualtiesTF = new JTextField();
        formPanel.add(indirectCasualtiesLbl);
        formPanel.add(indirectCasualtiesTF);


        isNaturalLbl = new JLabel("La catastrophe est-elle naturelle ? ");
        isNaturalJRBYes = new JRadioButton("Oui",true);
        isNaturalJRBNo = new JRadioButton("Non",false);
        buttonGroupIsNatural = new ButtonGroup();
        buttonGroupIsNatural.add(isNaturalJRBNo);
        buttonGroupIsNatural.add(isNaturalJRBYes);

        JPanel jPanelRadioButton = new JPanel();
        jPanelRadioButton.add(isNaturalJRBYes);
        jPanelRadioButton.add(isNaturalJRBNo);

        formPanel.add(isNaturalLbl);
        formPanel.add(jPanelRadioButton);



        this.add(formPanel, BorderLayout.CENTER);
    }

    private void buttonsPanelCreation() {
        buttonsPanel = new JPanel();

        sendBtn = new JButton("Envoyer");
        buttonsPanel.add(sendBtn);

        this.add(buttonsPanel, BorderLayout.SOUTH);
    }
}
