package org.centrale.dames;

 
import java.math.*;

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

    public void deplacer(Case i, Case f){
        f.setPion(i.getPion());
        i.setPion(null);
    }

    public void manger(Case c){
        System.out.println("méthode manger");
        c.setPion(null);
    }

    public boolean deplacer(Case i, Case f, Plateau pla) {
        System.out.println("fonction déplacer pion");

        int dx, dy;
        int mX, mY;
        Case m ;

        boolean result = false; 

        if (f.getPion()==null){
            dx=f.getX()-i.getX();
            dy=f.getY()-i.getY();
            if ((dx != 0 ) ){ 
                if ((Math.abs(dx) + Math.abs(dy) == 2) || (dy > 0)){
                    this.deplacer(i, f);
                    result = true ; 
                }
                if((Math.abs(dx)+ Math.abs(dy) == 4) || (dy != 0)){
                   mX = i.getX()+dx/2 ;
                   mY = i.getY()+dy/2 ;
                   m = pla.getPlateau().get(mY).get(mX);
                   if(m.getPion().getCouleur() != this.getCouleur()){
                    this.manger(m);
                    this.deplacer(i, f);
                    result = true; 
                   }
                }
            }

        }
        return result; 
    }
}
