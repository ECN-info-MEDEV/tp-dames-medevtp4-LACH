package org.centrale.dames;

public class Case {

    private int x;
    private int y;
    private Pion p;

    /**
     * 
     */
    public Case() {
        x = 0;
        y = 0;
        p = null;
    }

    /**
     * @param x
     * @param y
     * @param p
     */
    public Case(int x, int y, Pion p) {
        this.x = x;
        this.y = y;
        this.p = p;
    }

    public boolean jouable() {
        boolean jouable;
        if (((x + y) % 2 == 0) || (p != null)) {
            jouable = false;
        } else {
            jouable = true;
        }
        return jouable;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Pion getPion() {
        return p;
    }

    public void setPion(Pion p) {
        this.p = p;
    }

}
