package priscille.pglp_9_9;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CercleTest {
	
	@Test
	public void testConstructeur() {
		Position p1 = new Position(15,20);
		Cercle c = new Cercle("c1", p1, 10);
		assertTrue(c.getNom().equals("c1") && c.getCentre().getX() == p1.getX() 
				&& c.getCentre().getY() == p1.getY() && c.getRayon() == 10);
	}
	
	@Test
	public void testSetter() {
		Position p1 = new Position(15,20);
		Cercle c = new Cercle("c1", p1, 10);
		p1.setX(p1.getX() + 10);
		p1.setY(p1.getY() + 20);
		c.setCentre(p1);
		c.setRayon(20);
		assertTrue(c.getNom().equals("c1") && c.getCentre().getX() == p1.getX() 
				&& c.getCentre().getY() == p1.getY() && c.getRayon() == 20);
	}
	
	@Test
	public void testMove() {
		Position p1 = new Position(15,20);
		Cercle c = new Cercle("c1", p1, 10);
		c.move(10, 20);
		p1.setX(p1.getX() + 10);
		p1.setY(p1.getY() + 20);
		assertTrue(c.getNom().equals("c1") && c.getCentre().getX() == p1.getX() 
				&& c.getCentre().getY() == p1.getY() && c.getRayon() == 10);
	}
	
	@Test
	public void testDraw() {
		Position p1 = new Position(15,20);
		Cercle c = new Cercle("c1", p1, 10);
		c.draw();
	}
}
