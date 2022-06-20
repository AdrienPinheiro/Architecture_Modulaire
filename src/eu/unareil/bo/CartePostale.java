package eu.unareil.bo;

import java.util.List;

public class CartePostale extends Produit{
    private TypeCartePostale TypeCartePostale;
    private List<Auteur> auteurs;

    public CartePostale(TypeCartePostale type, List<Auteur> auteurs){
        this.TypeCartePostale = type;
        this.auteurs = auteurs;
    }

    public CartePostale(String marque, String libelle, long qteStock, float prixUnitaire, List<Auteur> auteurs, TypeCartePostale type) {
        super(marque, libelle, qteStock, prixUnitaire);
        this.TypeCartePostale = type;
        this.auteurs = auteurs;
    }

    public CartePostale(long refProd, String libelle, String marque, float prixUnitaire, long qteStock, List<Auteur> auteurs, TypeCartePostale type) {
        super(refProd, libelle, marque, prixUnitaire, qteStock);
        this.TypeCartePostale = type;
        this.auteurs = auteurs;
    }

    public TypeCartePostale getType() {
        return TypeCartePostale;
    }

    public void setType(TypeCartePostale type) {
        this.TypeCartePostale = type;
    }

    public List<Auteur> getAuteur() {
        return auteurs;
    }

    public void setAuteur(List<Auteur> auteurs) {
        this.auteurs = auteurs;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(super.toString()).append(", TypeCartePostale=").append(TypeCartePostale);
        for (Auteur auteur: auteurs) {
            sb.append(", auteur(s)=").append(" auteur").append((auteurs.indexOf(auteur))+1).append("= ");
            sb.append(auteur.getNom()).append(" ").append(auteur.getPrenom()).append(", type=").append(getType());
        }
        sb.append(']');
        return sb.toString();
        };
    }
