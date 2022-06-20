package eu.unareil.bo;

public class Ligne {
    private int quantite;
    private Produit produit;

    public Ligne(int quantite, Produit produit) {
        this.quantite = quantite;
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public String toString() {
        return "Ligne{" +
                "quantite= " + quantite +
                ", produit= " + produit +
                '}';
    }
}
