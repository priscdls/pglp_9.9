package priscille.pglp_9_9;

import java.util.ArrayList;

public class CarreDaoCRUD extends AbstractDao<Carre> {
    /**
     * Liste de Carres.
     */
    private ArrayList<Carre> listCarre;
    /**
     * Constructeur.
     */
    public CarreDaoCRUD() {
        this.listCarre = new ArrayList<Carre>();
    }
    /**
     * Retourne le Carre recherché.
     * @param nom Le nom du Carre
     * @return Le Carre trouvé
     */
    public Carre find(final String nom) {
        for (Carre c : listCarre) {
            if (c.getNom() == nom) {
                return c;
            }
        }
        return null;
    }
    /**
     * Ajoute un Carre a la liste.
     * @param c Le Carre a ajouter
     * @return Le Carre ajouté
     */
    public Carre create(final Carre c) {
        if (this.find(c.getNom()) != null) {
            listCarre.add(c);
            return c;
        }
        return null;
    }
    /**
     * Retire un Carre de la liste.
     * @param c Le Carre a retirer
     */
    public void delete(final Carre c) {
        listCarre.remove(c);
    }
    /**
     * Modifie un Carre de la liste.
     * @param nv Le Carre modifié
     * @return Le Carre modifié
     */
    public Carre update(final Carre nv) {
        Carre carre = this.find(nv.getNom());
        if (carre != null) {
            listCarre.remove(carre);
            listCarre.add(nv);
            return nv;
        }
        return carre;
    }
}
