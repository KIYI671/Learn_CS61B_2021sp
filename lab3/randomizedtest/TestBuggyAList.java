package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        correct.addLast(1);
        correct.addLast(2);
        correct.addLast(3);

        broken.addLast(1);
        broken.addLast(2);
        broken.addLast(3);

        assertEquals(correct.size(), broken.size());

        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B=new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                System.out.println("size: " + size);
                assertEquals(L.size(),B.size());
            } else if (operationNumber == 2) {
                if (L.size() > 0) {
                    // getLast
                    int last = L.getLast();
                    System.out.println("getLast: " + last);
                    assertEquals(L.getLast(),B.getLast());
                }
            } else {
                if (L.size() > 0) {
                    // removeLast
                    int last = L.removeLast();
                    int last2=B.removeLast();
                    System.out.println("removeLast: " + last);
                    assertEquals(last,last2);
                }
            }
        }
    }
}


