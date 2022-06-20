package eu.unareil.bo;

import java.time.LocalDate;

public class Glace extends ProduitPerissable{
    private String parfum;
    private int temperatureConservation;

    public Glace(String parfum, int temperatureConservation){
        this.parfum = parfum;
        this.temperatureConservation = temperatureConservation;
    }

    public Glace(String marque, String libelle, long qteStock, float prixUnitaire, LocalDate dateLimiteConso, String parfum, int temperatureConservation) {
        super(marque, libelle, qteStock, prixUnitaire, dateLimiteConso);
        this.parfum = parfum;
        this.temperatureConservation = temperatureConservation;
    }

    public Glace(long refProd, String libelle, String marque, float prixUnitaire, long qteStock, LocalDate dateLimiteConso, String parfum, int temperatureConservation) {
        super(refProd, libelle, marque, prixUnitaire, qteStock, dateLimiteConso);
        this.parfum = parfum;
        this.temperatureConservation = temperatureConservation;
    }

    public String getParfum() {
        return parfum;
    }

    public void setParfum(String parfum) {
        this.parfum = parfum;
    }

    public int getTemperatureConservation() {
        return temperatureConservation;
    }

    public void setTemperatureConservation(int temperatureConservation) {
        this.temperatureConservation = temperatureConservation;
    }
}
