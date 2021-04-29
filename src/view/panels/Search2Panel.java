package view.panels;

import javax.swing.*;
import java.awt.*;

public class Search2Panel extends JPanel {
    private JLabel descriptionLabel, disasterLabel;
    private JComboBox disasterCb;
    private JPanel topPanel, centerPanel, southPanel;
    private JButton sendButton;

    public Search2Panel() {
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
        descriptionLabel = new JLabel("<html><h3>Rechercher les pays et régions impactés par une catastrophe</h3></html>");
        topPanel.add(descriptionLabel);
    }

    private void centerPanelCreation() {
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(1, 2, 5, 5));

        disasterLabel = new JLabel("Catastrophe : ");
        centerPanel.add(disasterLabel);

        disasterCb = new JComboBox();
        centerPanel.add(disasterCb);
    }

    private void southPanelCreation() {
        southPanel = new JPanel();

        sendButton = new JButton("Envoyer !");
        sendButton.setHorizontalAlignment(JButton.CENTER);

        southPanel.add(sendButton);
    }
}
