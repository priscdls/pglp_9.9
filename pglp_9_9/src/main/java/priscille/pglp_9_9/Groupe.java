package priscille.pglp_9_9;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Pattern Composite Groupe.
 */
public class Groupe extends Forme implements Iterable<Forme> {
    /**
     * Attribut de sérialisation.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Liste des formes d'un même composite.
     */
    private ArrayList<Forme> list =
            new ArrayList<Forme>();
    /**
     * Constructeur.
     * @param n Le nom du groupe
     */
    public Groupe(final String n) {
        setNom(n);
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
    /**
     * Fonction de déplacement.
     * @param x Ajout en abscisse par rapport a la position initiale
     * @param y Ajout en ordonnée par rapport a la position initiale
     */
    @Override
    public void move(final int x, final  int y) {
        for (Forme f : list) {
            f.move(x, y);
        }
    }
    /**
     * Fonction d'affichage.
     */
    @Override
    public void draw() {
        System.out.println("Groupe(");
        for (Forme f : list) {
            f.draw();
        }
        System.out.println(")");
    }
    /**
     * Fonction de désérialisation.
     * @param path Adresse du fichier
     * @return Le Groupe deserialisé
     * @throws ClassNotFoundException
     */
    public static Groupe deSerialization(final String path)
            throws ClassNotFoundException {
        ObjectInputStream ois = null;
        Groupe g = null;
        try {
            final FileInputStream fichierIn = new FileInputStream(path);
            ois = new ObjectInputStream(fichierIn);
            g = (Groupe) ois.readObject();
        } catch (final java.io.IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (final java.io.IOException ex) {
                ex.printStackTrace();
            }
        }
        return g;
    }
}
