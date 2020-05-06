package priscille.pglp_9_9;

import static org.junit.Assert.*;

import org.junit.Test;

public class GroupeTest {

	@Test
	public void testConstructeur() {
		Groupe g = new Groupe("g1");
		assertTrue(g.getNom().equals("g1") && g.iterator().hasNext() == false);
	}
	
	@Test
	public void testAdd() {
		Position p1 = new Position(15,20);
		Cercle c = new Cercle("c1", p1, 10);
		Groupe g = new Groupe("g1");
		g.add(c);
		assertTrue(g.getNom().equals("g1") && g.iterator().next().equals(c));
	}
	
	@Test
	public void testRemove() {
		Position p1 = new Position(15,20);
		Cercle c = new Cercle("c1", p1, 10);
		Groupe g = new Groupe("g1");
		g.add(c);
		g.remove(c);
		assertTrue(g.getNom().equals("g1") && g.iterator().hasNext() == false);
	}
	
	@Test
	public void testMove() {
		Position p1 = new Position(15,20);
		Cercle c = new Cercle("c1", p1, 10);
		Groupe g = new Groupe("g1");
		g.add(c);
		g.move(10, 20);
		p1.setX(p1.getX() + 10);
		p1.setY(p1.getY() + 20);
		assertTrue(g.getNom().equals("g1") && c.getCentre().getX() == p1.getX() 
				&& c.getCentre().getY() == p1.getY() && c.getRayon() == 10);
	}
	
	@Test
	public void testDraw() {
		Position p1 = new Position(15,20);
		Cercle c = new Cercle("c1", p1, 10);
		Groupe g = new Groupe("g1");
		g.add(c);
		g.draw();
	}
}
