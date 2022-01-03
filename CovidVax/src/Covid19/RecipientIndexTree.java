package Covid19;

import java.io.BufferedReader;
import java.io.IOException;

public class RecipientIndexTree<E> {

public RecipientIndexTree(){
     root = null;
}  

    public static class Node<E>{
  
        public E data;

        public Node<E> left;

        public Node<E> right;

        public Node(E data) {
        	this.data = data;
        	left = null;
        	right = null;
		
		
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
   
    protected Node<E> root;

    protected RecipientIndexTree(Node<E> root) {
        this.root = root;
        root.data = null;
    }

private Node addNode(Node<E> current, E d) {
    if (current == null) {
        return new Node(d);
    }

    if (!current.data.equals(d)) {
        current.left = addNode(current.left, d);
    } else if (!current.data.equals(d)) {
        current.right = addNode(current.right, d);
    } else {
        // value already exists
        return current;
    }

    return current;
}
public void add(E val) {
    root = addNode(root, val);
}


    public E getData() {
        if (root != null) {
            return root.data;
        } else {
            return null;
        }
    }

    public boolean searchRID(Node<E> node,E key){
    if (node==null)
        return false;
    if (node.data.equals(key))    
        return true;
    return  searchRID(node.left,key) || searchRID(node.right,key);
    }
    
    
    }

   
