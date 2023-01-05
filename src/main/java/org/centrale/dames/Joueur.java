package org.centrale.dames;

import java.util.Scanner;

public class Joueur {

    private boolean couleur ;

    /**
     * @param plateau
     * @return
     */
    public int nbpion(Plateau plateau){
        int nbpion = 0;
        for (int i = 0; i < plateau.getNbCol(); i++) {
            for (int j = 0; j < plateau.getNbRow(); j++) {
               if (plateau.getPlateau().get(i).get(j).getPion().getCouleur()== couleur) {
                nbpion++;
               }
            }
        }
        return nbpion;
    }

    public void tourdejeu(Plateau plateau){
        boolean step1 = false ;
        boolean step2 = false ;
        while ((step1 = false)||(step2 = false)){
            System.out.println("Choisir le pion à déplacer");
            Scanner sc = new Scanner(System.in) ;
            System.out.println("Coordonnée en x");
            String stx = sc.nextLine();
            int x = Integer.parseInt(stx);
            System.out.println("Coordonnée en y");
            String sty = sc.nextLine();
            int y = Integer.parseInt(sty);
            // Vérification choix du pion
            if(plateau.getPlateau().get(x).get(y).getPion().getCouleur()== couleur){
                System.out.println("Le choix du pion est valide");
                step1 = true;
            }
            else{
                System.out.println("Le choix du pion n'est pas valide");
                step2 = false;
            }
            if (step1 = true){
                System.out.println("Où déplacer le pion ?");
                System.out.println("Coordonnée en x");
                String nstx = sc.nextLine();
                int nx = Integer.parseInt(nstx);
                System.out.println("Coordonnée en y");
                String nsty = sc.nextLine();
                int ny = Integer.parseInt(nsty);
                // ajouter la méthode déplacer
            }
        }

    }

    public boolean getCouleur() {
        return this.couleur;
    }

    public void setCouleur(boolean couleur) {
        this.couleur = couleur;
    }
 
}