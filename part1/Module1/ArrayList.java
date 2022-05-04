import java.util.NoSuchElementException;

/**
 * Your implementation of an ArrayList.
 */
public class ArrayList<T> {

    /*
     * The initial capacity of the ArrayList.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 9;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new ArrayList.
     * 
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast an Object[] to a T[] to get the generic typing.
     */
    public ArrayList() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Adds element to specified index. Elements on 
     and after index will be shifted to the right to make room.
     * @param index Index to which data will be added.
     * @param data Data to be added.
     */
    private  void  addShift( int index, T data ) {
        for (int i = size - 1; i >= index; i--) {
            backingArray[i + 1] = backingArray[i];
        }
        size++;
        backingArray[index] = data;
    }
    
    /**
     * Adds the data to the front of the list.
     *
     * This add may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    

    public void addToFront(T data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        int index = 0;
        if (backingArray.length == size) {
            T[] tempArr = (T[]) new Object[backingArray.length * 2];
            tempArr[0] = data;
            for (int i = 1; i < size; i++) {
                tempArr[i] = backingArray[i];
            }
            size++;
            backingArray = tempArr;
        } else {
            addShift(index, data);
        }
    }

    /**
     * Adds the data to the back of the list.
     *
     * Method should run in amortized O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        int  index = size ;
        if (backingArray.length == size) {
            T[] tempArr = (T[]) new Object[backingArray.length * 2];
            for (int i = 0; i < size; i++) {
                tempArr[i] = backingArray[i];
            }
            backingArray = tempArr;
        }
        backingArray[index] = data;
        size++;
    }

    /**
     * Removes and returns the first data of the list.
     *
     * Do not shrink the backing array.
     *
     * This remove may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int index = 0;
        return getT(index);
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Do not shrink the backing array.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        T value = backingArray[size - 1];
        backingArray[size - 1] = null;
        size--;
        return value;
    }
     /**
      * Helper method for remove methods.
      * @param index Index of element to be deleted.
      * @return Deleted element.
      */
    private T getT(int index) {
        T value = backingArray[index];
        for (int i = index; i < size - 1; i++) {
            backingArray[i] = backingArray[i + 1];
        }
        backingArray[size - 1] = null;
        size--;
        return value;
    }
    /**
     * Returns the backing array of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}