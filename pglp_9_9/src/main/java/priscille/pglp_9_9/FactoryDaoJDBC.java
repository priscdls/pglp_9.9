package priscille.pglp_9_9;

import java.sql.Connection;

public class FactoryDaoJDBC extends AbstractFactoryDao {
	/**
     * Connecteur.
     */
    protected Connection connect;
    /**
     * Constructeur.
     */
    public FactoryDaoJDBC(Connection c) {
    	this.connect = c;
    }
    
	public AbstractDao<Cercle> getCercleDao() {
    	return new CercleDaoJDBC(connect);
    }
    public AbstractDao<Carre> getCarreDao() {
    	return new CarreDaoJDBC(connect);
    }
    public AbstractDao<Rectangle> getRectangleDao() {
    	return new RectangleDaoJDBC(connect);
    }
    public AbstractDao<Triangle> getTriangleDao() {
    	return new TriangleDaoJDBC(connect);
    }
    public AbstractDao<Groupe> getGroupeDao() {
    	return new GroupeDaoJDBC(connect);
    }
}
