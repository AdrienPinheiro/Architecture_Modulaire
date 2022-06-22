package eu.unareil.dal.jbdc;

import eu.unareil.bo.Auteur;
import eu.unareil.bo.CartePostale;
import eu.unareil.bo.TypeCartePostale;
import eu.unareil.dal.DALException;

import java.util.List;

public class TestCartePostaleJBDCImpl {

    public static void main(String[] args) {
        CartePostaleJBDCImpl cartePostaleJBDC = new CartePostaleJBDCImpl();
        AuteurJBDCImpl auteurJbdc = new AuteurJBDCImpl();
        try{
            System.out.println("--------------------------------------");
            System.out.println("Création d'une carte postale : Ville rose");
            System.out.println("--------------------------------------");
            List<Auteur> auteurs = auteurJbdc.selectAll();
            CartePostale newCartePostale = new CartePostale("toulouse", "Ville rose", 10250, 2.5f, auteurs , TypeCartePostale.Paysage);
            cartePostaleJBDC.insert(newCartePostale);
        } catch (DALException e) {
            e.printStackTrace();
        }
    }
}
