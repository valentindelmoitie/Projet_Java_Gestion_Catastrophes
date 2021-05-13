package view.panels;

import controller.ApplicationController;
import model.Region;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class AddPanel extends JPanel {
    private FormPanel formPanel;

    public AddPanel() {
        formPanel = new FormPanel(FormPanel.Type.INSERTION);
        this.add(formPanel);
    }
}
