package priscille.pglp_9_9;

public abstract class AbstractDao<T> {
    /**
     * Retourne l'objet recherché.
     * @param nom Le nom de l'objet
     * @return L'objet trouvé
     */
    public abstract T find(String nom);
    /**
     * Ajoute un objet.
     * @param t L'objet a ajouter
     * @return L'objet créé
     */
    public abstract T create(T t);
    /**
     * Modifie un objet.
     * @param t L'objet a modifier
     * @return L'objet modifié
     */
    public abstract T update(T t);
    /**
     * Retire un objet.
     * @param t L'objet a retirer
     */
    public abstract void delete(T t);
}

