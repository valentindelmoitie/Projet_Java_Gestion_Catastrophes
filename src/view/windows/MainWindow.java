package view.windows;

import view.panels.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends JFrame {
    private Container container;
    private JMenuBar menuBar;
    private JMenu disasterMenu, searchMenu;
    private JMenuItem addMenuItem, modificationMenuItem, removeMenuItem, listingMenuItem, search1MenuItem, search2MenuItem, search3MenuItem, taskMenuItem;
    private WelcomePanel welcomePanel;
    private Search1Panel search1Panel;

    public MainWindow() {
        super("Gestion de catastrophes");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1350, 600);
        this.setLocationRelativeTo(null);

        container = this.getContentPane();
        container.setLayout(new FlowLayout());

        createMenuBar();

        welcomePanel = new WelcomePanel();
        container.add(welcomePanel, BorderLayout.CENTER);

        this.setVisible(true);
    }

    private void createMenuBar() {
        menuBar = new JMenuBar();

        disasterMenuCreation();

        this.setJMenuBar(menuBar);
    }

    private void disasterMenuCreation() {
        disasterMenu = new JMenu("Catastrophe");
        disasterMenu.setMnemonic('C');

        addMenuItem = new JMenuItem("Ajout");
        addMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
        addMenuItem.addActionListener(new MenuListener());
        disasterMenu.add(addMenuItem);

        modificationMenuItem = new JMenuItem("Modification");
        modificationMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_DOWN_MASK));
        modificationMenuItem.addActionListener(new MenuListener());
        disasterMenu.add(modificationMenuItem);

        removeMenuItem = new JMenuItem("Suppression");
        removeMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        removeMenuItem.addActionListener(new MenuListener());
        disasterMenu.add(removeMenuItem);

        listingMenuItem = new JMenuItem("Listing");
        listingMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));
        listingMenuItem.addActionListener(new MenuListener());
        disasterMenu.add(listingMenuItem);

        searchMenuCreation();

        taskMenuItem = new JMenuItem("Tâche métier");
        taskMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_DOWN_MASK));
        disasterMenu.add(taskMenuItem);

        menuBar.add(disasterMenu);
    }

    private void searchMenuCreation() {
        searchMenu = new JMenu("Recherches");
        searchMenu.setMnemonic('R');
        disasterMenu.add(searchMenu);

        search1MenuItem = new JMenuItem("Recherche 1");
        search1MenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.CTRL_DOWN_MASK));
        search1MenuItem.addActionListener(new MenuListener());
        searchMenu.add(search1MenuItem);

        search2MenuItem = new JMenuItem("Recherche 2");
        search2MenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.CTRL_DOWN_MASK));
        search2MenuItem.addActionListener(new MenuListener());
        searchMenu.add(search2MenuItem);

        search3MenuItem = new JMenuItem("Recherche 3");
        search3MenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, InputEvent.CTRL_DOWN_MASK));
        search3MenuItem.addActionListener(new MenuListener());
        searchMenu.add(search3MenuItem);
    }

    // Inner classes
    //Remplace les anciens listeners
    private class MenuListener implements ActionListener {
        public void actionPerformed(ActionEvent event){
            container.removeAll();
            switch(event.getActionCommand()){
                case "Ajout" :
                    container.add(new AddPanel());
                    break;
                case "Suppression" :
                    container.add(new RemovePanel());
                    break;
                case "Modification" :
                    container.add(new ModifyPanel());
                    break;
                case "Recherche 1" :
                    container.add(new Search1Panel());
                    break;
                case "Listing" :
                    container.add(new ListingPanel());
                    break;
                case "Recherche 2" :
                    container.add(new Search2Panel());
                    break;
                case "Recherche 3" :
                    container.add(new Search3Panel());
                    break;
            }
            container.repaint();
            container.validate();
        }
    }
}
