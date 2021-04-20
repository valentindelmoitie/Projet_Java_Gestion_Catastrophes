package view.frames;

import javax.swing.*;

public class WelcomePanel extends JPanel {
    private JLabel welcomeText;

    public WelcomePanel() {
        welcomeText = new JLabel("<html>" +
                "<p><font color=RED>bienvenue</font> sur le programme de gestion des catastrophes</p>" +
                "</html>");

        add(welcomeText);
    }
}
