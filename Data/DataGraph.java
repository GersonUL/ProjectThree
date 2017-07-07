/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Domain.Graph;
import Domain.NeighborNode;
import Domain.Node;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gerson
 */
public class DataGraph {
    private Node initNode;
    private Graph secondGraph;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    private int size;
    public DataGraph(){
    this.initNode=null;
    this.secondGraph=null;
    this.size=0;
    }//const
    
    public void insertNode(char id) {
        Node newNode = new Node(id, getSize());
        Node temp = this.initNode;
        newNode.nextNode=temp;
        this.initNode = newNode;
        this.size++;
    }//insertNode
    public Node getNode(char id){
        Node temp=this.initNode;
        while(temp!=null && temp.getId()!=id){
            temp=temp.nextNode;
        }//while
        return temp;
    }//getNode
    public List<Node> prim(char id){
        Node init=getNode(id);
        List<Node> listNodes=new ArrayList<Node>();
        do{
            init.visited=1;
            listNodes.add(init);
            NeighborNode neighborNode =init.neighborNode;
            
        }while(init!=null);
        return listNodes;
    }//prim    
    
}//class
