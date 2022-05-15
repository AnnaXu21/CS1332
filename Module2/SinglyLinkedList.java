
/**
 * Write a description of SinglyLinkedList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.NoSuchElementException;

/**
 * Your implementation of a Singly-Linked List.
 */
public class SinglyLinkedList<T> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
 
    private SinglyLinkedListNode<T> head;
    private SinglyLinkedListNode<T> tail;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the element to the front of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        if (data == null){
            throw new IllegalArgumentException("Data is null");
        } 
        if (size == 0) {
            head = new SinglyLinkedListNode<>(data);
            tail = head;
        } else {
            SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<>(data);
            newNode.setNext(head);
            head = newNode;
        }
        size++;
    }

    /**
     * Adds the element to the back of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        if (data == null){
            throw new IllegalArgumentException("Data is null");
        } 
        if (size == 0) {
            head = new SinglyLinkedListNode<>(data);
            tail = head;
        } else { 
            SinglyLinkedListNode<T> current = head;
            while (current.getNext() != null){
                current = current.getNext();
            }
            current.setNext( new SinglyLinkedListNode<> (data) );
            tail = current.getNext();
        }
        size++;
    }

    /**
     * Removes and returns the first data of the list.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        T temp;
        if (size == 0) {
            throw new NoSuchElementException("List is null");
        } 
        if (head.getNext() == null){
            temp = head.getData();
            head = null;
            tail = null;
        }else { 
            temp = head.getData();
            head = head.getNext();
        }
        
        size--;
        return temp;
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        if (size == 0) {
            throw new NoSuchElementException("List is null");
        }
        T temp;
        if (head.getNext() == null){
            temp = head.getData();
            head = null;
            tail = null;
        } else { 
            SinglyLinkedListNode<T> current = head;
            while( current.getNext().getNext() != null ) {
                current =current.getNext();
            }
            temp = current.getNext().getData();
            current.setNext(tail);
        }
        size--;
        return temp;
    }
    //add at index, not part of the module2 test, but for Practice Exam.
     public void addAtIndex(int index, T data) {
        if (tail == null) {
           SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<>(data); 
           head = newNode;
           tail = newNode;
           size++;
           return;
        }
        if (index == 0){

            SinglyLinkedListNode<T> newHead = new SinglyLinkedListNode<>(data);
            newHead.setNext(head);
            head = newHead;
            size++;
        } else {
            SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<>(data);
            SinglyLinkedListNode<T> current = head;
            SinglyLinkedListNode<T> preTargetNode = null;
            for (int i = 0; i < index; i++) {
                preTargetNode = current;
                current = current.getNext();
            }

            if (preTargetNode == tail) {
                preTargetNode.setNext(newNode);
                tail = newNode;

            }else{
                newNode.setNext(current);
                preTargetNode.setNext(newNode);
            }

            size++;
        }
        
        
    }

    /**
     * Returns the head node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the head of the list
     */
    public SinglyLinkedListNode<T> getHead() {
        // DO NOT MODIFY THIS METHOD!
        return head;
    }

    /**
     * Returns the tail node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the tail of the list
     */
    public SinglyLinkedListNode<T> getTail() {
        // DO NOT MODIFY THIS METHOD!
        return tail;
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