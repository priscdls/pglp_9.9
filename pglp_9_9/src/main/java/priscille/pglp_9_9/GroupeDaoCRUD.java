package priscille.pglp_9_9;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class GroupeDaoCRUD extends AbstractDao<Groupe> implements Serializable {
	/**
	 * Attribut de sérialisation.
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Liste de Groupes.
     */
    private ArrayList<Groupe> listGroupe;
    /**
     * Constructeur.
     */
    public GroupeDaoCRUD() {
        this.listGroupe = new ArrayList<Groupe>();
    }
    /**
     * Retourne le Groupe recherché.
     * @param nom Le nom du Groupe
     * @return Le Groupe trouvé
     */
    public Groupe find(final String nom) {
        for (Groupe g : listGroupe) {
            if (g.getNom() == nom) {
                return g;
            }
        }
        return null;
    }
    /**
     * Ajoute un Groupe a la liste.
     * @param g Le Groupe a ajouter
     * @return Le Groupe ajouté
     */
    public Groupe create(final Groupe g) {
        if (this.find(g.getNom()) != null) {
            listGroupe.add(g);
            return g;
        }
        return null;
    }
    /**
     * Retire un Groupe de la liste.
     * @param g Le Groupe a retirer
     */
    public void delete(final Groupe g) {
        listGroupe.remove(g);
    }
    /**
     * Modifie un Groupe de la liste.
     * @param nv Le Groupe modifié
     * @return Le Groupe modifié
     */
    public Groupe update(final Groupe nv) {
        Groupe g = this.find(nv.getNom());
        if (g != null) {
            listGroupe.remove(g);
            listGroupe.add(nv);
            return nv;
        }
        return g;
    }
    /**
     * Fonction de désérialisation.
     * @param path Adresse du fichier
     * @return Le GroupeDaoCRUD deserialisé
     * @throws ClassNotFoundException
     */
    public static GroupeDaoCRUD deSerialization(final String path)
            throws ClassNotFoundException {
        ObjectInputStream ois = null;
        GroupeDaoCRUD g = null;
        try {
            final FileInputStream fichierIn = new FileInputStream(path);
            ois = new ObjectInputStream(fichierIn);
            g = (GroupeDaoCRUD) ois.readObject();
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
