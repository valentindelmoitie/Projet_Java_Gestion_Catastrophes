package view.panels;

import javax.swing.*;
import java.awt.*;

public class Search1Panel extends JPanel {
    private JPanel topPanel, centerPanel, southPanel;
    private JLabel descriptionLabel, countryLabel, beginDateLabel, endDateLabel;
    private JComboBox countryComboBox;
    private JSpinner beginDateSpinner, endDateSpinner;

    public Search1Panel() {
        this.setLayout(new BorderLayout());

        topPanelCreation();
        this.add(topPanel, BorderLayout.NORTH);

        centerPanelCreation();
        this.add(centerPanel, BorderLayout.CENTER);

        southPanelCreation();
        this.add(southPanel, BorderLayout.SOUTH);
    }

    private void topPanelCreation() {
        topPanel = new JPanel();
        descriptionLabel = new JLabel("<html><h3>Rechercher les catastrophes dans un pays entre deux dates précises</h3></html>");
        topPanel.add(descriptionLabel);
    }

    private void centerPanelCreation() {
        String[] test = {"USA", "Belgique", "France", "Canada"};

        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 2, 5, 5));

        countryLabel = new JLabel("Pays : ");
        centerPanel.add(countryLabel);

        countryComboBox = new JComboBox(test);
        centerPanel.add(countryComboBox);

        beginDateLabel = new JLabel("Date de début : ");
        centerPanel.add(beginDateLabel);

        beginDateSpinner = new JSpinner(new SpinnerDateModel());
        beginDateSpinner.setEditor(new JSpinner.DateEditor(beginDateSpinner, "dd.MM.yyyy"));
        centerPanel.add(beginDateSpinner);

        endDateLabel = new JLabel("Date de fin : ");
        centerPanel.add(endDateLabel);

        endDateSpinner = new JSpinner(new SpinnerDateModel());
        endDateSpinner.setEditor(new JSpinner.DateEditor(endDateSpinner, "dd.MM.yyyy"));
        centerPanel.add(endDateSpinner);
    }

    private void southPanelCreation() {
        southPanel = new JPanel();

        JButton sendButton = new JButton("Envoyer !");

        southPanel.add(sendButton);
    }
}
