package priscille.pglp_9_9;

import java.sql.SQLException;
import java.util.ArrayList;

public class DrawCommand implements Command {
	/**
	 * Liste de formes a afficher.
	 */
	ArrayList<Forme> form;
	/**
	 * Constructeur.
	 * @param f La liste de formes à afficher
	 */
	public DrawCommand(ArrayList<Forme> f) {
		this.form = f;
	}
	/**
	 * Execute la commande d'affichage.
	 * @throws SQLException 
	 */
	public void execute() {
		for (Forme f : form) {
			f.draw();
		}
	}
}
