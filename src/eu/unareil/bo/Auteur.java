package eu.unareil.bo;

public class Auteur {
    private String prenom;
    private String nom;

    private long refAuteur;
    public Auteur(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }

    public Auteur(long refAuteur, String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
        this.refAuteur = refAuteur;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public long getRefAuteur() {
        return refAuteur;
    }

    public void setRefAuteur(long refAuteur) {
        this.refAuteur = refAuteur;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Auteur{");
        sb.append("prenom='").append(prenom).append('\'');
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", refAuteur=").append(refAuteur);
        sb.append('}');
        return sb.toString();
    }
}
