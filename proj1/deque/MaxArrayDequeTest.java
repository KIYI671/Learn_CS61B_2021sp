package deque;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;


public class MaxArrayDequeTest {


    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {

        MaxArrayDeque<String> lld1 = new MaxArrayDeque<String>();

        assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
        lld1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

        lld1.addLast("middle");
        assertEquals(2, lld1.size());

        lld1.addLast("back");
        assertEquals(3, lld1.size());

        System.out.println("Printing out deque: ");
        lld1.printDeque();

    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {

        MaxArrayDeque<Integer> lld1 = new MaxArrayDeque<Integer>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

        lld1.addFirst(10);
        // should not be empty
        assertFalse("lld1 should contain 1 item", lld1.isEmpty());

        lld1.removeFirst();
        // should be empty
        assertTrue("lld1 should be empty after removal", lld1.isEmpty());

    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {

        MaxArrayDeque<Integer> lld1 = new MaxArrayDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);

    }

    @Test
    /* Check if you can create MaxArrayDeques with different parameterized types*/
    public void multipleParamTest() {


        MaxArrayDeque<String> lld1 = new MaxArrayDeque<String>();
        MaxArrayDeque<Double> lld2 = new MaxArrayDeque<Double>();
        MaxArrayDeque<Boolean> lld3 = new MaxArrayDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = (String) lld1.removeFirst();
        double d = (double) lld2.removeFirst();
        boolean b = (boolean) lld3.removeFirst();

    }

    @Test
    /* check if null is return when removing from an empty MaxArrayDeque. */
    public void emptyNullReturnTest() {

        MaxArrayDeque<Integer> lld1 = new MaxArrayDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());


    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {

        MaxArrayDeque<Integer> lld1 = new MaxArrayDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double)((int) lld1.removeFirst()), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double)((int) lld1.removeLast()), 0.0);
        }


    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest2() {

        MaxArrayDeque<Integer> lld1 = new MaxArrayDeque<Integer>();
        for (int i = 0; i < 100; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 50; i++) {
            assertEquals("Should have the same value", i, (double)((int) lld1.removeFirst()), 0.0);
        }

        for (double i = 99; i > 50; i--) {
            assertEquals("Should have the same value", i, (double)((int) lld1.removeLast()), 0.0);
        }


    }

    @Test
    /* 测试列表的格式化打印. */
    public void printDequeTest() {

        MaxArrayDeque<Integer> lld = new MaxArrayDeque<Integer>();
        for (int i = 0; i < 10; i++) {
            lld.addLast(i);
        }
        lld.printDeque();
        assertEquals(10, lld.size());
        assertEquals(5, (int) lld.get(5));
    }

    @Test
    /* 测试迭代器. */
    public void iteratorPrintDequeTest() {

        MaxArrayDeque<Integer> lld = new MaxArrayDeque<Integer>();
        for (int i = 0; i < 10; i++) {
            lld.addLast(i);
        }
        Iterator<Integer> illd = lld.iterator();
        int j =0;
        while(illd.hasNext()){
            int k = illd.next();
            assertEquals(j,k);
            j++;
        }
    }

    @Test
    /* 测试equals. */
    public void equalDequeTest() {

        MaxArrayDeque<Integer> lld = new MaxArrayDeque<Integer>();
        MaxArrayDeque<Integer> lld2 = new MaxArrayDeque<Integer>();
        for (int i = 0; i < 10; i++) {
            lld.addLast(i);
            lld2.addLast(i);
        }
        assertEquals(true,lld.equals(lld2));
        lld2.addLast(10);
        assertEquals(false,lld.equals(lld2));
    }

    @Test
    /* 测试equals. */
    public void iteratorDequeTest() {
        MaxArrayDeque<Double> lld = new MaxArrayDeque<Double>();

        for (double i = 0; i < 10; i++) {
            lld.addLast(i);
        }
        Comparator c = (o1, o2) -> 0;
        Iterator i = lld.iterator();
        System.out.println(lld.max(c));
    }
}
