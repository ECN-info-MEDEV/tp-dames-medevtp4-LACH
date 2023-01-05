package org.centrale.dames;

import java.util.Scanner;

public class Main {
    static Scanner sc;
    static Plateau plateau;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        plateau = new Plateau();
        tourDeJeu(false);
        sc.close();
    }

    public static void tourDeJeu(boolean b) {
        plateau.affiche();
        Case c = null;
        while (c == null || c.getPion() == null || c.getPion().getCouleur() != b) {
            System.out.println("Sélectionnez la coordonnée d'une case possédant un pion de votre couleur (" + b + ")");
            String s = sc.nextLine();
            try {
                c = plateau.getCase(s);
            } catch (Exception e) {
                System.out.println("La saisie n'est pas bonne !");
            }
        }
        System.out.println("[" + c.getX() + "," + c.getY() + "]");
        Case objectif = null;
        while (objectif == null || objectif.getPion() != null) {
            System.out.println("Sélectionnez la coordonnée de la case où vous souhaitez vous déplacer.");
            String s = sc.nextLine();
            try {
                objectif = plateau.getCase(s);
            } catch (Exception e) {
                System.out.println("La saisie n'est pas bonne !");
            }
        }
        System.out.println("[" + objectif.getX() + "," + objectif.getY() + "]");
        boolean bool = c.getPion().deplacer(c, objectif, plateau);
        if (bool) {
            System.out.println("Déplacement ok");
            tourDeJeu(!b);
        } else {
            System.out.println("Déplacement impossible, veuillez saisir un nouveau pion.");
            tourDeJeu(b);
        }
    }

}