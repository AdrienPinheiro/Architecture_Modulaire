package eu.unareil.bo;

public class CartePostale extends Produit{
    private String type;
    private Auteur auteur;

    public CartePostale(String type, Auteur auteur){
        this.type = type;
        this.auteur = auteur;
    }

    public CartePostale(String marque, String libelle, long qteStock, float prixUnitaire, String type, Auteur auteur) {
        super(marque, libelle, qteStock, prixUnitaire);
        this.type = type;
        this.auteur = auteur;
    }

    public CartePostale(long refProd, String libelle, String marque, float prixUnitaire, long qteStock, String type, Auteur auteur) {
        super(refProd, libelle, marque, prixUnitaire, qteStock);
        this.type = type;
        this.auteur = auteur;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }
}
