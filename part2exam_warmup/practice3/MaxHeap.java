/**
 * Your implementation of a MaxHeap.
 */
public class MaxHeap<T extends Comparable<? super T>> {

    /*
     * The initial capacity of the MaxHeap when created with the default
     * constructor.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 13;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new MaxHeap.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast a Comparable[] to a T[] to get the generic typing.
     */
    public MaxHeap() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
    }

    /**
     * Removes and returns the max item of the heap. As usual for array-backed
     * structures, be sure to null out spots as you remove. Do not decrease the
     * capacity of the backing array.
     *
     * Method should run in O(log n) time.
     *
     * You may assume that the heap is not empty.
     *
     * @return The data that was removed.
     */
    public T remove() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        T returned = backingArray[1];
        backingArray[1] = backingArray[size];
        backingArray[size] = null;
        size--;
        heapifyDown();
        
        return returned;
    }
    private void heapifyDown(){

        int index = 1;
        T parent = backingArray[index];
        T leftChild = getLeftChild(index);
        T rightChild = getRightChild(index);
        
        // Determine number of children
        int numChildren = 0;
        if (leftChild != null && rightChild == null) {
            numChildren = 1;
        }
        else if (leftChild != null && rightChild != null) {
            numChildren = 2;
        }
        
        while (numChildren != 0){    

            int comparison = 0;
            int biggestIndex = 0;
            if (numChildren == 1) {
                comparison = parent.compareTo(leftChild);
                biggestIndex = 2 * index;
            }
            else if (numChildren == 2) {
                // Determine higher priority child.
                // Start by assuming it's the left child.
                int priorityIndex = 2 * index;
                // If left is smaller than right, change assignment to right.
                if (leftChild.compareTo(rightChild) < 0) {
                    priorityIndex = 2 * index + 1;
                }
                T biggestChild = backingArray[priorityIndex];
                comparison = parent.compareTo(biggestChild);
                biggestIndex = priorityIndex;
            }
            // swap parent and child
            if (comparison <0) {
                swap(index, biggestIndex);
            }
            index = biggestIndex;
            leftChild = getLeftChild(index);
            rightChild = getRightChild(index);
            if (leftChild != null && rightChild == null) {
                numChildren = 1;
            }
            else if (leftChild != null && rightChild != null) {
                numChildren = 2;
            } else{ numChildren =  0; }           
        }
        return;
    }
    
    private void swap(int a, int b){
        T tempItem = backingArray[a];
        backingArray[a] = backingArray[b];
        backingArray[b] = tempItem;
    }
    /**
     * Gets the left child of a node at an index.
     * @param index The index of the node.
     * @return The data in the left child node.
     */
    private T getLeftChild(int index) {
        if (2 * index > size) {
            return null;
        }
        return backingArray[2 * index];
    }

    /**
     * Gets the right child of a node at an index.
     * @param index The index of the node.
     * @return The data in the right child node.
     */
    private T getRightChild(int index) {
        if (2 * index + 1 > size) {
            return null;
        }
        return backingArray[2 * index + 1];
    }

    /**
     * Returns the backing array of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }



    /**
     * Returns the size of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}