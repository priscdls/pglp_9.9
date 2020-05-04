package priscille.pglp_9_9;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TriangleDaoJDBC extends AbstractDao<Triangle> {
    /**
     * Constructeur.
     * @param c Le connecteur
     */
    public TriangleDaoJDBC(final Connection c) {
        this.connect = c;
    }
    /**
     * Ajoute un Triangle.
     * @param t Le Triangle a ajouter
     */
    @Override
    public Triangle create(final Triangle t) {
        try {
            final int un = 1;
            final int deux = 2;
            final int trois = 3;
            final int quatre = 4;
            final int cinq = 5;
            final int six = 6;
            final int sept = 7;
            PreparedStatement prepare = connect.prepareStatement(
                    "INSERT INTO Carre (Nom,Sommet1_X,Sommet1_Y,"
                    + "Sommet2_X,Sommet2_Y,Sommet3_X,Sommet3_Y)"
                    + "VALUES (?,?,?,?,?,?,?)");
            prepare.setString(un, t.getNom());
            prepare.setInt(deux, t.getHaut().getX());
            prepare.setInt(trois, t.getHaut().getY());
            prepare.setInt(quatre, t.getGauche().getX());
            prepare.setInt(cinq, t.getGauche().getY());
            prepare.setInt(six, t.getDroite().getX());
            prepare.setInt(sept, t.getDroite().getY());
            int result = prepare.executeUpdate();
            assert result == un;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return t;
    }
    /**
     * Retourne le Triangle recherché.
     * @param nom Le nom du Triangle
     * @return Le Triangle trouvé
     */
    @Override
    public Triangle find(final String nom) {
        Triangle t = null;
        try {
            final int un = 1;
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT * FROM Triangle WHERE Nom = ?");
            prepare.setString(un, nom);
            ResultSet result = prepare.executeQuery();
            if (result.next()) {
                t = new Triangle(
                        result.getString("Nom"),
                        new Position(result.getInt("Sommet1_X"),
                        result.getInt("Sommet1_Y")),
                        new Position(result.getInt("Sommet2_X"),
                        result.getInt("Sommet2_Y")),
                        new Position(result.getInt("Sommet3_X"),
                        result.getInt("Sommet3_Y"))
                        );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return t;
    }
    /**
     * Retourne tous les Triangles.
     * @return Les Triangles trouvés
     */
    @Override
    public ArrayList<Triangle> findAll() {
    	ArrayList<Triangle> t = new ArrayList<Triangle>();
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT Nom FROM Triangle");
            ResultSet result = prepare.executeQuery();
            if (result.next()) {
                t.add(find(result.getString("Nom")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<Triangle>();
        }
        return t;
    }
    /**
     * Modifie un Triangle.
     * @param t Le Triangle a modifier
     */
    @Override
    public Triangle update(final Triangle t) {
        Triangle t2 = this.find(t.getNom());
        if (t2 != null) {
            try {
                final int un = 1;
                final int deux = 2;
                final int trois = 3;
                final int quatre = 4;
                final int cinq = 5;
                final int six = 6;
                final int sept = 7;
                PreparedStatement prepare = connect.prepareStatement(
                        "UPDATE Carre SET Nom = ?, Sommet1_X = ?,"
                        + "Sommet1_Y = ?, Sommet2_X = ?, Sommet2_Y = ?,"
                        + "Sommet3_X = ?, Sommet3_Y = ? WHERE Nom = ?");
                prepare.setString(un, t.getNom());
                prepare.setInt(deux, t.getHaut().getX());
                prepare.setInt(trois, t.getHaut().getY());
                prepare.setInt(quatre, t.getGauche().getX());
                prepare.setInt(cinq, t.getGauche().getY());
                prepare.setInt(six, t.getDroite().getX());
                prepare.setInt(sept, t.getDroite().getY());
                int result = prepare.executeUpdate();
                assert result == 1;
            } catch (SQLException e) {
                e.printStackTrace();
                return t2;
            }
        } else {
            return t2;
        }
        return t;
    }
    /**
     * Retire un Triangle.
     * @param t Le Triangle a retirer
     */
    @Override
    public void delete(final Triangle t) {
        final int un = 1;
        try {
            GroupeFormeDaoJDBC.deleteGroupeTriangle(connect, t.getNom());
            PreparedStatement prepare = connect.prepareStatement(
                    "DELETE FROM Triangle WHERE Nom = ?");
            prepare.setString(1, t.getNom());
            int result = prepare.executeUpdate();
            assert result == un;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
