package priscille.pglp_9_9;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class CercleDaoCRUD extends AbstractDao<Cercle> implements Serializable {
	/**
	 * Attribut de sérialisation.
	 */
	private static final long serialVersionUID = 1L;
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
        if (this.find(c.getNom()) != null) {
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
    /**
     * Fonction de désérialisation.
     * @param path Adresse du fichier
     * @return Le CercleDaoCRUD deserialisé
     * @throws ClassNotFoundException
     */
    public static CercleDaoCRUD deSerialization(final String path)
            throws ClassNotFoundException {
        ObjectInputStream ois = null;
        CercleDaoCRUD c = null;
        try {
            final FileInputStream fichierIn = new FileInputStream(path);
            ois = new ObjectInputStream(fichierIn);
            c = (CercleDaoCRUD) ois.readObject();
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
        return c;
    }
}
