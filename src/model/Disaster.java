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

    public Disaster(int id, int impacted_people, int direct_casualties, int indirect_casualties, String type, String description, GregorianCalendar date, boolean is_natural, ArrayList<Region> regions) {
    }

    public String getName() {
        return name;
    }

    public Integer getIntensity() {
        return intensity;
    }
}
