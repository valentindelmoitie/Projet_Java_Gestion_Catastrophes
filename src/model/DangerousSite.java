package model;

public class DangerousSite {
    private Integer id;
    private String type;
    private String description;
    private String manager;
    private String region;

    public DangerousSite(Integer id, String type, String description, String manager, String region) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.manager = manager;
        this.region = region;
    }

    public DangerousSite(Integer id, String type, String region) {
        this(id,type, null, null, region);
    }

    public DangerousSite(Integer id) {
        this(id, null, null);
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
