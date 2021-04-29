package view.panels;

import javax.swing.*;
import java.awt.*;

public class RemovePanel extends JPanel {
    private JPanel titlePanel, formPanel, buttonsPanel;
    private JLabel titleLbl, toDeleteLabel;
    private JComboBox toDeleteCB;
    private JButton sendBtn;

    public RemovePanel() {
        this.setLayout(new BorderLayout());

        titlePanelCreation();
        formPanelCreation();
        buttonsPanelCreation();
    }

    private void titlePanelCreation() {
        titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());

        titleLbl = new JLabel("<html><h3>Suppression d'une catastrophe de la baese de données</h3></html>");
        titlePanel.add(titleLbl);

        this.add(titlePanel, BorderLayout.NORTH);
    }

    private void formPanelCreation() {
        formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(1, 2, 5, 5));

        toDeleteLabel = new JLabel("Catastrophe à supprimer : ");
        toDeleteCB = new JComboBox();

        formPanel.add(toDeleteLabel);
        formPanel.add(toDeleteCB);

        this.add(formPanel);
    }

    private void buttonsPanelCreation() {
        buttonsPanel = new JPanel();

        sendBtn = new JButton("Envoyer");
        buttonsPanel.add(sendBtn);

        this.add(buttonsPanel, BorderLayout.SOUTH);
    }
}
