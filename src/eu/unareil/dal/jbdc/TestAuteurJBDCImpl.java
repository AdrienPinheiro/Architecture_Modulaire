package eu.unareil.dal.jbdc;

import eu.unareil.bo.Auteur;
import eu.unareil.dal.DALException;

import java.util.List;

public class TestAuteurJBDCImpl {
    public static void main(String[] args) {
        AuteurJBDCImpl auteurJbdc = new AuteurJBDCImpl();
        try{
            Auteur pierre = new Auteur("Pierre", "Tremblay");
            auteurJbdc.insert(pierre);
        } catch (DALException e) {
            e.printStackTrace();
        }
    }
}
