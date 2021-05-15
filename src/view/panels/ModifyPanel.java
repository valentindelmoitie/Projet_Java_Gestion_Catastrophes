package view.panels;

import model.Disaster;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifyPanel extends JPanel {
    private ListingPanel listingPanel;

    public ModifyPanel() {
        this.setLayout(new BorderLayout());

        titleCreation();
        listingCreation();
        buttonsCreation();
    }

    private void titleCreation() {
        JLabel title = new JLabel("<html><h3>Modifier les données d'une catastrophe</h3></html>");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(title, BorderLayout.NORTH);
    }

    private void listingCreation() {
        listingPanel = new ListingPanel(ListSelectionModel.SINGLE_SELECTION);
        this.add(listingPanel, BorderLayout.CENTER);
    }

    private void buttonsCreation() {
        JButton modifyBtn = new JButton("Modifier");
        modifyBtn.addActionListener(new ButtonListener());
        this.add(modifyBtn, BorderLayout.SOUTH);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            try {
                Disaster disaster = listingPanel.getSelectedDisaster();
                removeAll();
                FormPanel formPanel = new FormPanel(disaster);
                add(formPanel);
                repaint();
                validate();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Exception levée", JOptionPane.ERROR_MESSAGE);
            }

        }
    }
}
