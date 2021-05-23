package view.panels;

import controller.ApplicationController;
import exception.SelectionException;
import model.Disaster;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Locale;

public class RemovePanel extends JPanel {
    private ApplicationController controler;
    private ListingPanel listingPanel;

    public RemovePanel() {
        controler = new ApplicationController();
        this.setLayout(new BorderLayout());

        titleCreation();
        listingCreation();
        buttonsCreation();
    }

    public void titleCreation() {
        JLabel title = new JLabel("<html><h3>Supprimer une / des catastrophe(s)</h3></html>");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(title, BorderLayout.NORTH);
    }

    public void listingCreation() {
        listingPanel = new ListingPanel(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        this.add(listingPanel, BorderLayout.CENTER);
    }

    public void buttonsCreation() {
        JButton deleteBtn = new JButton("Supprimer");
        deleteBtn.addActionListener(new ButtonListener());
        this.add(deleteBtn, BorderLayout.SOUTH);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            try {

                ArrayList disasters = listingPanel.getSelectedDisasters();

                int validation = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir supprimer la/les catastrophe(s) sélectionnée(s) ?", "Validation", JOptionPane.YES_NO_OPTION);

                if (validation == 0) {
                    controler.deleteDisasters(disasters);

                    remove(listingPanel);
                    listingPanel = new ListingPanel(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                    add(listingPanel);
                    repaint();
                    validate();
                }
            }
            catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Exception levée", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
