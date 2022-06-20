package eu.unareil.bo;

import java.util.ArrayList;
import java.util.List;

public class Achat{

    private double montant;
    private List<Ligne> lignes = new ArrayList<>();
    private Ligne ligne;

    public Achat(double montant, List<Ligne> lignes, Ligne ligne) {
        this.montant = montant;
        this.lignes = lignes;
        this.ligne = ligne;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public List<Ligne> getLignes() {
        return lignes;
    }

    public void setLignes(List<Ligne> lignes) {
        this.lignes = lignes;
    }

    public Ligne getLigne() {
        return ligne;
    }

    public void ajouteLigne(Ligne ligne) {
        this.ligne = ligne;
    }

    public void mofifieLigne(int index, int nouvelleQte){
        for(int i = 0; i<getLignes().size(); i++){
            if(i == index){
                getLignes().get(index).setQuantite(nouvelleQte);
            }
        }
    }

    public void supprimeLigne(int index){
        for(int i = 0; i<getLignes().size(); i++){
            if(i == index){
                getLignes().remove(index);
            }
        }
    }

    public double calculMontant(){
        for(Ligne ligne : lignes){
            montant += ligne.getProduit().getPrixUnitaire() * ligne.getQuantite();
        }
        return montant;
    }

    @Override
    public String toString() {
        return "Achat{" +
                "montant= " + montant +
                ", lignes= " + lignes +
                ", ligne= " + ligne +
                '}';
    }
}
