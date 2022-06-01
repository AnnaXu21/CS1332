import java.util.NoSuchElementException;

/**
 * Your implementation of a MinHeap.
 */
public class MinHeap<T extends Comparable<? super T>> {

    /**
     * The initial capacity of the MinHeap.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 13;

     /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;
    
    /*
     * test scetion
     */
    public static void main(String[] args) {
        MinHeap heap = new MinHeap();
        heap.add(0);
        heap.add(7);
        heap.add(14);
        heap.add(21);
        heap.add(28);
        heap.add(35);
        heap.add(42);
        heap.add(49);
        heap.add(56);
        heap.remove();
        heap.printHeap();
        
    }
     private void printHeap() {
        for (int i = 0; i < size+1; i++) {
            System.out.print(backingArray[i] + ", ");
        }
        System.out.println();
    }
    /**
     * This is the constructor that constructs a new MinHeap.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast a Comparable[] to a T[] to get the generic typing.
     */
    public MinHeap() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
    }

    /**
     * Adds an item to the heap. If the backing array is full (except for
     * index 0) and you're trying to add a new item, then double its capacity.
     *
     * Method should run in amortized O(log n) time.
     *
     * @param data The data to add.
     * @throws java.lang.IllegalArgumentException If the data is null.
     */
    public void add(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        int capacity = INITIAL_CAPACITY;
        backingArray[0] = null;
        int i = 1;
        if (data == null){
            throw new IllegalArgumentException("data is null");
        }
        // resize if capacity is full
         if (size == backingArray.length - 1) {
            doubleSize();
        }
        backingArray[size + 1] = data;
        size++;
        //sort
        heapifyUp();
    }
    private void doubleSize() {
        T[] newBacking = (T[]) new Comparable[backingArray.length * 2];
        for (int i = 1; i < backingArray.length; ++i) {
            newBacking[i] = backingArray[i];
        }
        backingArray = newBacking;
    }
    private void heapifyUp(){
        while(size > 1 && backingArray[size].compareTo(backingArray[size/2])  < 0){
            swap(size, size/2);
            size = size/2;
        }
    }
    private void swap(int a, int b){
        T tempItem = backingArray[a];
        backingArray[a] = backingArray[b];
        backingArray[b] = tempItem;
    }
    /**
     * Removes and returns the min item of the heap. As usual for array-backed
     * structures, be sure to null out spots as you remove. Do not decrease the
     * capacity of the backing array.
     *
     * Method should run in O(log n) time.
     *
     * @return The data that was removed.
     * @throws java.util.NoSuchElementException If the heap is empty.
     */
    public T remove() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (backingArray[1] == null){
            throw new NoSuchElementException("heap is empty");
        }
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
            int smallestIndex = 0;
            if (numChildren == 1) {
                comparison = parent.compareTo(leftChild);
                smallestIndex = 2 * index;
            }
            else if (numChildren == 2) {
                // Determine higher priority child.
                // Start by assuming it's the left child.
                int priorityIndex = 2 * index;
                // If left is larger than right, change assignment to right.
                if (leftChild.compareTo(rightChild) > 0) {
                    priorityIndex = 2 * index + 1;
                }
                T smallestChild = backingArray[priorityIndex];
                comparison = parent.compareTo(smallestChild);
                smallestIndex = priorityIndex;
            }
            // swap parent and child
            if (comparison > 0) {
                swap(index, smallestIndex);
            }
            index = smallestIndex;
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
        
        // // has left child
        // while (backingArray[index * 2] != null){
            // // has right child
            // if (backingArray[index * 2 +1] != null) {
                // int compare = backingArray[index * 2].compareTo(backingArray[index * 2 +1]);
                // if (compare < 0){
                    // smallerIndex = index*2; 
                // }else{ smallerIndex = index*2+1; }
            // }
            // // no right child
            // else if (backingArray[index * 2 +1] == null) {
                // smallerIndex = smallerIndex;
            // }
            
            // if (backingArray[index].compareTo(backingArray[smallerIndex]) > 0){
                // swap(index, smallerIndex);
            // } else { break;}

            // index = smallerIndex;
        // }
    
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

