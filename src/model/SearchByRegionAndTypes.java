package model;

public class SearchByRegionAndTypes {

    private String regionName;
    private String type;

    public SearchByRegionAndTypes(String regionName, String type) {
        this.regionName = regionName;
        this.type = type;
    }

    public String getRegionName() {
        return regionName;
    }

    public String getType() {
        return type;
    }
}
