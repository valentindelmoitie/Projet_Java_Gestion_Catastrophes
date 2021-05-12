package view.panels;

import controller.ApplicationController;
import model.Country;
import model.SearchDisasterByCountryAndDates;
import view.AllDisastersModel;

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
    private JLabel descriptionLabel, countryLabel, dateLbl, endDateLbl;
    private JComboBox countryComboBox;
    private JTextField startDateTF, endDateTF;
    private Calendar startDate, endDate;
    private DateFormat dateFormat;
    private JTable disasterTable;
    private JScrollPane scrollPane;
    private ApplicationController controller;
    private AllDisastersModel model;
    private JPanel tablePanel;

    public Search1Panel() {

            this.setLayout(new BorderLayout());
            setController(new ApplicationController());
            titlePanelCreation();
            formPanelCreation();
            buttonPanelCreation();
            tablePanel = new JPanel();
            dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            model = new AllDisastersModel(controller.getAllDisaster());

            disasterTable = new JTable(model);
            scrollPane = new JScrollPane(disasterTable);
            scrollPane.setPreferredSize(new Dimension(1300, 400));

            disasterTable.getColumnModel().getColumn(0).setPreferredWidth(5);
            disasterTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            disasterTable.getColumnModel().getColumn(3).setPreferredWidth(200);
            disasterTable.getColumnModel().getColumn(6).setPreferredWidth(5);

            tablePanel.add(scrollPane);
            this.add(tablePanel, BorderLayout.SOUTH);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void titlePanelCreation() {
        titlePanel = new JPanel();
        descriptionLabel = new JLabel("<html><h3>Rechercher les catastrophes dans un pays entre deux dates précises</h3></html>");
        titlePanel.add(descriptionLabel);
        this.add(titlePanel, BorderLayout.NORTH);
    }

    private void formPanelCreation() {
        try {

            ArrayList<Country> countriesAL = controller.getAllCountries();
            String[] countries = new String[controller.getAllCountries().size()];
            int i = 0;
            for(Country country : countriesAL) {
                countries[i] = country.getName();
                i++;
            }
            formPanel = new JPanel();
            formPanel.setLayout(new GridLayout(3, 2, 5, 5));

            countryLabel = new JLabel("Pays : ");
            formPanel.add(countryLabel);

            countryComboBox = new JComboBox(countries);
            formPanel.add(countryComboBox);

            dateLbl = new JLabel("Date minimum (dd/mm/yyyy)* : ");
            startDateTF = new JTextField();
            formPanel.add(dateLbl);
            formPanel.add(startDateTF);

            endDateLbl = new JLabel("Date maximum (dd/mm/yyyy)*: ");
            endDateTF = new JTextField();
            formPanel.add(endDateLbl);
            formPanel.add(endDateTF);





        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }

        this.add(formPanel, BorderLayout.CENTER);
    }

    private void buttonPanelCreation() {
        buttonPanel = new JPanel();
        JButton sendButton = new JButton("Rechercher");
        sendButton.addActionListener(new SearchButtonListener());
        buttonPanel.add(sendButton);
        this.add(buttonPanel, BorderLayout.EAST);
    }



    public void setController(ApplicationController controller) {
        this.controller = controller;
    }

    private class SearchButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event){
            try {
                Date date = dateFormat.parse(startDateTF.getText());
                if(!startDateTF.getText().isEmpty()){
                    startDate = new GregorianCalendar();
                    startDate.setTime(date);
                }
                if(!endDateTF.getText().isEmpty()) {
                    endDate = new GregorianCalendar();
                    date = dateFormat.parse(endDateTF.getText());
                    endDate.setTime(date);
                }
                SearchDisasterByCountryAndDates search = new SearchDisasterByCountryAndDates(new Country(countryComboBox.getSelectedItem().toString(), null, null), (GregorianCalendar) startDate,(GregorianCalendar) endDate);
                model = new AllDisastersModel( controller.getDisastersByCountryBetweenDates(search));
                disasterTable.setModel(model);
                repaint();
                validate();

            }catch (Exception exception){
                System.out.println(exception.getMessage());
            }
        }
    }
}
