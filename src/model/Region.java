package model;

public class Region {
    private Integer population;
    private String name;
    private Boolean isWarZone;

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

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(Integer population) {
        //if(population < 0) throw new NumberOfPeopleException(population);
        this.population = population;
    }

    public void setWarZone(Boolean warZone) {
        isWarZone = warZone;
    }
}
