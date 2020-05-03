package priscille.pglp_9_9;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarreDaoJDBC extends AbstractDao<Carre> {
	/**
     * Connecteur.
     */
    protected Connection connect;
    /**
     * Constructeur.
     * @param c Le connecteur
     */
    public CarreDaoJDBC(final Connection c) {
        this.connect = c;
    }
    /**
     * Ajoute un Carre.
     * @param c Le Carre a ajouter
     */
    @Override
    public Carre create(final Carre c) {
        try {
            final int un = 1;
            final int deux = 2;
            final int trois = 3;
            final int quatre = 4;
            PreparedStatement prepare = connect.prepareStatement(
                    "INSERT INTO Carre (Nom,Centre_X,Centre_Y,"
                    + "Longueur)"
                    + "VALUES (?,?,?,?)");
            prepare.setString(un, c.getNom());
            prepare.setInt(deux, c.getCentre().getX());
            prepare.setInt(trois, c.getCentre().getY());
            prepare.setInt(quatre, c.getLongueur());
            int result = prepare.executeUpdate();
            assert result == un;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return c;
    }
    /**
     * Retourne le Carre recherché.
     * @param nom Le nom du Carre
     * @return Le Carre trouvé
     */
    @Override
    public Carre find(final String nom) {
    	Carre c = null;
        try {
            final int un = 1;
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT * FROM Carre WHERE Nom = ?");
            prepare.setString(un, nom);
            ResultSet result = prepare.executeQuery();
            if (result.next()) {
                c = new Carre(
                        result.getString("Nom"),
                        new Position(result.getInt("Centre_X"),
                        result.getInt("Centre_Y")),
                        result.getInt("Longueur")
                        );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return c;
    }
    /**
     * Modifie un Carre.
     * @param c Le Carre a modifier
     */
    @Override
    public Carre update(final Carre c) {
    	Carre c2 = this.find(c.getNom());
        if (c2 != null) {
            try {
                final int un = 1;
                final int deux = 2;
                final int trois = 3;
                final int quatre = 4;
                PreparedStatement prepare = connect.prepareStatement(
                        "UPDATE Carre SET Nom = ?, Centre_X = ?,"
                        + "Centre_Y = ?, Longueur = ? WHERE Nom = ?");
                prepare.setString(un, c.getNom());
                prepare.setInt(deux, c.getCentre().getX());
                prepare.setInt(trois, c.getCentre().getY());
                prepare.setInt(quatre, c.getLongueur());
                int result = prepare.executeUpdate();
                assert result == 1;
            } catch (SQLException e) {
                e.printStackTrace();
                return c2;
            }
        } else {
            return c2;
        }
        return c;
    }
    /**
     * Retire un Carre.
     * @param c Le Carre a retirer
     */
    @Override
    public void delete(final Carre c) {
        final int un = 1;
        try {
        	GroupeFormeDaoJDBC.deleteGroupeCarre(connect, c.getNom());
            PreparedStatement prepare = connect.prepareStatement(
                    "DELETE FROM Carre WHERE Nom = ?");
            prepare.setString(1, c.getNom());
            int result = prepare.executeUpdate();
            assert result == un;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
