package view.panels;

import javax.swing.*;

public class AddPanel extends JPanel {

    public AddPanel() {
        FormPanel formPanel = new FormPanel(FormPanel.Type.INSERTION);
        this.add(formPanel);
    }
}
