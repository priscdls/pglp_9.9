package priscille.pglp_9_9;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Cercle extends Forme {
    /**
     * Attribut de sérialisation.
     */
    private static final long serialVersionUID = 1L;
    /**
     * La position du centre.
     */
    private Position centre;
    /**
     * Le rayon du cercle.
     */
    private int rayon;
    /**
     * Getter du rayon.
     * @return Le rayon
     */
    public int getRayon() {
        return rayon;
    }
    /**
     * Setter du rayon.
     * @param r Le nouveau rayon
     */
    public void setRayon(final int r) {
        this.rayon = r;
    }
    /**
     * Getter du centre.
     * @return Le centre
     */
    public Position getCentre() {
        return centre.clone();
    }
    /**
     * Setter du centre.
     * @param c La nouvelle Position du centre
     */
    public void setCentre(final Position c) {
        this.centre = c.clone();
    }
    /**
     * Constructeur.
     * @param n
     * @param p
     * @param r
     */
    protected Cercle(final String n, final Position p, final int r) {
        setNom(n);
        this.centre = p.clone();
        this.rayon = r;
    }
    /**
     * Fonction de déplacement.
     * @param x Ajout en abscisse par rapport a la position initiale
     * @param y Ajout en ordonnée par rapport a la position initiale
     */
    @Override
    public void move(final int x, final int y) {
        centre.move(x, y);
    }
    /**
     * Fonction d'affichage.
     */
    @Override
    public void draw() {
        System.out.println("Cercle(centre=(" + centre.getX()
        + "," + centre.getY() + "),rayon=" + rayon + ")");
    }
    /**
     * Fonction de désérialisation.
     * @param path Adresse du fichier
     * @return Le Cercle deserialisé
     * @throws ClassNotFoundException
     */
    public static Cercle deSerialization(final String path)
            throws ClassNotFoundException {
        ObjectInputStream ois = null;
        Cercle c = null;
        try {
            final FileInputStream fichierIn = new FileInputStream(path);
            ois = new ObjectInputStream(fichierIn);
            c = (Cercle) ois.readObject();
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
        return c;
    }
}
