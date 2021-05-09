package view.panels;

import controller.ApplicationController;
import model.Region;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class AddPanel extends JPanel {
    // ajouter constante valeur min spinner + spinner intensity + starting value
    private ApplicationController controller;
    private JPanel titlePanel, formPanel, formSubPanel, regionPanel,  buttonsPanel;
    private JLabel titleLbl, nameLbl, descriptionLbl, typeLbl, dateLbl, endDateLbl, intensityLbl,
                   impactedPeopleLbl, directCasualtiesLbl, indirectCasualtiesLbl, isNaturalLbl, regionbl;
    private JTextField nameTF, descriptionTF, endDateTF;
    private JSpinner dateSpinner, intensitySpinner, impactedPeopleSpinner, directCasualtiesSpinner, indirectCasualtiesSpinner;
    private JButton sendBtn, selectionnerBtn;
    private DateFormat dateFormat;
    private JComboBox typeComboBox, isNaturalComboBox;
    private JList regions, chosenRegions;

    public AddPanel() {
        this.setLayout(new BorderLayout());
        setController(new ApplicationController());
        titlePanelCreation();
        this.add(new FormPanel());
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

    private void buttonsPanelCreation() {
        buttonsPanel = new JPanel();

        sendBtn = new JButton("Envoyer");
        buttonsPanel.add(sendBtn);

        this.add(buttonsPanel, BorderLayout.SOUTH);
        //sendBtn.addActionListener(new InsertButtonListener());
    }
}
