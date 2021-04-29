package view.panels;

import javax.swing.*;

public class WelcomePanel extends JPanel {
    private JLabel welcomeLabel;

    public WelcomePanel() {
        welcomeLabel = new JLabel("Bienvenue sur le programme de gestion de catastrophes de Mathieu et Valentin.");
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);

        this.add(welcomeLabel);
    }
}
