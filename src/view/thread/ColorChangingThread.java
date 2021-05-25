package view.thread;

import view.panels.WelcomePanel;

public class ColorChangingThread extends Thread {

    private WelcomePanel welcomePanel;

    public ColorChangingThread(WelcomePanel welcomePanel) {
        this.welcomePanel = welcomePanel;
    }

    public void run() {
        try {
            while(true) {
                welcomePanel.changeColor();
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            e.printStackTrace(); //Possibilité de récupérer une possible erreur (message) et de l'afficher à la console, ne nous semble pas pertinent dans le cadre de ce projet/thread
        }
    }
}
