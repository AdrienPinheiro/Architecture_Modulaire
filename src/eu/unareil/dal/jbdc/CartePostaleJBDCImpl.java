package eu.unareil.dal.jbdc;

import eu.unareil.bo.CartePostale;
import eu.unareil.dal.DALException;
import eu.unareil.dal.DAO;

import java.sql.*;
import java.util.List;

public class CartePostaleJBDCImpl implements DAO<CartePostale> {
    private static final String SQL_INSERT="INSERT INTO produits (libelle, marque, prixUnitaire, qteStock, typeCartePostale, type) VALUES(?,?,?,?,?,?) FROM produit p JOIN auteur_cartePostale ac ON p.refProd = ac.refCartePostale JOIN auteurs a ON a.id = ac.refAuteur";
    private static final String SQL_UPDATE="UPDATE produits SET libelle=?, marque=?, prixUnitaire=?, qteStock=?, typeCartePostale=? WHERE refProd=?";
    private static final String SQL_DELETE="DELETE FROM produits WHERE refProd=?";
    private static final String SQL_SELECT_BY_ID="SELECT * FROM produits WHERE refProd=?";
    private static final String SQL_SELECT_ALL="SELECT * FROM produits";
    private static final String SQL_TEST="SELECT p.refProd, p.libelle, p.marque, p.prixUnitaire, p.qteStock, p.typeCartePostale, a.id, a.nom, a.prenom FROM produit p JOIN auteur_cartePostale ac ON p.refProd = ac.refCartePostale JOIN auteur a ON a.id = ac.refAuteur";

    @Override
    public void insert(CartePostale data) throws DALException {
        try(Connection cnx = JBDCTools.getConnection(); PreparedStatement pstmt = cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);){
            System.out.println(data.getType().toString());
            pstmt.setString(1, data.getLibelle());
            pstmt.setString(2, data.getMarque());
            pstmt.setFloat(3, data.getPrixUnitaire());
            pstmt.setLong(4,data.getQteStock());
            pstmt.setString(5, data.getType().toString());
            pstmt.setString(6, data.getClass().getSimpleName());
            int nbRow = pstmt.executeUpdate();
            if(nbRow==1){
                ResultSet rs = pstmt.getGeneratedKeys();
                if(rs.next()){
                    data.setRefProd(rs.getLong(1));
                }
            }
        } catch (SQLException e){
            throw new DALException("Erreur lors de la création de la carte postale - id="+data.getRefProd(), e.getCause());
        }
    }

    @Override
    public void delete(CartePostale data) throws DALException {

    }

    @Override
    public void update(CartePostale data) throws DALException {

    }

    @Override
    public CartePostale selectById(long id) throws DALException {
        return null;
    }

    @Override
    public List<CartePostale> selectAll() throws DALException {
        return null;
    }
}
