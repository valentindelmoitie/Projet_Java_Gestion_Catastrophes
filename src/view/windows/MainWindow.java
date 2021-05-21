package view.windows;

import view.panels.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class MainWindow extends JFrame {
    private Container container;
    private JMenuBar menuBar;
    private JMenu disasterMenu, taskMenu;

    public MainWindow() {
        super("Gestion de catastrophes");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1500, 600);
        this.setLocationRelativeTo(null);

        container = this.getContentPane();
        container.setLayout(new FlowLayout());

        createMenuBar();

        WelcomePanel welcomePanel = new WelcomePanel();
        container.add(welcomePanel, BorderLayout.CENTER);

        this.setVisible(true);
    }

    private void createMenuBar() {
        menuBar = new JMenuBar();

        disasterMenuCreation();
        searchMenuCreation();
        taskMenuCreation();

        this.setJMenuBar(menuBar);
    }

    private void disasterMenuCreation() {
        disasterMenu = new JMenu("Catastrophe");
        disasterMenu.setMnemonic('C');

        JMenuItem addMenuItem = new JMenuItem("Ajout");
        addMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
        addMenuItem.addActionListener(new MenuListener());
        disasterMenu.add(addMenuItem);

        JMenuItem modificationMenuItem = new JMenuItem("Modification");
        modificationMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_DOWN_MASK));
        modificationMenuItem.addActionListener(new MenuListener());
        disasterMenu.add(modificationMenuItem);

        JMenuItem removeMenuItem = new JMenuItem("Suppression");
        removeMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        removeMenuItem.addActionListener(new MenuListener());
        disasterMenu.add(removeMenuItem);

        JMenuItem listingMenuItem = new JMenuItem("Listing");
        listingMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));
        listingMenuItem.addActionListener(new MenuListener());
        disasterMenu.add(listingMenuItem);

        menuBar.add(disasterMenu);
    }

    private void searchMenuCreation() {
        JMenu searchMenu = new JMenu("Recherches");
        searchMenu.setMnemonic('R');
        menuBar.add(searchMenu);

        JMenuItem search1MenuItem = new JMenuItem("Rechercher catastrophe dans un pays entre deux dates");
        search1MenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.CTRL_DOWN_MASK));
        search1MenuItem.addActionListener(new MenuListener());
        searchMenu.add(search1MenuItem);

        JMenuItem search2MenuItem = new JMenuItem("Rechercher régions et pays touchés par une catastrophe");
        search2MenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.CTRL_DOWN_MASK));
        search2MenuItem.addActionListener(new MenuListener());
        searchMenu.add(search2MenuItem);

        JMenuItem search3MenuItem = new JMenuItem("Rechercher catastrophes ayant touché un site dangereux");
        search3MenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, InputEvent.CTRL_DOWN_MASK));
        search3MenuItem.addActionListener(new MenuListener());
        searchMenu.add(search3MenuItem);
    }

    private void taskMenuCreation() {
        taskMenu = new JMenu("Tâche métier");
        menuBar.add(taskMenu);

        JMenuItem taskMenuItem = new JMenuItem("Afficher un % de population affecté par un type de catastrophe au sein d'une région");
        taskMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_DOWN_MASK));
        taskMenuItem.addActionListener(new MenuListener());
        taskMenu.add(taskMenuItem);
    }

    private class MenuListener implements ActionListener {
        public void actionPerformed(ActionEvent event){
            container.removeAll();
            switch (event.getActionCommand()) {
                case "Ajout" -> container.add(new AddPanel());
                case "Suppression" -> container.add(new RemovePanel());
                case "Modification" -> container.add(new ModifyPanel());
                case "Listing" -> container.add(new ListingPanel(ListSelectionModel.SINGLE_SELECTION));
                case "Rechercher catastrophe dans un pays entre deux dates" -> container.add(new Search1Panel());
                case "Rechercher régions et pays touchés par une catastrophe" -> container.add(new Search2Panel());
                case "Rechercher catastrophes ayant touché un site dangereux" -> container.add(new Search3Panel());
                case "Afficher un % de population affecté par un type de catastrophe au sein d'une région" -> container.add(new BusinessTaskPanel());
                default -> JOptionPane.showMessageDialog(null, "Valeur inattendue : " + event.getActionCommand(), "Exception levée", JOptionPane.ERROR_MESSAGE);
            }
            container.repaint();
            container.validate();
        }
    }
}
