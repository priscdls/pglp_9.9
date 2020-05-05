package priscille.pglp_9_9;

import java.util.Scanner;

/**
 * Classe DrawingApp.
 *
 */
public class DrawingApp {
    /**
     * Scanner.
     */
    private Scanner scanner;
    /**
     * DrawingTUI.
     */
    private DrawingTUI dt;
    /**
     * Constructeur.
     */
    public DrawingApp() {
        this.scanner = new Scanner(System.in);
        dt = new DrawingTUI();
    }
    /**
     * Lance l'execution du programme.
     * @param args
     */
    public static void main(final String[] args) {
        DrawingApp da = new DrawingApp();
        da.run();
    }
    /**
     * Execute le programme.
     */
    public void run() {
        System.out.println("Type de commandes valides :\n"
                + "Creation : c1 = Cercle((0, 0), 50)\n"
                + "Déplacement : move(c1, (10, 20))\n"
                + "Affichage : draw(c1, c2)\n"
                + "Affichage du dessin en entier : drawAll\n"
                + "Quitter : exit");
        String command = scanner.nextLine();
        Command c;
        while (!command.equals("exit")) {
            c = dt.nextCommand(command);
            if (c != null) {
                c.execute();
            }
            System.out.println("Entrer une commande");
            command = scanner.nextLine();
        }
    }
}
