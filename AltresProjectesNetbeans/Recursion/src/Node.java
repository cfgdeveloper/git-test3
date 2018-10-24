/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author formacio
 */
public class Node {
    
    public int value;
    public Node next;
    
    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
    
    public boolean hasNext() {
        return next != null;
    }
    
    public Node next() {
        return next;
    }
    
    public String toString() {
        return "Node value: " + value + "\n";
    }
}
