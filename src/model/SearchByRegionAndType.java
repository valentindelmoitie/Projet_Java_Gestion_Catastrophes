package model;

public class SearchByRegionAndType {

    private String regionName;
    private String type;

    public SearchByRegionAndType(String regionName, String type) {
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
