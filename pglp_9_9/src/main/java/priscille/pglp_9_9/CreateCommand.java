package priscille.pglp_9_9;

import java.sql.Connection;
import java.sql.SQLException;

public class CreateCommand implements Command {
    /**
     * Forme a créer.
     */
    private Forme form;
    /**
     * Constructeur.
     * @param f La forme a créer
     */
    public CreateCommand(final Forme f) {
        this.form = f;
    }
    /**
     * Execute la commande de création.
     */
    public void execute() {
        Connection c = DataBase.createBase();
        FactoryDaoJDBC fdj = new FactoryDaoJDBC(c);
        if (form.getClass() == Cercle.class) {
            CercleDaoJDBC cercle = (CercleDaoJDBC)
                    fdj.getCercleDao();
            cercle.create((Cercle) form);
        } else if (form.getClass() == Carre.class) {
            CarreDaoJDBC carre = (CarreDaoJDBC) fdj.getCarreDao();
            carre.create((Carre) form);
        } else if (form.getClass() == Rectangle.class) {
            RectangleDaoJDBC rectangle = (RectangleDaoJDBC)
                    fdj.getRectangleDao();
            rectangle.create((Rectangle) form);
        } else if (form.getClass() == Triangle.class) {
            TriangleDaoJDBC triangle = (TriangleDaoJDBC)
                    fdj.getTriangleDao();
            triangle.create((Triangle) form);
        } else if (form.getClass() == Groupe.class) {
            GroupeDaoJDBC groupe = (GroupeDaoJDBC)
                    fdj.getGroupeDao();
            groupe.create((Groupe) form);
        }
        try {
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
