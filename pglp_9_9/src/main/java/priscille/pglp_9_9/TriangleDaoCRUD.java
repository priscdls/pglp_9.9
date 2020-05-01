package priscille.pglp_9_9;

import java.util.ArrayList;

public class TriangleDaoCRUD extends AbstractDao<Triangle> {
    /**
     * Liste de Triangles.
     */
    private ArrayList<Triangle> listTriangle;
    /**
     * Constructeur.
     */
    public TriangleDaoCRUD() {
        this.listTriangle = new ArrayList<Triangle>();
    }
    /**
     * Retourne le Triangle recherché.
     * @param nom Le nom du Triangle
     * @return Le Triangle trouvé
     */
    public Triangle find(final String nom) {
        for (Triangle t : listTriangle) {
            if (t.getNom() == nom) {
                return t;
            }
        }
        return null;
    }
    /**
     * Ajoute un Triangle a la liste.
     * @param t Le Triangle a ajouter
     * @return Le triangle ajouté
     */
    public Triangle create(final Triangle t) {
        if (this.find(t.getNom()) != null) {
            listTriangle.add(t);
            return t;
        }
        return null;
    }
    /**
     * Retire un Triangle de la liste.
     * @param t Le Triangle a retirer
     */
    public void delete(final Triangle t) {
        listTriangle.remove(t);
    }
    /**
     * Modifie un Triangle de la liste.
     * @param nv Le Triangle modifié
     * @return Le tiangle modifié
     */
    public Triangle update(final Triangle nv) {
        Triangle t = this.find(nv.getNom());
        if (t != null) {
            listTriangle.remove(t);
            listTriangle.add(nv);
            return nv;
        }
        return t;
    }
}
