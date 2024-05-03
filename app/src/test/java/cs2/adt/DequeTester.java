package cs2.adt;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;


public class DequeTester {
  /* Place your thorough tester code here to test MyDeque
   * Be sure to test all of the required elements of the Deque interface,
   * including the exceptions that must be thrown.
   */
  private Deque<Integer> deq;
  // always need a @ using jUnit tester code
  // this part will reset an run before each method
  @BeforeEach
  void init(){
    deq = new MyDeque<Integer>();
  }
  @Test
  void testPrependFront(){
    // using assetTrue passes in 2 argemnts that equal eachother
    assertEquals(deq.size(), 0); 
    //assertTrue(false);
    deq.prepend(12);
    assertTrue(deq.front() == 12);
  }
  @Test
  void testAppendBack(){
    deq.append(10);
    assertTrue(deq.back() == 10);
  }

  @Test
  void testPeekFront(){
    //I should be returning the first front card 
    deq.prepend(1);
    deq.prepend(2);
    deq.prepend(3);
    assertEquals(3,deq.peekFront());
  }
  @Test
  void testPeekBack(){
    deq.append(5);
    deq.append(6);
    assertTrue(deq.peekBack() == 6);
    // return back card 
  }
  @Test
  void testExceptiosn(){
    try{
      // need to put argument 
      deq.front();
      fail("Exception not working when deque is empty");

    }
    catch(NoSuchElementException e){
      //IF IM HERE THEN IT WORKS

    }
    try{
      deq.back();
      fail("not working when deque is empty");

    }catch(NoSuchElementException e){

    }
  }
  
}