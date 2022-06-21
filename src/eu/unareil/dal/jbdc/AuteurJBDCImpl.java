package eu.unareil.dal.jbdc;

import eu.unareil.bo.Auteur;
import eu.unareil.dal.DALException;
import eu.unareil.dal.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuteurJBDCImpl implements DAO<Auteur> {
    private static final String SQL_INSERT="INSERT INTO auteurs (name, lastname) VALUES(?,?)";
    private static final String SQL_UPDATE="UPDATE auteurs SET name=?, lastname=? WHERE id=?";
    private static final String SQL_DELETE="DELETE FROM auteurs WHERE id=?";
    private static final String SQL_SELECT_BY_ID="SELECT * FROM auteurs WHERE id=?";
    private static final String SQL_SELECT_ALL="SELECT * FROM auteurs";

    @Override
    public void insert(Auteur data) throws DALException {
        try(Connection cnx = JBDCTools.getConnection(); PreparedStatement pstmt = cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)){
            pstmt.setString(1, data.getPrenom());
            pstmt.setString(2, data.getNom());
            int nbRow = pstmt.executeUpdate();
            if(nbRow==1){
                ResultSet rs = pstmt.getGeneratedKeys();
                if(rs.next()){
                    data.setRefAuteur(rs.getLong(1));
                }
            }
        } catch (SQLException e) {
            throw new DALException("Erreur lors de la création d'un auteur", e.getCause());
        }
    }

    @Override
    public void delete(Auteur data) throws DALException {
        long id = data.getRefAuteur();
        try (Connection cnx = JBDCTools.getConnection(); PreparedStatement pstmt = cnx.prepareStatement(SQL_DELETE);){
            pstmt.setLong(1,id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new DALException("Erreur lors de la suppression d'un auteur - id"+id, e.getCause());
        }
    }

    @Override
    public void update(Auteur data) throws DALException {
        long id = data.getRefAuteur();
        try(Connection cnx = JBDCTools.getConnection();PreparedStatement pstmt = cnx.prepareStatement(SQL_UPDATE);){
            pstmt.setString(1, data.getPrenom());
            pstmt.setString(2, data.getNom());
            pstmt.setLong(3, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new DALException("Erreur lors de l'update d'un auteur -id"+id, e.getCause());
        }
    }

    @Override
    public Auteur selectById(long id) throws DALException {
        ResultSet rs;
        try(Connection cnx = JBDCTools.getConnection(); PreparedStatement pstmt = cnx.prepareStatement(SQL_SELECT_BY_ID);){
            pstmt.setLong(1, id);
            rs = pstmt.executeQuery();
            if(rs.next()){
                return new Auteur(rs.getLong(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException e) {
            throw new DALException("Erreur lors de la recherche de l'auteur - id"+id, e.getCause());
        }
        return null;
    }

    @Override
    public List<Auteur> selectAll() throws DALException {
        ResultSet rs;
        List<Auteur> auteurs = new ArrayList<>();
        long id = 0;
        try(Connection cnx = JBDCTools.getConnection(); Statement stmt = cnx.createStatement();){
            rs = stmt.executeQuery(SQL_SELECT_ALL);
            while (rs.next()){
                Auteur auteur = new Auteur(rs.getLong(1), rs.getString(2), rs.getString(3));
                id = auteur.getRefAuteur();
                auteurs.add(auteur);
            }
        } catch (SQLException e){
            throw new DALException("Erreur lors de la récupération de tous les auteurs", e.getCause());
        }
        return auteurs;
    }
}
