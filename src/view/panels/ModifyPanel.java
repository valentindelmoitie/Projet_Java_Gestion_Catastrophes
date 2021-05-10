package view.panels;

import exception.SelectionException;
import model.Disaster;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifyPanel extends JPanel {
    private JLabel title;
    private ListingPanel listingPanel;
    private JButton modifyBtn;
    private FormPanel formPanel;

    public ModifyPanel() {
        this.setLayout(new BorderLayout());

        titleCreation();
        listingCreation();
        buttonsCreation();
    }

    private void titleCreation() {
        title = new JLabel("<html><h3>Modifier les données d'une catastrophe</h3></html>");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(title, BorderLayout.NORTH);
    }

    private void listingCreation() {
        listingPanel = new ListingPanel(ListSelectionModel.SINGLE_SELECTION);
        this.add(listingPanel, BorderLayout.CENTER);
    }

    private void buttonsCreation() {
        modifyBtn = new JButton("Modifier");
        modifyBtn.addActionListener(new ButtonListener());
        this.add(modifyBtn, BorderLayout.SOUTH);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            try {
                Disaster disaster = listingPanel.getSelectedDisaster();

                removeAll();
                formPanel = new FormPanel();
                add(formPanel);
                repaint();
                validate();
            } catch (SelectionException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur formulaire", JOptionPane.ERROR_MESSAGE);
            }

        }
    }


}
