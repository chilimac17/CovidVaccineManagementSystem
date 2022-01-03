package Covid19;


//import java.io.BufferedReader;
//import java.io.IOException;

/**
 * Class for a binary tree that stores type E objects.
 **/
public class ClinicianIndexTree<E> {

    /** Class to encapsulate a tree node. */
    protected static class Node<E>{
 
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

    public ClinicianIndexTree() {
        root = null;
    }

    protected ClinicianIndexTree(Node<E> root) {
        this.root = root;
    }


    public E getData() {
        if (root != null) {
            return root.data;
        } else {
            return null;
        }
    }

    }




