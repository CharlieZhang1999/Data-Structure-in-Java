package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer(10);
        assertTrue(arb.isEmpty());
        Integer l1 = new Integer(1);
        Integer l2 = new Integer(2);
        arb.enqueue(l1);
        arb.enqueue(l2);
        assertEquals(l1, arb.peek());
        assertFalse(arb.isFull());
        arb.dequeue();
        arb.dequeue();
        assertTrue(arb.isEmpty());
    }

    /*@Test
    public void exceptionTest(){
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer(10);
        arb.dequeue();
    }*/

    /*@Test
    public void exceptionTest_2(){
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer(2);
        Integer l1 = new Integer(1);
        Integer l2 = new Integer(2);
        Integer l3 = new Integer(1);
        arb.enqueue(l1);
        arb.enqueue(l2);
        arb.enqueue(l3);
    }*/


    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
