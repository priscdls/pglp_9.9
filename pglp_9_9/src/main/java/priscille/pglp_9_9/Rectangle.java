package priscille.pglp_9_9;

public class Rectangle extends Forme {
	
	private Position centre;
	private int longueur;
	private int hauteur;
	
	public Position getCentre() {
		return centre.clone();
	}

	public void setCentre(Position c) {
		this.centre = c.clone();
	}

	public int getLongueur() {
		return longueur;
	}

	public void setLongueur(int l) {
		this.longueur = l;
	}

	public int getHauteur() {
		return hauteur;
	}

	public void setHauteur(int h) {
		this.hauteur = h;
	}
	
	protected Rectangle(final String n, final Position p, final int l, final int h) {
		super.nom = n;
		this.centre = p.clone();
		this.longueur = l;
		this.hauteur = h;
	}
	
	@Override
	public void move(final int x, final int y) {
		centre.move(x, y);
	}

	@Override
	public void draw() {
		System.out.println("Rectangle(centre=(" + centre.getX() + "," + centre.getY() +
				"),longueur=" + longueur + ",hauteur=" + hauteur + ")");
		
	}
}
