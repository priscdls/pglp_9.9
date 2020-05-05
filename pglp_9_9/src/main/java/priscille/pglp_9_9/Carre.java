package priscille.pglp_9_9;

public class Carre extends Forme {
    /**
     * La position du centre.
     */
    private Position centre;
    /**
     * La longueur d'un coté du carré.
     */
    private int longueur;
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
     * Getter de la longueur.
     * @return La longueur
     */
    public int getLongueur() {
        return longueur;
    }
    /**
     * Setter de la longueur.
     * @param l La nouvelle longueur
     */
    public void setLongueur(final int l) {
        this.longueur = l;
    }
    /**
     * Constructeur.
     * @param n Le nom
     * @param p La position initiale
     * @param l La longueur initiale
     */
    protected Carre(final String n, final Position p, final int l) {
        setNom(n);
        this.centre = p.clone();
        this.longueur = l;
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
        System.out.println("Carre(centre=(" + centre.getX()
        + "," + centre.getY() + "),longueur=" + longueur + ")");
    }
}
