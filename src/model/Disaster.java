package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class Disaster {
    private Integer id;
    private Integer intensity;
    private Integer impactedPeople;
    private Integer directCasualties;
    private Integer indirectCasualties;
    private String name;
    private String type;
    private String description;
    private Date date;
    private Date endDate;
    private Boolean isNatural;
    private ArrayList<Region> regions;

    public Disaster(Integer id, Integer impactedPeople, Integer directCasualties, Integer indirectCasualties, String type, String description, Date date, Boolean isNatural, ArrayList<Region> regions) {
        this.id = id;
        this.impactedPeople = impactedPeople;
        this.directCasualties = directCasualties;
        this.indirectCasualties = indirectCasualties;
        this.type = type;
        this.description = description;
        this.date = date;
        this.isNatural = isNatural;
        this.regions = regions;
    }

    public void setIntensity(Integer intensity) {
        this.intensity = intensity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public Integer getIntensity() {
        return intensity;
    }
}
