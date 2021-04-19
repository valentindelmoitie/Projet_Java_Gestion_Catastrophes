package view.windows;

import javax.swing.*;

public class MainWindow extends JFrame {
    private JMenuBar menuBar;
    private JMenu disasterMenu;
    private JMenuItem add, modification, removal, listing, search, businessTask, search1, search2, search3; // RENOMMER

    public MainWindow() {
        super("Catastrophe Gesture");
        setBounds(200, 100, 1000, 500);

        menuBarCreation();

        setVisible(true);
    }

    // Menu

    private void menuBarCreation() {
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        disasterMenuCreation();
    }

    private void disasterMenuCreation() {
        disasterMenu = new JMenu("Disaster");
        menuBar.add(disasterMenu);

        add = new JMenuItem("Ajouter");
        disasterMenu.add(add);

        removal = new JMenuItem("Supprimer");
        disasterMenu.add(removal);

        modification = new JMenuItem("Modifier");
        disasterMenu.add(modification);

        listing = new JMenuItem("Lister");
        disasterMenu.add(listing);

        search = new JMenu("Chercher");
        disasterMenu.add(search);
        searchItemSubMenuCreation();

        businessTask = new JMenuItem("Tâche métier");
        disasterMenu.add(businessTask);
    }

    private void searchItemSubMenuCreation() { // RENAME
        search1 = new JMenuItem("Recheche 1");
        search.add(search1);

        search2 = new JMenuItem("Recheche 2");
        search.add(search2);

        search3 = new JMenuItem("Recheche 3");
        search.add(search3);
    }
}
