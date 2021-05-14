package view.panels;

import view.thread.ColorChangingThread;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static java.awt.Color.*;

public class WelcomePanel extends JPanel {
    private static final Color[] colors = {red,green,blue,black,gray,darkGray};
    private JLabel welcomeLabel;

    private Color color;



    public WelcomePanel() {
        welcomeLabel = new JLabel("<html><h2>Bienvenue sur le programme de gestion de catastrophes de Mathieu et Valentin.</h2></html>\n");
        ColorChangingThread threadChangingColor = new ColorChangingThread(this);
        threadChangingColor.start();
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(welcomeLabel);
    }

    public void changeColor(){
        Random rand = new Random();
        int random = rand.nextInt(6);
        this.color = colors[random];
        welcomeLabel.setForeground(color);
        System.out.println("Ceci est une sortie console provenant d'une méthode appelée par le thread");
        this.repaint();
    }
}
