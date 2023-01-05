package edu.centrale.tp4medev;

public class Pion {
    private boolean couleur; 
    // noir : 0 
    // blanc : 1 


    // Constructeurs 
    public Pion(){
        this.couleur=false; // couleur par défaut
    }

    public Pion(boolean c){
        this.couleur=c;
    }

    //Getters
    public boolean getCouleur(){
        return this.couleur;
    }

    //Setters 
    public void setCouleur(boolean c){
        this.couleur=c;
    }

    //Méthodes

    public void deplacer(Case ca, int dx, int dy){
        ca.setX(ca.getX()+dx);
        ca.setY(ca.getY()+dy);
    }

    public void manger(Case c){
        System.out.println("méthode manger");;
    }

    public void deplacer(Case i, Case f, Plateau pla) {
        System.out.println("fonction déplacer pion");
    }
}
