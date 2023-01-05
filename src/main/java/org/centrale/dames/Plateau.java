package org.centrale.dames;

import java.util.LinkedList;
import java.util.List;

public class Plateau {
    private int nbCol;
    private int nbRow;
    private List<List<Case>> plateau;

    public Plateau() {
        nbCol = 10;
        nbRow = 10;
        plateau = new LinkedList<>();
        initPlateau();
    }

    private void initPlateau() {
        plateau = new LinkedList<>();
        for (int i = 0; i < nbCol; i++) {
            List<Case> row = new LinkedList<>();
            for (int j = 0; j < nbRow; j++) {
                if ((i + j) % 2 == 1) {
                    if (i < 4) {
                        row.add(new Case(j, i, new Pion(true)));
                    } else if (i > 5) {
                        row.add(new Case(j, i, new Pion(false)));
                    } else {
                        row.add(new Case(j, i, null));
                    }
                } else {
                    row.add(new Case(j, i, null));
                }
            }
            plateau.add(row);
        }
    }

    public void affiche() {
        System.out.println("     A  B  C  D  E  F  G  H  I  J");
        System.out.println();
        for (int i = 0; i < nbCol; i++) {
            System.out.print(i + "   ");
            for (int j = 0; j < nbRow; j++) {
                if (plateau.get(i).get(j).getPion() == null) {
                    System.out.print(" _ ");
                } else {
                    Pion p = plateau.get(i).get(j).getPion();
                    if (p.getClass().getSimpleName().equals("Dame")){
                        if (p.getCouleur()) {
                            System.out.print(" I ");
                        } else {
                            System.out.print(" O ");
                        }
                    } else{
                        if (p.getCouleur()) {
                            System.out.print(" 1 ");
                        } else {
                            System.out.print(" 0 ");
                        }
                    }
                }
            }
            System.out.println("   " + i);
        }
        System.out.println();
        System.out.println("     A  B  C  D  E  F  G  H  I  J");
    }

    public Case getCase(String s) {
        int x = s.charAt(0) - 'A';
        int y = s.charAt(1) - '0';
        return plateau.get(y).get(x);
    }

    public int getNbCol() {
        return this.nbCol;
    }

    public void setNbCol(int nbCol) {
        this.nbCol = nbCol;
    }

    public int getNbRow() {
        return this.nbRow;
    }

    public void setNbRow(int nbRow) {
        this.nbRow = nbRow;
    }

    public List<List<Case>> getPlateau() {
        return this.plateau;
    }

    public void setPlateau(List<List<Case>> plateau) {
        this.plateau = plateau;
    }

}
