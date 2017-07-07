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
public class Graph {
    private Node initNode;
    private Graph secondGraph;
    private int size;
    
    public Graph() {
        this.initNode = null;
        this.size = 0;
    }//constructor

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    

}//class
