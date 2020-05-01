package priscille.pglp_9_9;

public class Rectangle extends Forme {
	/**
	 * La position du centre.
	 */
	private Position centre;
	/**
	 * La longueur.
	 */
	private int longueur;
	/**
	 * La hauteur.
	 */
	private int hauteur;
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
	 * Getter de la hauteur.
	 * @return La hauteur
	 */
	public int getHauteur() {
		return hauteur;
	}
	/**
	 * Setter de la hauteur.
	 * @param h La nouvelle hauteur
	 */
	public void setHauteur(final int h) {
		this.hauteur = h;
	}
	/**
	 * Constructeur.
	 * @param n Le nom
	 * @param p La position initiale
	 * @param l La longueur initiale
	 * @param h La hauteur initiale
	 */
	protected Rectangle(final String n, final Position p, final int l,
			final int h) {
		setNom(n);
		this.centre = p.clone();
		this.longueur = l;
		this.hauteur = h;
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
		System.out.println("Rectangle(centre=(" + centre.getX()
		+ "," + centre.getY() + "),longueur=" + longueur
		+ ",hauteur=" + hauteur + ")");
	}
}
