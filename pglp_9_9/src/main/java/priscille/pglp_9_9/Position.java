package priscille.pglp_9_9;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Position {
    /**
     * Valeur en abscisse.
     */
    private int x;
    /**
     * Valeur en ordonnée.
     */
    private int y;
    /**
     * Getter de x.
     * @return La position en x
     */
    public int getX() {
        return x;
    }
    /**
     * Getter de y.
     * @return La position en y
     */
    public int getY() {
        return y;
    }
    /**
     * Setter de x.
     * @param a La nouvelle valeur de x
     */
    public void setX(final int a) {
        this.x = a;
    }
    /**
     * Setter de y.
     * @param a La nouvelle valeur de y
     */
    public void setY(final int a) {
        this.y = a;
    }
    /**
     * Constructeur par défaut.
     */
    public Position() {
        x = 0;
        y = 0;
    }
    /**
     * Constructeur.
     * @param absc Valeur en abscisse de la position
     * @param ord Valeur en ordonnée de la position
     */
    public Position(final int absc, final int ord) {
        this.x = absc;
        this.y = ord;
    }
    /**
     * Fonction de déplacement d'une position.
     * @param abs Ajout en abscisse par rapport a la position initiale
     * @param ord Ajout en ordonnée par rapport a la position initiale
     */
    public void move(final int abs, final int ord) {
        this.x += abs;
        this.y += ord;
    }
    /**
     * Clone la position.
     * @return La position clonée
     */
    public Position clone() {
        return new Position(this.x, this.y);
    }
    /**
     * Fonction de sérialisation.
     * @param path Adresse du fichier
     */
    public void serialization(final String path) {
        ObjectOutputStream oos = null;
        try {
            final FileOutputStream fichierOut = new FileOutputStream(path);
            oos = new ObjectOutputStream(fichierOut);
            oos.writeObject(this);
            oos.flush();
            oos.close();
        } catch (final java.io.IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.flush();
                    oos.close();
                }
            } catch (final java.io.IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    /**
     * Fonction de désérialisation.
     * @param path Adresse du fichier
     * @return Le Position deserialisé
     * @throws ClassNotFoundException
     */
    public static Position deSerialization(final String path)
            throws ClassNotFoundException {
        ObjectInputStream ois = null;
        Position p = null;
        try {
            final FileInputStream fichierIn = new FileInputStream(path);
            ois = new ObjectInputStream(fichierIn);
            p = (Position) ois.readObject();
        } catch (final java.io.IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (final java.io.IOException ex) {
                ex.printStackTrace();
            }
        }
        return p;
    }
}
