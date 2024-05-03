package cs2.adt;
import java.util.NoSuchElementException;

public class MyDeque<T> implements Deque<T> {
    /* 
     * Complete the Deque interface methods below.
     */
    // Dequeue is combination of Stack and Queue
    // using Linked Queue

    //private class because user does not need to know about this 
    
    private class Node {
        public T data;
        public Node next;
        public Node(T d, Node n) {
          data = d;
          next = n;
        }
      }
      private Node head;
      private Node last;
      public MyDeque() {
        head = null;
        last = null;
      }
      // should add item at the begining of the deque
      // think of this as the LinkedQueue
      public void prepend(T item){
        // null is for the tail/last 
        //however at the start we must set head to null because we currently don;t have anything in linled list 
        if(isEmpty()){
          head = new Node(item, null);
          last = head;
        }
        else{
          Node rover = head;
          Node vari = new Node(item, null);
          head = vari;
          head.next = rover;
        }
      }
      // think of this as the LinkedStack
      //would add node at the end so 
      public void append(T item){

        if(isEmpty()){
          head = new Node(item, null);
          last = head;
        }
        else{
          //
          Node rover = last;
          Node vari = new Node(item, null);

          last = vari;
          last.next =rover;
          head = last.next;

        }
      }
      
      public T front(){
        if(isEmpty()){
          throw new NoSuchElementException();
        }
        // need to think of ore corner casses 
        T first = head.data;
        Node rover = head ;
          if(rover == last){
            rover = null;
            last = null;
            return first;

        }
        head.next = head;// this is use replacing the next head after that card to be head 


        return first;
      }

      public T back(){
        if(isEmpty()){
          throw new NoSuchElementException();
        }
        T end = last.data;
        // think of rover as a dog that is going to reteave things 
        Node rover = head ;
          if(rover == last){
            rover = null;
            last = null;
            return end;

        }
        // want to use while loop / look at the paper he game me
        // rover.next is equivalent to i++
        while(rover.next != last){
          rover = rover.next;
                }
        last = rover;
        last.next = null;
        return end;
      }

      public T peekFront(){
        if(isEmpty()){
          // why am I getting an error here 
          throw new NoSuchElementException();
        }
        // returning the first item and that is it
        T front = head.data;
        return front;

      }
      
      public T peekBack(){
        // returning the last node 
        T end = last.data;
        return end;
      }

      public boolean isEmpty(){
        return head == null && last == null;
      }
      
      
      public int size(){
        // wrtie stuff here if it happens to be empty
        if (isEmpty()){
          return 0;
        }
        Node rover = head;
        if(rover == last){
          return 1;
        }
        
       int counter = 0;
       
        // for loop going through to count each node
        while( rover.next != last){
          counter++; 
        }
        return counter +1;
        // have to write more tester code/ what if there are no nodes 
        
      }


  }
  
  
