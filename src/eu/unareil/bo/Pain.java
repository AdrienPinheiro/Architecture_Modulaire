package eu.unareil.bo;

import java.time.LocalDate;

public class Pain extends ProduitPerissable{

    private int poid;

    public Pain(int poid) {
        this.poid = poid;
    }

    public Pain(String marque, String libelle, long qteStock, float prixUnitaire, LocalDate dateLimiteConso, int poid) {
        super(marque, libelle, qteStock, prixUnitaire, dateLimiteConso);
        this.poid = poid;
    }

    public Pain(long refProd, String libelle, String marque, float prixUnitaire, long qteStock, LocalDate dateLimiteConso, int poid) {
        super(refProd, libelle, marque, prixUnitaire, qteStock, dateLimiteConso);
        this.poid = poid;
    }

    public int getPoid() {
        return poid;
    }

    public void setPoid(int poid) {
        this.poid = poid;
    }
}
