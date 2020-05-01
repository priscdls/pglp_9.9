package priscille.pglp_9_9;

public class Triangle extends Forme {

	private Position haut;
	private Position gauche;
	private Position droite;
	
	public Position getHaut() {
		return haut.clone();
	}

	public void setHaut(Position h) {
		this.haut = h.clone();
	}

	public Position getGauche() {
		return gauche.clone();
	}

	public void setGauche(Position g) {
		this.gauche = g.clone();
	}

	public Position getDroite() {
		return droite.clone();
	}

	public void setDroite(Position d) {
		this.droite = d.clone();
	}
	
	protected Triangle(final String n, final Position p1, final Position p2, final Position p3) {
		super.nom = n;
		this.haut = p1.clone();
		this.gauche = p2.clone();
		this.droite = p3.clone();
	}
	@Override
	public void move(final int x, final int y) {
		haut.move(x, y);
		gauche.move(x, y);
		droite.move(x, y);
	}

	@Override
	public void draw() {
		System.out.println("Triangle(sommet1=(" + haut.getX() + "," + haut.getY() +
				"),sommet2=(" + gauche.getX() + "," + gauche.getY() +
				"),sommet3=(" + droite.getX() + "," + droite.getY() + "))");
	}

}
