package priscille.pglp_9_9;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RectangleDaoJDBC extends AbstractDao<Rectangle> {
    /**
     * Constructeur.
     * @param c Le connecteur
     */
    public RectangleDaoJDBC(final Connection c) {
        this.connect = c;
    }
    /**
     * Ajoute un Rectangle.
     * @param r Le Rectangle a ajouter
     */
    @Override
    public Rectangle create(final Rectangle r) {
        try {
            final int un = 1;
            final int deux = 2;
            final int trois = 3;
            final int quatre = 4;
            final int cinq = 5;
            PreparedStatement prepare = connect.prepareStatement(
                    "INSERT INTO Rectangle (Nom,Centre_X,Centre_Y,"
                    + "Longueur, Hauteur)"
                    + "VALUES (?,?,?,?,?)");
            prepare.setString(un, r.getNom());
            prepare.setInt(deux, r.getCentre().getX());
            prepare.setInt(trois, r.getCentre().getY());
            prepare.setInt(quatre, r.getLongueur());
            prepare.setInt(cinq, r.getHauteur());
            int result = prepare.executeUpdate();
            assert result == un;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return r;
    }
    /**
     * Retourne le Rectangle recherché.
     * @param nom Le nom du Rectangle
     * @return Le Rectangle trouvé
     */
    @Override
    public Rectangle find(final String nom) {
        Rectangle r = null;
        try {
            final int un = 1;
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT * FROM Rectangle WHERE Nom = ?");
            prepare.setString(un, nom);
            ResultSet result = prepare.executeQuery();
            if (result.next()) {
                r = new Rectangle(
                        result.getString("Nom"),
                        new Position(result.getInt("Centre_X"),
                        result.getInt("Centre_Y")),
                        result.getInt("Longueur"),
                        result.getInt("Hauteur")
                        );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return r;
    }
    /**
     * Modifie un Rectangle.
     * @param r Le Rectangle a modifier
     */
    @Override
    public Rectangle update(final Rectangle r) {
        Rectangle r2 = this.find(r.getNom());
        if (r2 != null) {
            try {
                final int un = 1;
                final int deux = 2;
                final int trois = 3;
                final int quatre = 4;
                final int cinq = 5;
                PreparedStatement prepare = connect.prepareStatement(
                        "UPDATE Rectangle SET Nom = ?, Centre_X = ?,"
                        + "Centre_Y = ?, Longueur = ?, Hauteur = ?"
                        + " WHERE Nom = ?");
                prepare.setString(un, r.getNom());
                prepare.setInt(deux, r.getCentre().getX());
                prepare.setInt(trois, r.getCentre().getY());
                prepare.setInt(quatre, r.getLongueur());
                prepare.setInt(cinq, r.getHauteur());
                int result = prepare.executeUpdate();
                assert result == 1;
            } catch (SQLException e) {
                e.printStackTrace();
                return r2;
            }
        } else {
            return r2;
        }
        return r;
    }
    /**
     * Retire un Rectangle.
     * @param r Le Rectangle a retirer
     */
    @Override
    public void delete(final Rectangle r) {
        final int un = 1;
        try {
            GroupeFormeDaoJDBC.deleteGroupeRectangle(connect, r.getNom());
            PreparedStatement prepare = connect.prepareStatement(
                    "DELETE FROM Rectangle WHERE Nom = ?");
            prepare.setString(1, r.getNom());
            int result = prepare.executeUpdate();
            assert result == un;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
