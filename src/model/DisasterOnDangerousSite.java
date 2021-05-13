package model;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import static java.util.Calendar.MONTH;

public class DisasterOnDangerousSite {
    private Integer id;
    private String type;
    private GregorianCalendar date;
    private Integer intensity;
    private Integer impactedPeople;
    private Integer directCasualties;
    private Integer indirectCasualties;
    private Boolean isNatural;
    private Region regionOfDangerousSite;

    public DisasterOnDangerousSite(Integer id, String type, GregorianCalendar date, Integer intensity, Integer impactedPeople, Integer directCasualties, Integer indirectCasualties, Boolean isNatural, Region regionOfDangerousSite){
        this.id = id;
        this.type = type;
        this.date = date;
        this.intensity = intensity;
        this.impactedPeople = impactedPeople;
        this.directCasualties = directCasualties;
        this.indirectCasualties = indirectCasualties;
        this.isNatural = isNatural;
        this.regionOfDangerousSite = regionOfDangerousSite;
    }

    public DisasterOnDangerousSite(Integer id, String type, GregorianCalendar date, Integer impactedPeople, Integer directCasualties, Integer indirectCasualties, Boolean isNatural, Region regionOfDangerousSite) {
        this(id,type, date,null ,impactedPeople,directCasualties,indirectCasualties,isNatural,regionOfDangerousSite);
    }

    public void setIntensity(Integer intensity) {
        this.intensity = intensity;
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public GregorianCalendar getDate() {
        return date;
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

    public Boolean getNatural() {
        return isNatural;
    }

    public Region getRegionOfDangerousSite() {
        return regionOfDangerousSite;
    }

    public String getDateString() {
        return date.get(GregorianCalendar.DAY_OF_MONTH) + "/" + date.get(MONTH) + "/" +date.get(GregorianCalendar.YEAR);
    }
    public void correctDateForDisplay() {
        date.add(MONTH, 1);
    }
}
