package org.centrale.dames;

import java.util.List;

public class Dame extends Pion{
    public Dame(){
        super();
    }

    /**
     * Constructeur d'une nouvelle Dame (pour la couleur : 1 = blanc, 0 = noir).
     * @param couleur Couleur de la dame créée (1 = blanc, 0 = noir)
     */
    public Dame(boolean couleur) {
        super(couleur);
    }

    /**
     * Teste si le déplacement d'une case à une autre est possible, pour une dame.
     * @param i Case du pion qu'on cherche à déplacer.
     * @param f Case où on cherche à déplacer le pion.
     * @param p Plateau sur lequel on évolue.
     * @return Vrai si le déplacement est possible, faux sinon.
     */
    public boolean deplace_possible(Case i, Case f, List<List<Case>> p) {
        
        System.out.println("Vérification de la possiblité du déplacement...");

        if ((f.getPion() == null) && ((f.getX() + f.getY()) % 2 != 0)) {
            if (i.getX()+i.getY() == f.getX()+f.getY()) {
                // Cas d'une diagonale /
                System.out.println("Diagonale /");
                if (i.getX()<=f.getX()) {
                    System.out.println("Test du passage, en haut à droite...");
                    for (int j=i.getX()+1 ; j<f.getX() ; j++) {
                        if (p.get(i.getX()+i.getY()-j).get(j).getPion() != null) {
                            if (p.get(i.getX()+i.getY()-j).get(j).getPion().getCouleur()==i.getPion().getCouleur()) {
                                System.out.println("Échec.");
                                return false;
                            }
                        }
                    }
                    System.out.println("Succès !");
                } else {
                    System.out.println("Test du passage, en bas à gauche...");
                    for (int j=f.getX()+1 ; j<i.getX() ; j++) {
                        if (p.get(i.getX()+i.getY()-j).get(j).getPion() != null) {
                            if (p.get(i.getX()+i.getY()-j).get(j).getPion().getCouleur()==i.getPion().getCouleur()) {
                                System.out.println("Échec.");
                                return false;
                            }
                        }
                    }
                    System.out.println("Succès !");
                }
                return false;
            } else if(i.getX()-i.getY() == f.getX()-f.getY()){
                // Cas d'une diagonale \
                System.out.println("Diagonale \\");
                if (i.getX()<=f.getX()) {
                    System.out.println("Test du passage, en bas à droite...");
                    for (int j=i.getX()+1 ; j<f.getX() ; j++) {
                        if (p.get(j-i.getX()+i.getY()).get(j).getPion() != null) {
                            if (p.get(j-i.getX()+i.getY()).get(j).getPion().getCouleur()==i.getPion().getCouleur()) {
                                System.out.println("Échec.");
                                return false;
                            }
                        }
                    }
                    System.out.println("Succès !");
                } else {
                    System.out.println("Test du passage, en haut à gauche...");
                    for (int j=f.getX()+1 ; j<i.getX() ; j++) {
                        if (p.get(j-i.getX()+i.getY()).get(j).getPion() != null) {
                            if (p.get(j-i.getX()+i.getY()).get(j).getPion().getCouleur()==i.getPion().getCouleur()) {
                                System.out.println("Échec.");
                                return false;
                            }
                        }
                    }
                    System.out.println("Succès !");
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Permet de manger le pion de la case passée en paramètre.
     * @param c Case sur laquelle on passe manger (qu'il y ait un pion ou pas).
     */
    @Override
    public void manger(Case c) {
        System.out.print("[" + c.getX() + "," + c.getY() + "] : ");
        if (c.getPion() != null){
            c.setPion(null);
            System.out.println("Pion mangé.");
        } else {
            System.out.println("Pas de pion à manger.");
        }
    }

    /**
     * Déplace la dame d'une case donnée vers une autre case.
     * @param i Case de la dame qu'on cherche à déplacer.
     * @param f Case où on cherche à déplacer la dame.
     * @param pla Plateau sur lequel on évolue.
     * @return Si la dame a été déplacée ou si son déplacement n'est pas possible.
     */
    @Override
    public boolean deplacer(Case i, Case f, Plateau pla) {
        System.out.println("Déplacement de la Dame.");
        List<List<Case>> p = pla.getPlateau();

        if (deplace_possible(i,f,p)) {
            if (i.getX()+i.getY() == f.getX()+f.getY()) {
                // Cas d'une diagonale /
                if (i.getX()<=f.getX()) {
                    for (int j=i.getX()+1 ; j<f.getX() ; j++) {
                        this.manger(p.get(i.getX()+i.getY()-j).get(j));
                    }
                } else {
                    for (int j=f.getX()+1 ; j<i.getX() ; j++) {
                        this.manger(p.get(i.getX()+i.getY()-j).get(j));
                    }
                }
            } else if(i.getX()-i.getY() == f.getX()-f.getY()){
                // Cas d'une diagonale \
                if (i.getX()<=f.getX()) {
                    for (int j=i.getX()+1 ; j<f.getX() ; j++) {
                        this.manger(p.get(j-i.getX()+i.getY()).get(j));
                    }
                } else {
                    for (int j=f.getX()+1 ; j<i.getX() ; j++) {
                        this.manger(p.get(j-i.getX()+i.getY()).get(j));
                    }
                }
            }
            f.setPion(i.getPion());
            i.setPion(null);
            System.out.println("La Dame a fini son déplacement.");
            return true;
            
        } 
        return false;
    }
}
