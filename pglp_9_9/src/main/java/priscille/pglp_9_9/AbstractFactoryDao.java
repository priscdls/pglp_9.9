package priscille.pglp_9_9;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractFactoryDao {
	/**
     * Enumération des types de Dao.
     */
    public enum DaoType {
        /**
         * CRUD.
         */
        CRUD,
        /**
         * JDBC.
         */
        JDBC;
    }
    public abstract AbstractDao<Cercle> getCercleDao();
    public abstract AbstractDao<Carre> getCarreDao();
    public abstract AbstractDao<Rectangle> getRectangleDao();
    public abstract AbstractDao<Triangle> getTriangleDao();
    public abstract AbstractDao<Groupe> getGroupeDao();
    /**
     * Fabrique général de Dao.
     * @param type Type de Dao
     * @return Une fabrique de Dao
     * @throws SQLException
     */
    public static AbstractFactoryDao getFactory(final DaoType type) throws SQLException {
        Connection connect = DataBase.createBase();
        if (type == DaoType.CRUD) {
            return new FactoryDaoCRUD();
        } else if (type == DaoType.JDBC) {
            return new FactoryDaoJDBC(connect);
        } else {
            return null;
        }
    }
}
