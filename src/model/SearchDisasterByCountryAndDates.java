package model;

import java.util.GregorianCalendar;

public class SearchDisasterByCountryAndDates {

    private Country country;
    private GregorianCalendar startDate;
    private GregorianCalendar endDate;


    public SearchDisasterByCountryAndDates(Country country, GregorianCalendar startDate, GregorianCalendar endDate) {
        setCountry(country);
        setStartDate(startDate);
        setEndDate(endDate);
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setStartDate(GregorianCalendar startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(GregorianCalendar endDate) {
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
