package model;

import exception.DisasterMiscException;
import exception.EndDateException;
import exception.StartDateException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static java.util.Calendar.MONTH;

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
    private static final List<String> allowedTypes = List.of("Humanitaire", "Incendie", "Industriel", "Naufrage", "Nucléaire", "Ouragan", "Tremblement de terre", "Tsunami");

    public Disaster(Integer id) throws DisasterMiscException{
        setId(id);
        this.impactedPeople = null;
        this.directCasualties = null;
        this.indirectCasualties = null;
        this.type = null;
        this.description = null;
        this.date = null;
        this.isNatural = null;
        this.regions = null;
    }

    public Disaster(Integer id, Integer impactedPeople, Integer directCasualties, Integer indirectCasualties,
                    String type, String description, GregorianCalendar date, Boolean isNatural) throws DisasterMiscException, EndDateException, StartDateException{
        this(id);
        setDirectCasualties(directCasualties);
        setIndirectCasualties(indirectCasualties);
        setImpactedPeople(impactedPeople);
        setType(type);
        setDescription(description);
        setDate(date);
        this.isNatural = isNatural;
        this.regions = null;
    }

    public Disaster(Integer impactedPeople, Integer directCasualties, Integer indirectCasualties, String type, String description, GregorianCalendar date, Boolean isNatural, ArrayList<Region> regions) throws DisasterMiscException, EndDateException, StartDateException{
        setDirectCasualties(directCasualties);
        setIndirectCasualties(indirectCasualties);
        setImpactedPeople(impactedPeople);
        setType(type);
        setDescription(description);
        setDate(date);
        this.isNatural = isNatural;
        this.regions = regions;
    }

    public Disaster(Integer id, Integer impactedPeople, Integer directCasualties, Integer indirectCasualties,
                    String type, String description, GregorianCalendar date, Boolean isNatural,
                    ArrayList<Region> regions) throws DisasterMiscException, EndDateException, StartDateException{
        this(id,impactedPeople,directCasualties,indirectCasualties,type,description,date,isNatural);
        setRegions(regions);
    }

    public void setId(Integer id) throws DisasterMiscException{
        if(id < 0 ) throw new DisasterMiscException(id);
        this.id = id;
    }

    public void setIntensity(Integer intensity) throws DisasterMiscException{
        if(intensity !=null)
            if(intensity <= 0 || intensity > 7) throw new DisasterMiscException(intensity);
        this.intensity = intensity;
    }

    public void setName(String name){
        if(name != null && name.isBlank()) name = null;
        this.name = name;
    }

    public void setDescription(String description) throws DisasterMiscException{
        if(description.isBlank()) throw new DisasterMiscException(description, "description");
        this.description = description;
    }

    public void setDate(GregorianCalendar date) throws StartDateException{
        Calendar today = new GregorianCalendar();
        if(date.compareTo(today) > 0) throw new StartDateException();
        else
            this.date = date;
    }

    public void setEndDate(GregorianCalendar endDate) throws EndDateException{
        if(endDate != null)
            if(endDate.compareTo(date) < 0) throw new EndDateException();
        this.endDate = endDate;
    }

    public void setImpactedPeople(Integer impactedPeople) throws DisasterMiscException{
        if(impactedPeople < 0) throw new DisasterMiscException(impactedPeople);
        if(impactedPeople < directCasualties + indirectCasualties) throw new DisasterMiscException(impactedPeople,directCasualties + indirectCasualties);
        this.impactedPeople = impactedPeople;
    }

    public void setDirectCasualties(Integer directCasualties) throws DisasterMiscException{
        if(directCasualties < 0) throw new DisasterMiscException(directCasualties);
        this.directCasualties = directCasualties;
    }

    public void setIndirectCasualties(Integer indirectCasualties) throws DisasterMiscException{
        if (indirectCasualties < 0) throw new DisasterMiscException(indirectCasualties);
        this.indirectCasualties = indirectCasualties;
    }

    public void setType(String type) throws DisasterMiscException{
        if (!allowedTypes.contains(type)) throw new DisasterMiscException(type, "type");
        this.type = type;
    }

    public void setRegions(ArrayList<Region> regions) throws DisasterMiscException{
        if(regions.isEmpty()) throw new DisasterMiscException(regions);
            this.regions = regions;
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
        return date.get(GregorianCalendar.DAY_OF_MONTH) + "/" + (date.get(MONTH) + 1) + "/" + date.get(GregorianCalendar.YEAR);
    }

    public String getEndDateString() {
        if (endDate != null)
            return endDate.get(GregorianCalendar.DAY_OF_MONTH) + "/" + (endDate.get(MONTH) + 1) + "/" + endDate.get(GregorianCalendar.YEAR);

        return "";
    }

    public Boolean getNatural() {
        return isNatural;
    }

    public ArrayList<Region> getRegions() {
        return regions;
    }

    public static List<String> getAllowedTypes() { return allowedTypes; }

    public void addRegion(Region region) {
        this.regions.add(region);
    }
}
