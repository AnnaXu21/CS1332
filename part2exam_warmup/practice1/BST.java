import java.util.NoSuchElementException;

/**
 * Your implementation of a BST.
 */
public class BST<T extends Comparable<? super T>> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private BSTNode<T> root;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Returns whether or not data matching the given parameter is contained
     * within the tree.
     *
     * This should be done recursively.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to search for. You may assume data is never null.
     * @return true if the parameter is contained within the tree, false otherwise.
     */
    public boolean contains(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        
        // iterating way
        // if(root == null){
            // return false;
        // }
        // while(root != null){   
            // if ( data.compareTo(root.getData()) < 0) {
                // root = root.getLeft();
                
            // }else if ( data.compareTo(root.getData()) > 0) {
                // root = root.getRight();
                
            // }else { 
                // return true;
            // }
        // } 
        // return false; 
        return find(root, data);
    }
   
    private boolean find(BSTNode<T> node, T data){
        if(node == null){
            return false;
        }
        else if(data.compareTo(node.getData()) == 0 ){
            return true;
        }
        else if(data.compareTo(node.getData()) < 0 ){
            return find(node.getLeft(), data);
        }
        else if(data.compareTo(node.getData()) > 0 ){
            return find(node.getRight(), data);
        }
        return false;
    }

    /**
     * Removes and returns the data from the tree matching the given parameter.
     *
     * This must be done recursively.
     *
     * There are 3 cases to consider:
     * 1: The node containing the data is a leaf (no children). In this case,
     * simply remove it.
     * 2: The node containing the data has one child. In this case, simply
     * replace it with its child.
     * 3: The node containing the data has 2 children. Use the SUCCESSOR to
     * replace the data. You should use recursion to find and remove the
     * successor (you will likely need an additional helper method to
     * handle this case efficiently).
     *
     * Do NOT return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to remove. You may assume that data is never null.
     * @return The data that was removed.
     * @throws java.util.NoSuchElementException If the data is not in the tree.
     */
    public T remove(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
         if (data == null){
         throw new IllegalArgumentException("data is null"); 
        }
        BSTNode<T> dummy = new BSTNode<>(null);
        root = find(root, data, dummy);
        return dummy.getData();
    }
    
    private BSTNode<T> find(BSTNode<T> cur, T data, BSTNode<T> dummy) {
        if (cur == null) {
            // Data not found case
            throw new NoSuchElementException("Data not found in BST.");
        } else if (data.compareTo(cur.getData()) < 0){ 
            cur.setLeft(find(cur.getLeft(), data, dummy));        
        } else if (data.compareTo(cur.getData()) > 0){ 
            cur.setRight(find(cur.getRight(), data, dummy)); 
        } else if (data.compareTo(cur.getData()) == 0){ 
            // found node in BST
            // dummy = cur; <- this wont work
            dummy.setData(cur.getData());
            size--;
            // case 1: remove a leaf 
            if (cur.getLeft() == null && cur.getRight() == null){
                return null;
            }
            // case 2: remove a node with 1 child
            else if (cur.getLeft() != null && cur.getRight() == null) {
                cur = cur.getLeft();                        
            }else if (cur.getRight() != null && cur.getLeft() == null) {
                cur = cur.getRight();                        
            }
            // case 3: remove a node with 2 children
            else{
                BSTNode<T> temp = new BSTNode<>(null);
                cur.setRight(successor(cur.getRight(), temp));
                cur.setData(temp.getData());
            }
        }
        return cur; 
    }
    
    private BSTNode<T> successor(BSTNode<T> cur, BSTNode<T> temp) {
        if (cur.getLeft() == null){
            temp.setData(cur.getData());
            return cur.getRight();
            
        } else {
           cur.setLeft(successor(cur.getLeft(), temp));
           return cur; 
        }
    }

    /**
     * Returns the root of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The root of the tree
     */
    public BSTNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }

    /**
     * Returns the size of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the tree
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}
