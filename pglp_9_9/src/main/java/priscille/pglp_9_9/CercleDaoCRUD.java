package priscille.pglp_9_9;

import java.util.ArrayList;

public class CercleDaoCRUD extends AbstractDao<Cercle> {
	/**
     * Liste de cercles.
     */
    private ArrayList<Cercle> listCercle;
    /**
     * Constructeur.
     */
    public CercleDaoCRUD() {
        this.listCercle = new ArrayList<Cercle>();
    }
    /**
     * Retourne le cercle recherché.
     * @param nom Le nom du cercle
     * @return Le cercle trouvé
     */
    public Cercle find(final String nom) {
        for (Cercle c : listCercle) {
            if (c.getNom() == nom) {
                return c;
            }
        }
        return null;
    }
    /**
     * Ajoute un cercle a la liste.
     * @param c Le cercle a ajouter
     * @return Le cercle ajouté
     */
    public Cercle create(final Cercle c) {
        if(this.find(c.getNom()) != null) {
        	listCercle.add(c);
        	return c;
        }
        return null;
    }
    /**
     * Retire un cercle de la liste.
     * @param c Le cercle a retirer
     */
    public void delete(final Cercle c) {
        listCercle.remove(c);
    }
    /**
     * Modifie un cercle de la liste.
     * @param nv Le cercle modifié
     * @return Le cercle modifié
     */
    public Cercle update(final Cercle nv) {
        Cercle cercle = this.find(nv.getNom());
        if (cercle != null) {
        	listCercle.remove(cercle);
            listCercle.add(nv);
            return nv;
        }
		return cercle;
    }
}
