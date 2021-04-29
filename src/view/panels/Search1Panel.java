package view.panels;

import javax.swing.*;
import java.awt.*;

public class Search1Panel extends JPanel {
    private JPanel titlePanel, formPanel, buttonPanel;
    private JLabel descriptionLabel, countryLabel, beginDateLabel, endDateLabel;
    private JComboBox countryComboBox;
    private JSpinner beginDateSpinner, endDateSpinner;

    public Search1Panel() {
        this.setLayout(new BorderLayout());

        titlePanelCreation();
        formPanelCreation();
        buttonPanelCreation();
    }

    private void titlePanelCreation() {
        titlePanel = new JPanel();
        descriptionLabel = new JLabel("<html><h3>Rechercher les catastrophes dans un pays entre deux dates précises</h3></html>");
        titlePanel.add(descriptionLabel);
        this.add(titlePanel, BorderLayout.NORTH);
    }

    private void formPanelCreation() {
        String[] test = {"USA", "Belgique", "France", "Canada"};

        formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(3, 2, 5, 5));

        countryLabel = new JLabel("Pays : ");
        formPanel.add(countryLabel);

        countryComboBox = new JComboBox(test);
        formPanel.add(countryComboBox);

        beginDateLabel = new JLabel("Date de début : ");
        formPanel.add(beginDateLabel);

        beginDateSpinner = new JSpinner(new SpinnerDateModel());
        beginDateSpinner.setEditor(new JSpinner.DateEditor(beginDateSpinner, "dd.MM.yyyy"));
        formPanel.add(beginDateSpinner);

        endDateLabel = new JLabel("Date de fin : ");
        formPanel.add(endDateLabel);

        endDateSpinner = new JSpinner(new SpinnerDateModel());
        endDateSpinner.setEditor(new JSpinner.DateEditor(endDateSpinner, "dd.MM.yyyy"));
        formPanel.add(endDateSpinner);

        this.add(formPanel, BorderLayout.CENTER);
    }

    private void buttonPanelCreation() {
        buttonPanel = new JPanel();

        JButton sendButton = new JButton("Envoyer !");

        buttonPanel.add(sendButton);

        this.add(buttonPanel, BorderLayout.SOUTH);
    }
}
