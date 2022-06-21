package eu.unareil.dal.jbdc;

import eu.unareil.bo.Stylo;
import eu.unareil.dal.DALException;

import java.util.List;

public class TestStyloJBDCImpl {
    public static void main(String[] args) {
        StyloJBDCImpl styloJBDC = new StyloJBDCImpl();
        try{
            List<Stylo> styloList = styloJBDC.selectAll();
            if(styloList!=null){
                for(Stylo stylo: styloList){
                    System.out.println(stylo);
                }
            }
        } catch (DALException e) {
            e.printStackTrace();
        }
    }
}
