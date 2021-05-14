package model;

public class PopulationData {
    Integer totalPopulation;
    Integer impactedPeople;

    public PopulationData(Integer totalPopulation, Integer impactedPeople) {
        this.totalPopulation = totalPopulation;
        this.impactedPeople = impactedPeople;
    }

    public Integer getTotalPopulation() {
        return totalPopulation;
    }

    public Integer getImpactedPeople() {
        return impactedPeople;
    }

    public void setTotalPopulation(Integer totalPopulation) {
        this.totalPopulation = totalPopulation;
    }

    public void setImpactedPeople(Integer impactedPeople) {
        this.impactedPeople = impactedPeople;
    }
}
