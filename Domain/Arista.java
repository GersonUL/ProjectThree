/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author gerson
 */
public class Arista {
    public char nodo1;
  public char nodo2;
  public int peso;
  public int x1, y1;
  public int x2, y2;
  public boolean verde;

    public Arista() {
        this.nodo1 = ' ';
        this.nodo2 = ' ';
        this.peso = 0;
        this.x1 = 0;
        this.y1 = 0;
        this.x2 = 0;
        this.y2 = 0;
    }

    public char getNodo1() {
        return nodo1;
    }

    public void setNodo1(char nodo1) {
        this.nodo1 = nodo1;
    }

    public char getNodo2() {
        return nodo2;
    }

    public void setNodo2(char nodo2) {
        this.nodo2 = nodo2;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }
  
}//class
