package eu.unareil.dal.jbdc;

import eu.unareil.bo.Produit;
import eu.unareil.bo.Stylo;
import eu.unareil.dal.DALException;
import eu.unareil.dal.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StyloJBDCImpl implements DAO<Stylo> {
    private static final String SQL_INSERT="INSERT INTO produits (libelle, marque, prixUnitaire, qteStock, couleur, typeMine) VALUES(?,?,?,?,?,?)";
    private static final String SQL_UPDATE="UPDATE produits SET libelle=?, marque=?, prixUnitaire=?, qteStock=?, couleur=?, typeMine=? WHERE refProd=?";
    private static final String SQL_DELETE="DELETE FROM produits WHERE refProd=?";
    private static final String SQL_SELECT_BY_ID="SELECT * FROM produits WHERE refProd=?";
    private static final String SQL_SELECT_ALL="SELECT * FROM produits";

    @Override
    public void insert(Stylo data) throws DALException {

    }

    @Override
    public void delete(Stylo data) throws DALException {

    }

    @Override
    public void update(Stylo data) throws DALException {

    }

    @Override
    public Stylo selectById(long id) throws DALException {
        ResultSet rs;
        try(Connection cnx = JBDCTools.getConnection(); PreparedStatement pstmt = cnx.prepareStatement(SQL_SELECT_BY_ID);){
            pstmt.setLong(1, id);
            rs = pstmt.executeQuery();
            if(rs.next()){
                return new Stylo(rs.getLong(1), rs.getString(2), rs.getString(3),
                        rs.getFloat(4), rs.getLong(5), rs.getString(6),
                        rs.getString(7));
            }
        } catch (SQLException e) {
            throw new DALException("Erreur lors de la récupération du stylo -id"+id, e.getCause());
        }
        return null;
    }

    @Override
    public List<Stylo> selectAll() throws DALException {
        ResultSet rs;
        List<Stylo> stylos = new ArrayList<>();
        long id = 0;
        try(Connection cnx = JBDCTools.getConnection(); Statement stmt = cnx.createStatement();){
            rs = stmt.executeQuery(SQL_SELECT_ALL);
            while (rs.next()){
                if(rs.getString(6).equals("Stylo")){
                    Stylo stl = new Stylo(rs.getLong(1), rs.getString(2), rs.getString(3),
                            rs.getFloat(4), rs.getLong(5), rs.getString(7), rs.getString(8));
                    id = stl.getRefProd();
                    stylos.add(stl);
                }
            }
        } catch (SQLException e) {
            throw new DALException("Erreur lors de la récupération des stylos - id"+id, e.getCause());
        }
        return stylos;
    }
}
