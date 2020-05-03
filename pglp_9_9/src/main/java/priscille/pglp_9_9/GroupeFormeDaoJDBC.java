package priscille.pglp_9_9;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe pour les associations.
 */
public abstract class GroupeFormeDaoJDBC {
    /**
     * Crée l'association GroupeCercle entre un Groupe et un Cercle.
     * @param c Le connecteur a la bd
     * @param nom Le nom du groupe
     * @param nom2 Le nom du cercle
     */
    public static void createGroupeCercle(final Connection c,
            final String nom, final String nom2) {
        try {
            final int un = 1;
            final int deux = 2;
            PreparedStatement prepare = c.prepareStatement(
                    "INSERT INTO GroupeCercle (NomGroupe, NomCercle)"
                    + "VALUES (?,?)");
            prepare.setString(un, nom);
            prepare.setString(deux, nom2);
            int result = prepare.executeUpdate();
            assert result == un;
        } catch (SQLException e) {
        }
    }
    /**
     * Crée l'association GroupeCarre entre un Groupe et un Carre.
     * @param c Le connecteur a la bd
     * @param nom Le nom du groupe
     * @param nom2 Le nom du Carre
     */
    public static void createGroupeCarre(final Connection c,
            final String nom, final String nom2) {
        try {
            final int un = 1;
            final int deux = 2;
            PreparedStatement prepare = c.prepareStatement(
                    "INSERT INTO GroupeCarre (NomGroupe, NomCarre)"
                    + "VALUES (?,?)");
            prepare.setString(un, nom);
            prepare.setString(deux, nom2);
            int result = prepare.executeUpdate();
            assert result == un;
        } catch (SQLException e) {
        }
    }
    /**
     * Crée l'association GroupeRectangle entre un Groupe et un Rectangle.
     * @param c Le connecteur a la bd
     * @param nom Le nom du groupe
     * @param nom2 Le nom du Rectangle
     */
    public static void createGroupeRectangle(final Connection c,
            final String nom, final String nom2) {
        try {
            final int un = 1;
            final int deux = 2;
            PreparedStatement prepare = c.prepareStatement(
                    "INSERT INTO GroupeRectangle (NomGroupe, NomRectangle)"
                    + "VALUES (?,?)");
            prepare.setString(un, nom);
            prepare.setString(deux, nom2);
            int result = prepare.executeUpdate();
            assert result == un;
        } catch (SQLException e) {
        }
    }
    /**
     * Crée l'association GroupeTriangle entre un Groupe et un Triangle.
     * @param c Le connecteur a la bd
     * @param nom Le nom du groupe
     * @param nom2 Le nom du Triangle
     */
    public static void createGroupeTriangle(final Connection c,
            final String nom, final String nom2) {
        try {
            final int un = 1;
            final int deux = 2;
            PreparedStatement prepare = c.prepareStatement(
                    "INSERT INTO GroupeTriangle (NomGroupe, NomTriangle)"
                    + "VALUES (?,?)");
            prepare.setString(un, nom);
            prepare.setString(deux, nom2);
            int result = prepare.executeUpdate();
            assert result == un;
        } catch (SQLException e) {
        }
    }
    /**
     * Crée l'association GroupeGroupe entre 2 Groupes.
     * @param c Le connecteur a la bd
     * @param nom Le nom du groupe qui contient le second
     * @param nom2 Le nom du groupe qui est contenu
     */
    public static void createGroupeGroupe(final Connection c,
            final String nom, final String nom2) {
        try {
            final int un = 1;
            final int deux = 2;
            PreparedStatement prepare = c.prepareStatement(
                    "INSERT INTO GroupeGroupe (NomGroupe, NomGroupe)"
                    + "VALUES (?,?)");
            prepare.setString(un, nom);
            prepare.setString(deux, nom2);
            int result = prepare.executeUpdate();
            assert result == un;
        } catch (SQLException e) {
        }
    }
    /**
     * Supprime les associations d'un cercle vers des groupes.
     * @param c Le connecteur
     * @param nom Le nom du cercle
     */
    public static void deleteCercleGroupe(final Connection c,
            final String nom) {
        final int un = 1;
        try {
            PreparedStatement prepare = c.prepareStatement(
                    "DELETE FROM GroupeCercle WHERE NomCercle = ?");
            prepare.setString(1, nom);
            int result = prepare.executeUpdate();
            assert result == un;
        } catch (SQLException e) {
        }
    }
    /**
     * Supprime les associations d'un groupe vers des Cercles.
     * @param c Le connecteur
     * @param nom Le nom du groupe
     */
    public static void deleteGroupeCercle(final Connection c,
            final String nom) {
        final int un = 1;
        try {
            PreparedStatement prepare = c.prepareStatement(
                    "DELETE FROM GroupeCercle WHERE NomGroupe = ?");
            prepare.setString(1, nom);
            int result = prepare.executeUpdate();
            assert result == un;
        } catch (SQLException e) {
        }
    }
    /**
     * Supprime les associations d'un carre vers des groupes.
     * @param c Le connecteur
     * @param nom Le nom du carre
     */
    public static void deleteCarreGroupe(final Connection c,
            final String nom) {
        final int un = 1;
        try {
            PreparedStatement prepare = c.prepareStatement(
                    "DELETE FROM GroupeCarre WHERE NomCarre = ?");
            prepare.setString(1, nom);
            int result = prepare.executeUpdate();
            assert result == un;
        } catch (SQLException e) {
        }
    }
    /**
     * Supprime les associations d'un groupe vers des Carres.
     * @param c Le connecteur
     * @param nom Le nom du groupe
     */
    public static void deleteGroupeCarre(final Connection c,
            final String nom) {
        final int un = 1;
        try {
            PreparedStatement prepare = c.prepareStatement(
                    "DELETE FROM GroupeCarre WHERE NomGroupe = ?");
            prepare.setString(1, nom);
            int result = prepare.executeUpdate();
            assert result == un;
        } catch (SQLException e) {
        }
    }
    /**
     * Supprime les associations d'un rectangle vers des groupes.
     * @param c Le connecteur
     * @param nom Le nom du rectangle
     */
    public static void deleteRectangleGroupe(final Connection c,
            final String nom) {
        final int un = 1;
        try {
            PreparedStatement prepare = c.prepareStatement(
                    "DELETE FROM GroupeRectangle WHERE NomRectangle = ?");
            prepare.setString(1, nom);
            int result = prepare.executeUpdate();
            assert result == un;
        } catch (SQLException e) {
        }
    }
    /**
     * Supprime les associations d'un groupe vers des Rectangles.
     * @param c Le connecteur
     * @param nom Le nom du groupe
     */
    public static void deleteGroupeRectangle(final Connection c,
            final String nom) {
        final int un = 1;
        try {
            PreparedStatement prepare = c.prepareStatement(
                    "DELETE FROM GroupeRectangle WHERE NomGroupe = ?");
            prepare.setString(1, nom);
            int result = prepare.executeUpdate();
            assert result == un;
        } catch (SQLException e) {
        }
    }
    /**
     * Supprime les associations d'un triangle vers des groupes.
     * @param c Le connecteur
     * @param nom Le nom du triangle
     */
    public static void deleteTriangleGroupe(final Connection c,
            final String nom) {
        final int un = 1;
        try {
            PreparedStatement prepare = c.prepareStatement(
                    "DELETE FROM GroupeTriangle WHERE NomTriangle = ?");
            prepare.setString(1, nom);
            int result = prepare.executeUpdate();
            assert result == un;
        } catch (SQLException e) {
        }
    }
    /**
     * Supprime les associations d'un groupe vers des Triangles.
     * @param c Le connecteur
     * @param nom Le nom du groupe
     */
    public static void deleteGroupeTriangle(final Connection c,
            final String nom) {
        final int un = 1;
        try {
            PreparedStatement prepare = c.prepareStatement(
                    "DELETE FROM GroupeTriangle WHERE NomGroupe = ?");
            prepare.setString(1, nom);
            int result = prepare.executeUpdate();
            assert result == un;
        } catch (SQLException e) {
        }
    }
    /**
     * Supprime les associations d'un groupe "contenu" vers des groupes.
     * @param c Le connecteur
     * @param nom Le nom du groupe "contenu"
     */
    public static void deleteGroupe2Groupe(final Connection c,
            final String nom) {
        final int un = 1;
        try {
            PreparedStatement prepare = c.prepareStatement(
                    "DELETE FROM GroupeGroupe WHERE NomGroupe2 = ?");
            prepare.setString(1, nom);
            int result = prepare.executeUpdate();
            assert result == un;
        } catch (SQLException e) {
        }
    }
    /**
     * Supprime les associations d'un groupe "contenant"
     * vers d'autres groupes.
     * @param c Le connecteur
     * @param nom Le nom du groupe "contenant"
     */
    public static void deleteGroupeGroupe2(final Connection c,
            final String nom) {
        final int un = 1;
        try {
            PreparedStatement prepare = c.prepareStatement(
                    "DELETE FROM GroupeGroupe WHERE NomGroupe = ?");
            prepare.setString(1, nom);
            int result = prepare.executeUpdate();
            assert result == un;
        } catch (SQLException e) {
        }
    }
    /**
     * Supprime les associations de tous types de formes d'un groupe.
     * @param c Le connecteur
     * @param nom Le nom du groupe
     */
    public static void deleteAllGroupeForme(final Connection c,
            final String nom) {
        deleteGroupeCercle(c, nom);
        deleteGroupeCarre(c, nom);
        deleteGroupeRectangle(c, nom);
        deleteGroupeTriangle(c, nom);
        deleteGroupeGroupe2(c, nom);
    }
    /**
     * Cherche tous les GroupeCercle d'un même groupe.
     * @param connect Le connecteur
     * @param nom Le nom du groupe
     * @return La liste des Cercles
     */
    public static ArrayList<Forme> findGroupeCercle(
            final Connection connect, final String nom) {
        ArrayList<Forme> f = new ArrayList<Forme>();
        try {
            final int un = 1;
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT NomCercle FROM GroupeCercle WHERE NomGroupe = ?");
            prepare.setString(un, nom);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                FactoryDaoJDBC fdj = new FactoryDaoJDBC(connect);
                CercleDaoJDBC cdj = (CercleDaoJDBC) fdj.getCercleDao();
                Cercle c = cdj.find(result.getString("NomCercle"));
                f.add(c);
            }
        } catch (SQLException e) {
            return new ArrayList<Forme>();
        }
        return f;
    }
    /**
     * Cherche tous les GroupeCarre d'un même groupe.
     * @param connect Le connecteur
     * @param nom Le nom du groupe
     * @return La liste des Carres
     */
    public static ArrayList<Forme> findGroupeCarre(final Connection connect,
            final String nom) {
        ArrayList<Forme> f = new ArrayList<Forme>();
        try {
            final int un = 1;
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT NomCarre FROM GroupeCarre WHERE NomGroupe = ?");
            prepare.setString(un, nom);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                FactoryDaoJDBC fdj = new FactoryDaoJDBC(connect);
                CarreDaoJDBC cdj = (CarreDaoJDBC) fdj.getCarreDao();
                Carre c = cdj.find(result.getString("NomCarre"));
                f.add(c);
            }
        } catch (SQLException e) {
            return new ArrayList<Forme>();
        }
        return f;
    }
    /**
     * Cherche tous les GroupeRectangle d'un même groupe.
     * @param connect Le connecteur
     * @param nom Le nom du groupe
     * @return La liste des rectangles
     */
    public static ArrayList<Forme> findGroupeRectangle(
            final Connection connect, final String nom) {
        ArrayList<Forme> f = new ArrayList<Forme>();
        try {
            final int un = 1;
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT NomRectangle FROM GroupeRectangle "
                    + "WHERE NomGroupe = ?");
            prepare.setString(un, nom);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                FactoryDaoJDBC fdj = new FactoryDaoJDBC(connect);
                RectangleDaoJDBC rdj = (RectangleDaoJDBC) fdj.getRectangleDao();
                Rectangle rect = rdj.find(result.getString("NomRectangle"));
                f.add(rect);
            }
        } catch (SQLException e) {
            return new ArrayList<Forme>();
        }
        return f;
    }
    /**
     * Cherche tous les GroupeTriangle d'un même groupe.
     * @param connect Le connecteur
     * @param nom Le nom du groupe
     * @return La liste des Triangles
     */
    public static ArrayList<Forme> findGroupeTriangle(
            final Connection connect, final String nom) {
        ArrayList<Forme> f = new ArrayList<Forme>();
        try {
            final int un = 1;
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT NomTriangle FROM GroupeTriangle "
                    + "WHERE NomGroupe = ?");
            prepare.setString(un, nom);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                FactoryDaoJDBC fdj = new FactoryDaoJDBC(connect);
                TriangleDaoJDBC tdj = (TriangleDaoJDBC) fdj.getTriangleDao();
                Triangle t = tdj.find(result.getString("NomTriangle"));
                f.add(t);
            }
        } catch (SQLException e) {
            return new ArrayList<Forme>();
        }
        return f;
    }
    /**
     * Cherche tous les GroupeGroupe d'un même groupe.
     * @param connect Le connecteur
     * @param nom Le nom du groupe
     * @return La liste des Groupes
     */
    public static ArrayList<Forme> findGroupeGroupe(
            final Connection connect, final String nom) {
        ArrayList<Forme> f = new ArrayList<Forme>();
        try {
            final int un = 1;
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT NomGroupe2 FROM GroupeGroupe WHERE NomGroupe = ?");
            prepare.setString(un, nom);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                FactoryDaoJDBC fdj = new FactoryDaoJDBC(connect);
                GroupeDaoJDBC gdj = (GroupeDaoJDBC) fdj.getGroupeDao();
                Groupe g = gdj.find(result.getString("NomGroupe"));
                f.add(g);
            }
        } catch (SQLException e) {
            return new ArrayList<Forme>();
        }
        return f;
    }
    /**
     * Cherche toutes les associations de tous types d'un même groupe.
     * @param c Le connecteur
     * @param nom Le nom du groupe
     * @return La listes de toutes les formes
     */
    public static ArrayList<Forme> findAllGroupeForme(final Connection c,
            final String nom) {
        ArrayList<Forme> all = new ArrayList<Forme>();
        ArrayList<Forme> cercle = findGroupeCercle(c, nom);
        ArrayList<Forme> carre = findGroupeCarre(c, nom);
        ArrayList<Forme> rect = findGroupeRectangle(c, nom);
        ArrayList<Forme> triangle = findGroupeTriangle(c, nom);
        ArrayList<Forme> groupe = findGroupeGroupe(c, nom);
        all.addAll(cercle);
        all.addAll(carre);
        all.addAll(rect);
        all.addAll(triangle);
        all.addAll(groupe);
        return all;
    }
}
