package priscille.pglp_9_9;

import java.util.ArrayList;
import java.util.Scanner;

public class DrawingTUI {
	/**
	 * Scanner.
	 */
	private Scanner scanner;
	/**
	 * Constructeur.
	 */
	public DrawingTUI() {
		this.scanner = new Scanner(System.in);
	}
	/**
	 * Lecture d'une commande pour créer un cercle.
	 * @param split La ligne de commande
	 * @return
	 */
	private Forme cercleCommand(String[] split) {
		String[] split2 = split[1].split("Cercle");
		if (!split2[0].equals("")) {
			System.err.println("Commande invalide");
		}
		if (split2[1].startsWith("(") && split2[1].endsWith(")")) {
			split2[1] = split2[1].substring(1, split2[1].length()-1);
			String[] split3 = split2[1].split(",");
			if (split3.length == 3) {
				String position = split3[0].concat(",").concat(split3[1]);
				try {
					Position p = new Position(position);
					int rayon = Integer.parseInt(split3[2]);
					Cercle c = new Cercle(split[0],p,rayon);
					return c;
				} catch (Exception e) {
					System.err.println("Commande invalide");
				}
			} else {
				System.err.println("Commande invalide");
			}
		}else {
			 System.err.println("Commande invalide");
		 }
		return null;
	}
	/**
	 * Lecture d'une commande pour créer un carré.
	 * @param split La ligne de commande
	 * @return
	 */
	private Forme carreCommand(String[] split) {
	    String[] split2 = split[1].split("Carre");
		if (!split2[0].equals("")) {
			 System.err.println("Commande invalide");
		 }
		 if (split2[1].startsWith("(") && split2[1].endsWith(")")) {
			 split2[1] = split2[1].substring(1, split2[1].length()-1);
			 String[] split3 = split2[1].split(",");
			 if (split3.length == 3) {
				 String position = split3[0].concat(",").concat(split3[1]);
				 try {
					Position p = new Position(position);
					int longueur = Integer.parseInt(split3[2]);
					Carre c = new Carre(split[0],p,longueur);
					return c;
				} catch (Exception e) {
					System.err.println("Commande invalide");
				}
			 } else {
				 System.err.println("Commande invalide");
			 }
		 } else {
			 System.err.println("Commande invalide");
		 }
		 return null;
	}
	/**
	 * Lecture d'une commande pour créer un rectangle.
	 * @param split La ligne de commande
	 * @return
	 */
	private Forme rectangleCommand(String[] split) {
	    String[] split2 = split[1].split("Rectangle");
		if (!split2[0].equals("")) {
			 System.err.println("Commande invalide");
		 }
		 if (split2[1].startsWith("(") && split2[1].endsWith(")")) {
			 split2[1] = split2[1].substring(1, split2[1].length()-1);
			 String[] split3 = split2[1].split(",");
			 if (split3.length == 4) {
				 String position = split3[0].concat(",").concat(split3[1]);
				 try {
					Position p = new Position(position);
					int longueur = Integer.parseInt(split3[2]);
					int hauteur = Integer.parseInt(split3[3]);
					Rectangle c = new Rectangle(split[0],p,longueur,hauteur);
					return c;
				} catch (Exception e) {
					System.err.println("Commande invalide");
				}
			 } else {
				 System.err.println("Commande invalide");
			 }
		 } else {
			 System.err.println("Commande invalide");
		 }
		 return null;
	}
	/**
	 * Lecture d'une commande pour créer un triangle.
	 * @param split La ligne de commande
	 * @return
	 */
	private Object triangleCommand(String[] split) {
	    String[] split2 = split[1].split("Triangle");
		if (!split2[0].equals("")) {
			 System.err.println("Commande invalide");
		 }
		 if (split2[1].startsWith("(") && split2[1].endsWith(")")) {
			 split2[1] = split2[1].substring(1, split2[1].length()-1);
			 String[] split3 = split2[1].split(",");
			 if (split3.length == 6) {
				 String position = split3[0].concat(",").concat(split3[1]);
				 String position2 = split3[2].concat(",").concat(split3[3]);
				 String position3 = split3[4].concat(",").concat(split3[5]);
				 try {
					Position p = new Position(position);
					Position p2 = new Position(position2);
					Position p3 = new Position(position3);
					Triangle t = new Triangle(split[0],p,p2,p3);
					return t;
				} catch (Exception e) {
					System.err.println("Commande invalide");
				}
			 } else {
				 System.err.println("Commande invalide");
			 }
		 } else {
			 System.err.println("Commande invalide");
		 }
		 return null;
	}
	/**
	 * Lecture d'une commande pour créer un groupe.
	 * @param split La ligne de commande
	 * @return
	 */
	private Object groupeCommand(String[] split) {
	    String[] split2 = split[1].split("Groupe");
		if (!split2[0].equals("")) {
			 System.err.println("Commande invalide");
		 }
		 if (split2[1].startsWith("(") && split2[1].endsWith(")")) {
			 split2[1] = split2[1].substring(1, split2[1].length()-1);
			 String[] sousGroupe = split2[1].split(",");
			 Groupe g = new Groupe(split[0],sousGroupe);
			 return g;
		 } else {
			 System.err.println("Commande invalide");
		 }
		 return null;
	}
	/**
	 * Lecture d'une commande pour deplacer une forme.
	 * @param command La ligne de commande
	 * @return
	 */
	private Object moveCommand(String command) {
		command.replace(" ","");
		String[] split = command.split("move");
		if (!split[0].equals("")) {
			 System.err.println("Commande invalide");
		}
		if (split[1].startsWith("(") && split[1].endsWith(")")) {
			split[1] = split[1].substring(1, split[1].length()-1);
			String[] split2 = split[1].split(",");
			if (split2.length == 3) {
				String position = split2[1].concat(",").concat(split2[2]);
				try {
					Position p = new Position(position);
					String nom = split2[0];
					return ;
					} catch (Exception e) {
						System.err.println("Commande invalide");
					}
			} else {
				System.err.println("Commande invalide");
			}
		} else {
			System.err.println("Commande invalide");
		}
		return null;
	}
	/**
	 * Lecture d'une commande pour dessiner une forme.
	 * @param command La ligne de commande
	 * @return
	 */
	private Object drawCommand(String command) {
		command.replace(" ","");
		String[] split = command.split("draw");
		if (!split[0].equals("")) {
			 System.err.println("Commande invalide");
		 }
		 if (split[1].startsWith("(") && split[1].endsWith(")")) {
			 split[1] = split[1].substring(1, split[1].length()-1);
			 String[] nom = split[1].split(",");
			 return ;
		 } else {
			 System.err.println("Commande invalide");
		 }
		 return null;
	}
	/**
	 * Lecture d'une commande pour dessiner toutes les formes.
	 * @param command La ligne de commande
	 */
	private void drawAllCommand(String command) {
		command.replace(" ","");
		String[] split = command.split("drawAll");
		if (!split[0].equals("") || !split[1].equals("")) {
			 System.err.println("Commande invalide");
		 } else {
			 FactoryDaoJDBC fdj = new FactoryDaoJDBC(DataBase.createBase());
			 CercleDaoJDBC cercle = (CercleDaoJDBC) fdj.getCercleDao();
			 CarreDaoJDBC carre = (CarreDaoJDBC) fdj.getCarreDao();
			 RectangleDaoJDBC rectangle = (RectangleDaoJDBC) fdj.getRectangleDao();
			 TriangleDaoJDBC triangle = (TriangleDaoJDBC) fdj.getTriangleDao();
			 ArrayList<Forme> f = new ArrayList<Forme>();
			 f.addAll(cercle.findAll());
			 f.addAll(carre.findAll());
			 f.addAll(rectangle.findAll());
			 f.addAll(triangle.findAll());
			 for (Forme f2 : f) {
				 f2.draw();
			 }
		 }
	}
	/**
	 * Lecture d'une commande.
	 * @return
	 */
	public Object nextCommand() {
		String command = scanner.nextLine();
		if (command.contains("=")) {
			String [] split = command.split("=");
			split[0].trim();
			if (split[0].contains(" ")) {
				System.err.println("Nom de variable invalide car contenant des espaces");
				return null;
			} else {
				split[1].replace(" ","");
				if (split[1].contains("Cercle")) {
					return cercleCommand(split);
				} else if (split[1].contains("Carre")) {
					return carreCommand(split);
				} else if (split[1].contains("Rectangle")) {
					return rectangleCommand(split);
				} else if (split[1].contains("Triangle")) {
					return triangleCommand(split);
				} else if (split[1].contains("Groupe")) {
					return groupeCommand(split);
				} else {
					System.err.println("Commande invalide");
				}
			}
		} else if (command.contains("move")) {
			return moveCommand(command);
		} else if (command.contains("draw")) {
			return drawCommand(command);
		}else if (command.contains("drawAll")) {
			drawAllCommand(command);
		} else {
			System.err.println("Commande invalide");
		}
	}
}
