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
public class Node {
    public char id;
    public int visited;
    public NeighborNode neighborNode;
    public Node nextNode;
    public int input;

    public Node(char id, int input) {
        this.id = id;
        this.input = input;
        this.visited=0;
        this.neighborNode=null;
        this.nextNode=null;
    }//const

    public char getId() {
        return id;
    }

    public void setId(char id) {
        this.id = id;
    }

    public int getVisited() {
        return visited;
    }

    public void setVisited(int visited) {
        this.visited = visited;
    }

    public NeighborNode getNeighborNode() {
        return neighborNode;
    }

    public void setNeighborNode(NeighborNode neighborNode) {
        this.neighborNode = neighborNode;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public int getInput() {
        return input;
    }

    public void setInput(int input) {
        this.input = input;
    }

   
    
            
}//class
