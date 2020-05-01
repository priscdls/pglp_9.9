package priscille.pglp_9_9;

import java.util.ArrayList;

public class RectangleDaoCRUD extends AbstractDao<Rectangle> {
	/**
     * Liste de Rectangles.
     */
    private ArrayList<Rectangle> listRectangle;
    /**
     * Constructeur.
     */
    public RectangleDaoCRUD() {
        this.listRectangle = new ArrayList<Rectangle>();
    }
    /**
     * Retourne le Rectangle recherché.
     * @param nom Le nom du Rectangle
     * @return Le Rectangle trouvé
     */
    public Rectangle find(final String nom) {
        for (Rectangle r : listRectangle) {
            if (r.getNom() == nom) {
                return r;
            }
        }
        return null;
    }
    /**
     * Ajoute un Rectangle a la liste.
     * @param r Le Rectangle a ajouter
     * @return Le rectangle ajouté
     */
    public Rectangle create(final Rectangle r) {
        if(this.find(r.getNom()) != null) {
        	listRectangle.add(r);
        	return r;
        }
        return null;
    }
    /**
     * Retire un Rectangle de la liste.
     * @param r Le Rectangle a retirer
     */
    public void delete(final Rectangle r) {
        listRectangle.remove(r);
    }
    /**
     * Modifie un Rectangle de la liste.
     * @param nv Le Rectangle modifié
     * @return le Rectangle modifié
     */
    public Rectangle update(final Rectangle nv) {
    	Rectangle r = this.find(nv.getNom());
        if (r != null) {
        	listRectangle.remove(r);
            listRectangle.add(nv);
            return nv;
        }
		return r;
    }
}
