/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author santiago
 */
public class NeighborNode {
    public char id;
    public int cost;
    public NeighborNode next;

    public NeighborNode(char id, int cost) {
        this.id=id;
        this.cost=cost;
        this.next=null;
             
    }//constructor
    
}//class
