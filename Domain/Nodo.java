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
public class Nodo {
    
  public int x;
  public int y;
  public int numero;
  public char letra;
public Nodo() {
        this.x = 0;
        this.y = 0;
        this.numero = 0;
        this.letra=' ';
    }
    public Nodo(char letra){
        this.letra=letra;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }
    
  
}//class
