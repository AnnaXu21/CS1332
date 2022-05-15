import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Your implementation of the pre-order, in-order, and post-order
 * traversals of a tree.
 */
public class Traversals<T extends Comparable<? super T>> {

    /**
     * DO NOT ADD ANY GLOBAL VARIABLES!
     */

    /**
     * Given the root of a binary search tree, generate a
     * pre-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the pre-order traversal of the tree.
     */
    public List<T> preorder(TreeNode<T> root) {
        List<T> lst = new ArrayList<T>();
        helperPre(root, lst);
        return lst;
    }
    private void helperPre(TreeNode<T> cur, List<T> lst){
        if (cur != null) {
            lst.add(cur.getData());
            helperPre(cur.getLeft(), lst);
            helperPre(cur.getRight(), lst);
            return;
        }
    }

    /**
     * Given the root of a binary search tree, generate an
     * in-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the in-order traversal of the tree.
     */
    public List<T> inorder(TreeNode<T> root) {
        List<T> lst = new ArrayList<T>();
        helperIn(root, lst);
        return lst;
    }
    private void helperIn(TreeNode<T> cur, List<T> lst){
        if (cur != null) {
            helperIn(cur.getLeft(), lst);
            lst.add(cur.getData());
            helperIn(cur.getRight(), lst);
        }
    }

    /**
     * Given the root of a binary search tree, generate a
     * post-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the post-order traversal of the tree.
     */
    public List<T> postorder(TreeNode<T> root) {
        List<T> lst = new ArrayList<T>();
        helperPo(root, lst);
        return lst;
    }
    private void helperPo(TreeNode<T> cur, List<T> lst){
        if (cur != null) {
            helperPo(cur.getLeft(), lst);
            helperPo(cur.getRight(), lst);
            lst.add(cur.getData());
        }
    }// WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
}
