package priscille.pglp_9_9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DataBase {
    /**
     * Création de la base de données.
     * @return Le connecteur a la base
     * @throws SQLException
     */
    public static Connection createBase() {
        try {
			return DriverManager.getConnection(
			        "jdbc:derby:DataForme;create=true");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }
    /**
     * Supprime toutes les tables de la base de données.
     * @param connect Le connecteur a la base
     * @throws SQLException
     */
    public static void deleteAllTables(final Connection connect)
            throws SQLException {
        Statement s = null;
        s = connect.createStatement();
        try {
            s.execute("DROP TABLE GroupeCercle");
        } catch (SQLException e) {
        }
        try {
            s.execute("DROP TABLE GroupeCarre");
        } catch (SQLException e) {
        }
        try {
            s.execute("DROP TABLE GroupeTriangle");
        } catch (SQLException e) {
        }
        try {
            s.execute("DROP TABLE GroupeRectangle");
        } catch (SQLException e) {
        }
        try {
            s.execute("DROP TABLE GroupeGroupe");
        } catch (SQLException e) {
        }
        try {
            s.execute("DROP TABLE Cercle");
        } catch (SQLException e) {
        }
        try {
            s.execute("DROP TABLE Carre");
        } catch (SQLException e) {
        }
        try {
            s.execute("DROP TABLE Triangle");
        } catch (SQLException e) {
        }
        try {
            s.execute("DROP TABLE Rectangle");
        } catch (SQLException e) {
        }
        try {
            s.execute("DROP TABLE Groupe");
        } catch (SQLException e) {
        }
    }
    /**
     * Création de toutes les tables de la base de données.
     * @param connect Le connecteur a la base
     * @throws SQLException
     */
    public static void createAllTables(final Connection connect)
            throws SQLException {
        String cercle = "CREATE TABLE Cercle ("
                + "Nom varchar(30),"
                + "Centre_X int,"
                + "Centre_Y int,"
                + "Rayon int,"
                + "PRIMARY KEY (Nom)"
                + ")";
        String carre = "CREATE TABLE Carre ("
                + "Nom varchar(30),"
                + "Centre_X int,"
                + "Centre_Y int,"
                + "Longueur int,"
                + "PRIMARY KEY (Nom)"
                + ")";
        String rectangle = "CREATE TABLE Rectangle ("
                + "Nom varchar(30),"
                + "Centre_X int,"
                + "Centre_Y int,"
                + "Longueur int,"
                + "Hauteur int,"
                + "PRIMARY KEY (Nom)"
                + ")";
        String triangle = "CREATE TABLE Triangle ("
                + "Nom varchar(30),"
                + "Sommet1_X int,"
                + "Sommet1_Y int,"
                + "Sommet2_X int,"
                + "Sommet2_Y int,"
                + "Sommet3_X int,"
                + "Sommet3_Y int,"
                + "PRIMARY KEY (Nom)"
                + ")";
        String groupe = "CREATE TABLE Groupe ("
                + "Nom varchar(30),"
                + "PRIMARY KEY (Nom)"
                + ")";
        String groupeCercle = "CREATE TABLE GroupeCercle ("
                + "NomGroupe varchar(30),"
                + "NomCercle varchar(30),"
                + "PRIMARY KEY (NomGroupe, NomCercle)"
                + "FOREIGN KEY (NomGroupe) REFERENCES Groupe (Nom)"
                + "FOREIGN KEY (NomCercle) REFERENCES Cercle (Nom)"
                + ")";
        String groupeCarre = "CREATE TABLE GroupeCarre ("
                + "NomGroupe varchar(30),"
                + "NomCarre varchar(30),"
                + "PRIMARY KEY (NomGroupe, NomCarre)"
                + "FOREIGN KEY (NomGroupe) REFERENCES Groupe (Nom)"
                + "FOREIGN KEY (NomCarre) REFERENCES Carre (Nom)"
                + ")";
        String groupeRectangle = "CREATE TABLE GroupeRectangle ("
                + "NomGroupe varchar(30),"
                + "NomRectangle varchar(30),"
                + "PRIMARY KEY (NomGroupe, NomRectangle)"
                + "FOREIGN KEY (NomGroupe) REFERENCES Groupe (Nom)"
                + "FOREIGN KEY (NomRectangle) REFERENCES Rectangle(Nom)"
                + ")";
        String groupeTriangle = "CREATE TABLE GroupeTriangle ("
                + "NomGroupe varchar(30),"
                + "NomTriangle varchar(30),"
                + "PRIMARY KEY (NomGroupe, NomTriangle)"
                + "FOREIGN KEY (NomGroupe) REFERENCES Groupe (Nom)"
                + "FOREIGN KEY (NomTriangle) REFERENCES Triangle (Nom)"
                + ")";
        String groupeGroupe = "CREATE TABLE GroupeGroupe ("
                + "NomGroupe varchar(30),"
                + "NomGroupe2 varchar(30),"
                + "PRIMARY KEY (NomGroupe, NomGroupe2)"
                + "FOREIGN KEY (NomGroupe) REFERENCES Groupe (Nom)"
                + "FOREIGN KEY (NomGroupe2) REFERENCES Groupe (Nom)"
                + ")";
        Statement s = connect.createStatement();
        s.execute(cercle);
        s.execute(carre);
        s.execute(rectangle);
        s.execute(triangle);
        s.execute(groupe);
        s.execute(groupeCercle);
        s.execute(groupeCarre);
        s.execute(groupeRectangle);
        s.execute(groupeTriangle);
        s.execute(groupeGroupe);
    }
}
