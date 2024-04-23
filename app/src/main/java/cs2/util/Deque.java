package cs2.util;
import java.util.NoSuchElementException;

/**
 * A double-ended queue (or deque) is a data structure that allows
 * insertion and removal of elements at both ends.  This interface
 * defines the operations that must be supported by any concrete
 * implementation of a deque.
 */
public interface Deque<T> {
    /**
     * Adds an item to the front (logical beginning) of the deque
     * @param item element to add to the front
     */
    public void prepend(T item);
    
    /**
     * Adds an item to the back (logical end) of the deque
     * @param item element to add to the back
     */
    public void append(T item);
  
    /**
     * Removes and returns the item at the front of the deque
     * @return the item at the front of the deque
     * @throws NoSuchElementException if the deque is empty
     */
    public T front() throws NoSuchElementException;
  
    /**
     * Removes and returns the item at the back of the deque
     * @return the item at the back of the deque
     * @throws NoSuchElementException if the deque is empty
     */
    public T back() throws NoSuchElementException;
  
    /**
     * Returns the item at the front of the deque without removing it
     * @return the item at the front of the deque
     * @throws NoSuchElementException if the deque is empty
     */
    public T peekFront() throws NoSuchElementException;
  
    /**
     * Returns the item at the back of the deque without removing it
     * @return the item at the back of the deque
     * @throws NoSuchElementException if the deque is empty
     */
    public T peekBack() throws NoSuchElementException;
  
    /**
     * Returns true if the deque is empty, false otherwise
     * @return true if the deque is empty, false otherwise
     */
    public boolean isEmpty();
  
    /**
     * Returns the number of items in the deque
     * @return the number of items in the deque
     */
    public int size();
  }
