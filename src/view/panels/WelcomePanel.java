package view.panels;

import javax.swing.*;

public class WelcomePanel extends JPanel {
    private JLabel welcomeLabel;

    public WelcomePanel() {
        welcomeLabel = new JLabel("<html><h3>Bienvenue sur le programme de gestion de catastrophes de Mathieu et Valentin.</h3></html>");
     //new JLabel("<html><h3>Bienvenue sur le programme de gestion de catastrophes de Mathieu et Valentin.</h3></html>");
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);

        this.add(welcomeLabel);
    }
}
