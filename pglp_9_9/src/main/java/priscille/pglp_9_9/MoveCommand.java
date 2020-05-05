package priscille.pglp_9_9;

import java.sql.SQLException;

public class MoveCommand implements Command {
	/**
	 * Forme a deplacer.
	 */
	Forme form;
	/**
	 * Vecteur de déplacement en abscisse.
	 */
	int vecteur_X;
	/**
	 * Vecteur de déplacement en ordonnée.
	 */
	int vecteur_Y;
	/**
	 * Constructeur.
	 * @param f La forme a deplacer
	 */
	public MoveCommand(Forme f, int x, int y) {
		this.form = f;
		this.vecteur_X = x;
		this.vecteur_Y = y;
	}
	/**
	 * Execute la commande de déplacement.
	 * @throws SQLException 
	 */
	public void execute() {
		form.move(vecteur_X, vecteur_X);
		FactoryDaoJDBC fdj = new FactoryDaoJDBC(DataBase.createBase());
		if (form.getClass() == Cercle.class) {
			CercleDaoJDBC cercle = (CercleDaoJDBC) fdj.getCercleDao();
			cercle.update((Cercle) form);
		} else if (form.getClass() == Carre.class) {
			CarreDaoJDBC carre = (CarreDaoJDBC) fdj.getCarreDao();
			carre.update((Carre) form);
		} else if (form.getClass() == Rectangle.class) {
			RectangleDaoJDBC rectangle = (RectangleDaoJDBC) fdj.getRectangleDao();
			rectangle.update((Rectangle) form);
		} else if (form.getClass() == Triangle.class) {
			TriangleDaoJDBC triangle = (TriangleDaoJDBC) fdj.getTriangleDao();
			triangle.update((Triangle) form);
		} else if (form.getClass() == Groupe.class) {
			GroupeDaoJDBC groupe = (GroupeDaoJDBC) fdj.getGroupeDao();
			groupe.update((Groupe) form);
		}
	}
}
