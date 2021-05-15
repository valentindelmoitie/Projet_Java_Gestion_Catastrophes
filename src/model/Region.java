package model;

public class Region {
    private Integer population;
    private String name;
    private Boolean isWarZone;
    private Country country;

    public Region(Integer population, String name, Boolean isWarZone) {
        setPopulation(population);
        setName(name);
        setWarZone(isWarZone);
    }

    public Region(String name) {
        this(null, name, null);
    }

    public String getName() {
        return name;
    }

    public Integer getPopulation() {
        return population;
    }

    public Boolean getWarZone() {
        return isWarZone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setWarZone(Boolean warZone) {
        isWarZone = warZone;
    }

    public Country getCountry() {
        return country;
    }
}
