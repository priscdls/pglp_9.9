package priscille.pglp_9_9;

public class FactoryDaoCRUD extends AbstractFactoryDao {

    public AbstractDao<Cercle> getCercleDao() {
    	return new CercleDaoCRUD();
    }
    public AbstractDao<Carre> getCarreDao() {
    	return new CarreDaoCRUD();
    }
    public AbstractDao<Rectangle> getRectangleDao() {
    	return new RectangleDaoCRUD();
    }
    public AbstractDao<Triangle> getTriangleDao() {
    	return new TriangleDaoCRUD();
    }
    public AbstractDao<Groupe> getGroupeDao() {
    	return new GroupeDaoCRUD();
    }
}
