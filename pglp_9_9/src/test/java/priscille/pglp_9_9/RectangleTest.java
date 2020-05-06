package priscille.pglp_9_9;

import static org.junit.Assert.*;

import org.junit.Test;

public class RectangleTest {

	@Test
	public void testConstructeur() {
		Position p1 = new Position(15,20);
		Rectangle r = new Rectangle("r1", p1, 10, 5);
		assertTrue(r.getNom().equals("r1") && r.getCentre().getX() == p1.getX() 
				&& r.getCentre().getY() == p1.getY() && r.getLongueur() == 10
				&& r.getHauteur() == 5);
	}
	
	@Test
	public void testSetter() {
		Position p1 = new Position(15,20);
		Rectangle r = new Rectangle("r1", p1, 10, 5);
		p1.setX(p1.getX() + 10);
		p1.setY(p1.getY() + 20);
		r.setCentre(p1);
		r.setLongueur(15);
		r.setHauteur(10);
		assertTrue(r.getNom().equals("r1") && r.getCentre().getX() == p1.getX() 
				&& r.getCentre().getY() == p1.getY() && r.getLongueur() == 15
				&& r.getHauteur() == 10);
	}
	
	@Test
	public void testMove() {
		Position p1 = new Position(15,20);
		Rectangle r = new Rectangle("r1", p1, 10, 5);
		r.move(10, 20);
		p1.setX(p1.getX() + 10);
		p1.setY(p1.getY() + 20);
		assertTrue(r.getNom().equals("r1") && r.getCentre().getX() == p1.getX() 
				&& r.getCentre().getY() == p1.getY() && r.getLongueur() == 10
				&& r.getHauteur() == 5);
	}
	
	@Test
	public void testDraw() {
		Position p1 = new Position(15,20);
		Rectangle r = new Rectangle("r1", p1, 10, 5);
		r.draw();
	}

}
