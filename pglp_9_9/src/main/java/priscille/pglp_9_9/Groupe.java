package priscille.pglp_9_9;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Pattern Composite Groupe
 */
public class Groupe extends Forme implements Iterable<Forme> {
	/**
     * Liste des formes d'un même composite.
     */
    private ArrayList<Forme> list =
            new ArrayList<Forme>();
    /**
     * Constructeur.
     */
    public Groupe(final String n) {
        super.nom  = n;
        list = new ArrayList<Forme>();
    }
    /**
     * Fonction qui ajoute une forme a la liste.
     * @param f La forme a ajouter
     */
    public void add(final Forme f) {
        list.add(f);
    }
    /**
     * Fonction qui enlève une forme a la liste.
     * @param f La forme a enlever
     */
    public void remove(final Forme f) {
        list.remove(f);
    }
    /**
     * Fonction qui crée un Itérateur
     * de la liste des formes du Composite.
     * @return L'iterateur
     */
    public Iterator<Forme> iterator() {
        return list.iterator();
    }
    
	@Override
	public void move(int x, int y) {
		for (Forme f : list) {
            f.move(x,y);
        }
	}

	@Override
	public void draw() {
		System.out.println("Groupe(");
        for (Forme f : list) {
            f.draw();
        }
        System.out.println(")");
	}
}
