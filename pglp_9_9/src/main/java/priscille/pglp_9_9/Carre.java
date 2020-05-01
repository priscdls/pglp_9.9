package priscille.pglp_9_9;

public class Carre extends Forme {

	private Position centre;
	private int longueur;
	
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
	
	protected Carre(final String n, final Position p, final int l) {
		super.nom = n;
		this.centre = p.clone();
		this.longueur = l;
	}
	
	@Override
	public void move(final int x, final int y) {
		centre.move(x, y);
	}

	@Override
	public void draw() {
		System.out.println("Carre(centre=(" + centre.getX() + "," + centre.getY() + "),longueur=" + longueur + ")");
	}

}
