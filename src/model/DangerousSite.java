package model;

public class DangerousSite {
    private Integer id;
    private String type;
    private String description;
    private String manager;
    private String region;

    public DangerousSite(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getRegion() {
        return region;
    }
}
