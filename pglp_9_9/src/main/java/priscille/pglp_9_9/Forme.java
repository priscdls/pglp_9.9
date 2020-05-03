package priscille.pglp_9_9;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public abstract class Forme implements Serializable {
    /**
     * Attribut de sérialisation.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Le nom de la forme.
     */
    private String nom;
    /**
     * Getter de nom.
     * @return Le nom de la forme
     */
    public String getNom() {
        return nom;
    }
    /**
     * Setter de nom.
     * @param n Le nouveau nom
     */
    public void setNom(final String n) {
        this.nom = n;
    }
    /**
     * Fonction de déplacement.
     * @param x Ajout en abscisse par rapport a la position initiale
     * @param y Ajout en ordonnée par rapport a la position initiale
     */
    public abstract void move(int x, int y);
    /**
     * Fonction d'affichage.
     */
    public abstract void draw();
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
}
