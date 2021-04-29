package view.panels;

import javax.swing.*;
import java.awt.*;

public class Search3Panel extends JPanel {
    private JLabel descriptionLabel, disasterLabel;
    private JComboBox disasterCb;
    private JPanel titlePanel, formPanel, buttonPanel;
    private JButton sendButton;

    public Search3Panel() {
        this.setLayout(new BorderLayout());

        titlePanelCreation();
        this.add(titlePanel, BorderLayout.NORTH);

        formPanelCreation();
        this.add(formPanel, BorderLayout.CENTER);

        buttonPanelCreation();
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void titlePanelCreation() {
        titlePanel = new JPanel();
        descriptionLabel = new JLabel("<html><h3>Rechercher les catastrophes ayant touché un site dangereux</h3></html>");
        titlePanel.add(descriptionLabel);
    }

    private void formPanelCreation() {
        formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(1, 2, 5, 5));

        disasterLabel = new JLabel("Catastrophe : ");
        formPanel.add(disasterLabel);

        disasterCb = new JComboBox();
        formPanel.add(disasterCb);
    }

    private void buttonPanelCreation() {
        buttonPanel = new JPanel();

        sendButton = new JButton("Envoyer !");
        sendButton.setHorizontalAlignment(JButton.CENTER);

        buttonPanel.add(sendButton);
    }
}

