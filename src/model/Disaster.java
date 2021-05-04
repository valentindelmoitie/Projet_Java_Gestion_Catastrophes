package model;

import java.util.ArrayList;
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

    public Disaster(Integer id, Integer intensity, Integer impactedPeople, Integer directCasualties, Integer indirectCasualties, String name, String type, String description, GregorianCalendar date, GregorianCalendar endDate, Boolean isNatural, ArrayList<Region> regions) {
        this.id = id;
        this.intensity = intensity;
        this.impactedPeople = impactedPeople;
        this.directCasualties = directCasualties;
        this.indirectCasualties = indirectCasualties;
        this.name = name;
        this.type = type;
        this.description = description;
        this.date = date;
        this.endDate = endDate;
        this.isNatural = isNatural;
        this.regions = regions;
    }

    public Disaster(Integer id, Integer impactedPeople, Integer directCasualties, Integer indirectCasualties, String type, String description, GregorianCalendar date, Boolean isNatural, ArrayList<Region> regions) {

    }
}
