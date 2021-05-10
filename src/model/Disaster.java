package model;

import java.util.*;

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
    private static final List<String> allowedTypes = Collections.unmodifiableList(Arrays.asList("Humanitaire",
            "Incendie","Industriel", "Naufrage","Nucléaire","Ouragan","Tremblement de terre", "Tsunami"));
    //Si on déclarait la variable en final simplement, on pourrait toujours y ajouter/retirer du contenu, juste
    // ne pas la réassigner via un allowedTypes = new List<String>();

    public Disaster(Integer id, Integer impactedPeople, Integer directCasualties, Integer indirectCasualties,
                    String type, String description, GregorianCalendar date, Boolean isNatural,
                    ArrayList<Region> regions) { // Le dernier argument est peut-être à retirer.
        setId(id);
        setImpactedPeople(impactedPeople);
        setDirectCasualties(directCasualties);
        setIndirectCasualties(indirectCasualties);
        setType(type);
        this.description = description;
        this.date = date;
        this.isNatural = isNatural;
        this.regions = regions;
    }

    public Disaster(Integer id){  //On peut l'utiliser pour les suppressions, plus simple que de tout récupérer.
        this(id,null,null, null, null,null,
                null, null, null);
    }

    public void setId(Integer id) {
        //if(id < 1 ) throw new IdException;
        this.id = id;
    }

    public void setIntensity(Integer intensity) {
        //if(intensity <= 0 || intensity > 7) throw new IntensityException;
        this.intensity = intensity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEndDate(GregorianCalendar endDate) {
        //if(endDate.compareTo(date) < 0) throws new EndDateException(endDate,date)
        this.endDate = endDate;
    }

    public void setImpactedPeople(Integer impactedPeople) {
        //if(impactedPeople < 0) throw new NumberOfPeopleException(population);
        //if(impactedPeople < directCasualties + indirectCasualties) throw new ImpactedPeopleException(impactedPeople,directCasualties,indirectCasualties);
        this.impactedPeople = impactedPeople;
    }

    public void setDirectCasualties(Integer directCasualties) {
        //if(directCasualties < 0) throw new NumberOfPeopleException(directCasualties);
        this.directCasualties = directCasualties;
    }

    public void setIndirectCasualties(Integer indirectCasualties) {
        //if (indirectCasualties < 0) throw new NumberOfPeopleException(indirectCasualties);
        this.indirectCasualties = indirectCasualties;
    }

    public void setType(String type) {
        //if (!allowedTypes.contains(type)) throw new DisasterTypeException;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIntensity() {
        return intensity;
    }

    public Integer getImpactedPeople() {
        return impactedPeople;
    }

    public Integer getDirectCasualties() {
        return directCasualties;
    }

    public Integer getIndirectCasualties() {
        return indirectCasualties;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public GregorianCalendar getDate(){
        return date;
    }

    public GregorianCalendar getEndDate(){
        return endDate;
    }

    public String getDateString() {
        return date.get(GregorianCalendar.DAY_OF_MONTH) + "/" + date.get(GregorianCalendar.MONTH) + "/" +date.get(GregorianCalendar.YEAR);
    }

    public String getEndDateString() {
        if (endDate != null)
            return endDate.get(GregorianCalendar.DAY_OF_MONTH) + "/" + endDate.get(GregorianCalendar.MONTH) + "/" + endDate.get(GregorianCalendar.YEAR);

        return "";
    }

    public Boolean getNatural() {
        return isNatural;
    }

    public ArrayList<Region> getRegions() {
        return regions;
    }

    public void addRegion(Region region) {
        this.regions.add(region);
    }

}
