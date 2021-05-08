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
    private GregorianCalendar date;
    private GregorianCalendar endDate;
    private Boolean isNatural;
    private ArrayList<Region> regions;

    public Disaster(Integer id, Integer impactedPeople, Integer directCasualties, Integer indirectCasualties, String type, String description, GregorianCalendar date, Boolean isNatural, ArrayList<Region> regions) {
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

    public void setEndDate(GregorianCalendar endDate) {
        this.endDate = endDate;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIntensity() {
        return intensity;
    }

    public Integer getImpactedPeople() {
        return impactedPeople;
    }

    public Integer getDirectCasualties() {
        return directCasualties;
    }

    public Integer getIndirectCasualties() {
        return indirectCasualties;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date.get(GregorianCalendar.DAY_OF_MONTH) + "/" + date.get(GregorianCalendar.MONTH) + "/" +date.get(GregorianCalendar.YEAR);
    }

    public String getEndDate() {
        if (endDate != null)
            return endDate.get(GregorianCalendar.DAY_OF_MONTH) + "/" + endDate.get(GregorianCalendar.MONTH) + "/" + endDate.get(GregorianCalendar.YEAR);

        return "";
    }

    public Boolean getNatural() {
        return isNatural;
    }

    public ArrayList<Region> getRegions() {
        return regions;
    }

    public void addRegion(Region region) {
        this.regions.add(region);
    }
}
