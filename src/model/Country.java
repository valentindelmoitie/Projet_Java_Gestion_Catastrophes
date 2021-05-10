package model;

public class Country {
    private String name;
    private boolean isUnderDeveloped;
    private boolean isInWar;

    public Country(String name, boolean isUnderDeveloped, boolean isInWar) {
        this.name = name;
        this.isUnderDeveloped = isUnderDeveloped;
        this.isInWar = isInWar;
    }

    public String getName() {
        return name;
    }
}
