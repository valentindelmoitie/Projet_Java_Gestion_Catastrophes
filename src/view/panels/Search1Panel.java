package view.panels;

import controller.ApplicationController;
import model.Country;
import model.Disaster;
import model.SearchDisasterByCountryAndDates;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Search1Panel extends JPanel {
    private JPanel titlePanel, formPanel, buttonPanel;
    private JLabel descriptionLabel, countryLabel, beginDateLabel, endDateLabel;
    private JComboBox countryComboBox;
    private JSpinner beginDateSpinner, endDateSpinner;
    private ApplicationController controller;
    private Calendar startDate, endDate;
    private DateFormat dateFormat;


    public Search1Panel() {
        this.setLayout(new BorderLayout());

        titlePanelCreation();
        formPanelCreation();
        buttonPanelCreation();
        setController(new ApplicationController());
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    }

    private void titlePanelCreation() {
        titlePanel = new JPanel();
        descriptionLabel = new JLabel("<html><h3>Rechercher les catastrophes dans un pays entre deux dates précises</h3></html>");
        titlePanel.add(descriptionLabel);
        this.add(titlePanel, BorderLayout.NORTH);
    }

    private void formPanelCreation() {
        String[] test = {"USA", "Belgique", "France", "Canada"};

        formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(3, 2, 5, 5));

        countryLabel = new JLabel("Pays : ");
        formPanel.add(countryLabel);

        countryComboBox = new JComboBox(test);
        formPanel.add(countryComboBox);

        beginDateLabel = new JLabel("Date de début : ");
        formPanel.add(beginDateLabel);

        beginDateSpinner = new JSpinner(new SpinnerDateModel());
        beginDateSpinner.setEditor(new JSpinner.DateEditor(beginDateSpinner, "dd.MM.yyyy"));
        formPanel.add(beginDateSpinner);

        endDateLabel = new JLabel("Date de fin : ");
        formPanel.add(endDateLabel);

        endDateSpinner = new JSpinner(new SpinnerDateModel());
        endDateSpinner.setEditor(new JSpinner.DateEditor(endDateSpinner, "dd.MM.yyyy"));
        formPanel.add(endDateSpinner);

        this.add(formPanel, BorderLayout.CENTER);
    }

    private void buttonPanelCreation() {
        buttonPanel = new JPanel();
        JButton sendButton = new JButton("Rechercher");
        sendButton.addActionListener(new SearchButtonListener());
        buttonPanel.add(sendButton);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    public void setController(ApplicationController controller) {
        this.controller = controller;
    }

    private class SearchButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event){
            //TEST (Faut passupprimer, une partie du code peut être adaptée)

            try {
                Date date = dateFormat.parse("14/03/1960");

                    startDate = new GregorianCalendar();
                    startDate.setTime(date);

                    endDate = new GregorianCalendar();
                    date = dateFormat.parse("14/03/2020");
                    endDate.setTime(date);

                SearchDisasterByCountryAndDates search = new SearchDisasterByCountryAndDates(new Country("Belgique", true, false), (GregorianCalendar) startDate,(GregorianCalendar) endDate);
                ArrayList<Disaster> disasters = new ArrayList<>();

                disasters = controller.getDisastersByCountryBetweenDates(search);
                for (Disaster disaster : disasters){
                    System.out.println(disaster.getId());
                }

            }catch (Exception exception){
                System.out.println(exception.getMessage());
            }
            //FIN TEST
        }
    }
}
