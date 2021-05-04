package model;

import java.util.GregorianCalendar;

public class Region {
    private Integer population;
    private String name;
    private Boolean isWarZone;

    public Region(Integer population, String name, Boolean isWarZone) {
        this.population = population;
        this.name = name;
        this.isWarZone = isWarZone;
    }

    public Region(String name) {
        this(null, name, null);
    }
}
