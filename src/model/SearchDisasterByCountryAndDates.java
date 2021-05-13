package model;

import exception.EndDateException;
import exception.StartDateException;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class SearchDisasterByCountryAndDates {

    private Country country;
    private GregorianCalendar startDate;
    private GregorianCalendar endDate;


    public SearchDisasterByCountryAndDates(Country country, GregorianCalendar startDate, GregorianCalendar endDate) throws EndDateException, StartDateException{
        setCountry(country);
        setStartDate(startDate);
        setEndDate(endDate);
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setStartDate(GregorianCalendar startDate) throws StartDateException{
        Calendar today = new GregorianCalendar();
        if(startDate.compareTo(today) > 0) throw new StartDateException();
        else
            this.startDate = startDate;
    }

    public void setEndDate(GregorianCalendar endDate) throws EndDateException{
        if(endDate != null)
            if(endDate.compareTo(startDate) < 0) throw new EndDateException();
        this.endDate = endDate;
    }

    public Country getCountry() {
        return country;
    }

    public GregorianCalendar getStartDate() {
        return startDate;
    }

    public GregorianCalendar getEndDate() {
        return endDate;
    }
}
