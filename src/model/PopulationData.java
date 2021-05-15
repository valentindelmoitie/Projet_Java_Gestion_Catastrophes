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
}
