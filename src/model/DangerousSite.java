package model;

public class DangerousSite {
    private int id;
    private String type;
    private String description;
    private String manager;
    private String region;

    public DangerousSite(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
