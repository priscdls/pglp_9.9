package priscille.pglp_9_9;

public class Cercle extends Forme {
	
	private Position centre;
	private int rayon;
	
	public int getRayon() {
		return rayon;
	}

	public void setRayon(int r) {
		this.rayon = r;
	}
	
	public Position getCentre() {
		return centre.clone();
	}

	public void setCentre(Position c) {
		this.centre = c.clone();
	}
	
	protected Cercle(final String n, final Position p, final int r) {
		super.nom = n;
		this.centre = p.clone();
		this.rayon = r;
	}
	
	@Override
	public void move(int x, int y) {
		centre.move(x,y);
	}

	@Override
	public void draw() {
		System.out.println("Cercle(centre=(" + centre.getX() + "," + centre.getY() + "),rayon=" + rayon + ")");
	}

	

}
