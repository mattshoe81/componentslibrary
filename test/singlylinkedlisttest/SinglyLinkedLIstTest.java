package singlylinkedlisttest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.Test;

import linkedlist.LinkedList;

public abstract class SinglyLinkedListTest {

    protected abstract LinkedList<String> constructorTest();

    /*
     * ************************************************************************
     * Single point control of change
     * ************************************************************************
     */

    private LinkedList<String> createFromArgsTest(String... args) {
        LinkedList<String> list = this.constructorTest();
        for (String arg : args) {
            list.add(arg);
        }

        return list;
    }

    /*
     * ***********************************************************************
     * Helper methods
     * ***********************************************************************
     */

    private LinkedList<String> createFromArgsRef(String... args) {
        LinkedList<String> list = new LinkedList<>();
        for (String arg : args) {
            list.add(arg);
        }

        return list;
    }

    private String[] getContents(LinkedList<String> list) {
        String[] contents = new String[list.length()];
        int position = list.position();
        list.moveToFront();
        if (list.length() > 0) {
            contents[0] = list.focus();
            for (int k = 1; k < list.length(); k++) {
                list.advance();
                contents[k] = list.focus();
            }
        }
        list.moveToPosition(position);

        return contents;
    }

    private String[] getContents(LinkedList<String> list) {
        String[] contents = new String[list.size()];

        for (int k = 0; k < list.size(); k++) {
            contents[k] = list.removeFirst();
            list.addLast(contents[k]);
        }

        return contents;
    }

    /*
     * ************************************************************************
     * **********************Kernel Methods Test Cases*************************
     * ************************************************************************
     */

    /*
     * add Method Test Cases
     */
    @Test
    public void addTest_routine() {
        /*
         * Set up variables
         */
        LinkedList<String> test = this.createFromArgsTest("a", "b", "c");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c");
        String addition = "d";

        /*
         * Call method under test
         */
        test.add(addition);
        exp.add(addition);

        /*
         * Compare contents of lists
         */
        String[] testContents = this.getContents(test);
        String[] expContents = this.getContents(exp);
        assertArrayEquals(expContents, testContents);
    }

    @Test
    public void addTest_toEmpty() {
        /*
         * Set up variables
         */
        LinkedList<String> test = this.createFromArgsTest();
        LinkedList<String> exp = this.createFromArgsRef();
        String addition = "d";

        /*
         * Call method under test
         */
        test.add(addition);
        exp.add(addition);

        /*
         * Compare contents of lists
         */
        String[] testContents = this.getContents(test);
        String[] expContents = this.getContents(exp);
        assertArrayEquals(expContents, testContents);
    }

    @Test
    public void addTest_duplicate() {
        /*
         * Set up variables
         */
        LinkedList<String> test = this.createFromArgsTest("a", "b", "c");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c");
        String addition = "a";

        /*
         * Call method under test
         */
        test.add(addition);
        exp.add(addition);

        /*
         * Compare contents of lists
         */
        String[] testContents = this.getContents(test);
        String[] expContents = this.getContents(exp);
        assertArrayEquals(expContents, testContents);
    }

    /*
     * addToFront Method Tests
     */
    @Test
    public void addToFrontTest_routine() {
        /*
         * Set up variables
         */
        LinkedList<String> test = this.createFromArgsTest("a", "b", "c");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c");
        String addition = "x";

        /*
         * Call method under test
         */
        test.addToFront(addition);
        exp.addFirst(addition);

        /*
         * Compare contents of lists
         */
        String[] testContents = this.getContents(test);
        String[] expContents = this.getContents(exp);
        assertArrayEquals(expContents, testContents);
    }

    @Test
    public void addToFrontTest_boundary() {
        /*
         * Set up variables
         */
        LinkedList<String> test = this.createFromArgsTest();
        LinkedList<String> exp = this.createFromArgsRef();
        String addition = "x";

        /*
         * Call method under test
         */
        test.addToFront(addition);
        exp.addFirst(addition);

        /*
         * Compare contents of lists
         */
        String[] testContents = this.getContents(test);
        String[] expContents = this.getContents(exp);
        assertArrayEquals(expContents, testContents);
    }

    /*
     * remove Method Tests
     */
    @Test
    public void removeTest_routine() {
        /*
         * Set up variables
         */
        LinkedList<String> test = this.createFromArgsTest("a", "b", "c");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c");
        String testRemoval;
        String expRemoval;

        /*
         * Call method under test
         */
        testRemoval = test.remove();
        expRemoval = exp.remove();

        /*
         * Compare contents of lists
         */
        String[] testContents = this.getContents(test);
        String[] expContents = this.getContents(exp);
        assertArrayEquals(expContents, testContents);
        assertEquals(expRemoval, testRemoval);
    }

    @Test
    public void removeTest_middle() {
        /*
         * Set up variables
         */
        LinkedList<String> test = this.createFromArgsTest("a", "b", "c");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c");
        String testRemoval;
        String expRemoval;
        int advanceCount = 1;
        for (int k = 0; k < advanceCount; k++) {
            test.advance();
        }

        /*
         * Call method under test
         */
        testRemoval = test.remove();
        expRemoval = exp.remove(advanceCount);

        /*
         * Compare contents of lists
         */
        String[] testContents = this.getContents(test);
        String[] expContents = this.getContents(exp);
        assertArrayEquals(expContents, testContents);
        assertEquals(expRemoval, testRemoval);
    }

    @Test
    public void removeTest_end() {
        /*
         * Set up variables
         */
        LinkedList<String> test = this.createFromArgsTest("a", "b", "c");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c");
        String testRemoval;
        String expRemoval;
        int advanceCount = 2;
        for (int k = 0; k < advanceCount; k++) {
            test.advance();
        }

        /*
         * Call method under test
         */
        testRemoval = test.remove();
        expRemoval = exp.removeLast();

        /*
         * Compare contents of lists
         */
        String[] testContents = this.getContents(test);
        String[] expContents = this.getContents(exp);
        assertArrayEquals(expContents, testContents);
        assertEquals(expRemoval, testRemoval);
    }

    @Test
    public void removeTest_middleNonTrivial() {
        /*
         * Set up variables
         */
        LinkedList<String> test = this.createFromArgsTest("a", "b", "c",
                "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
        String testRemoval;
        String expRemoval;
        int advanceCount = 4;
        for (int k = 0; k < advanceCount; k++) {
            test.advance();
        }

        /*
         * Call method under test
         */
        testRemoval = test.remove();
        expRemoval = exp.remove(advanceCount);

        /*
         * Compare contents of lists
         */
        String[] testContents = this.getContents(test);
        String[] expContents = this.getContents(exp);
        assertArrayEquals(expContents, testContents);
        assertEquals(expRemoval, testRemoval);
    }

    @Test
    public void removeTest_endNonTrivial() {
        /*
         * Set up variables
         */
        LinkedList<String> test = this.createFromArgsTest("a", "b", "c",
                "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
        String testRemoval;
        String expRemoval;
        int advanceCount = 6;
        for (int k = 0; k < advanceCount; k++) {
            test.advance();
        }

        /*
         * Call method under test
         */
        testRemoval = test.remove();
        expRemoval = exp.removeLast();
        /*
         * Compare contents of lists
         */
        String[] testContents = this.getContents(test);
        String[] expContents = this.getContents(exp);
        assertArrayEquals(expContents, testContents);
        assertEquals(expRemoval, testRemoval);
    }

    /*
     * moveToFront Method Tests
     */
    @Test
    public void moveToFrontTest_routine() {
        /*
         * Set up variables
         */
        LinkedList<String> test = this.createFromArgsTest("a", "b", "c",
                "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
        int advanceCount = 4;
        for (int k = 0; k < advanceCount; k++) {
            test.advance();
        }

        /*
         * Call method under test
         */
        test.moveToFront();

        /*
         * Compare contents of lists
         */
        String[] testContents = this.getContents(test);
        String[] expContents = this.getContents(exp);
        assertArrayEquals(expContents, testContents);
        assertEquals(exp.peekFirst(), test.focus());
    }

    /*
     * length Method TEsts
     */
    @Test
    public void lengthTest_routine() {
        /*
         * Set up variables
         */
        LinkedList<String> test = this.createFromArgsTest("a", "b", "c",
                "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
        int testLength;
        int expLength;

        /*
         * Call method under test
         */
        testLength = test.length();
        expLength = exp.size();

        /*
         * Compare contents of lists
         */
        String[] testContents = this.getContents(test);
        String[] expContents = this.getContents(exp);
        assertArrayEquals(expContents, testContents);
        assertEquals(expLength, testLength);
    }

    @Test
    public void lengthTest_boundary() {
        /*
         * Set up variables
         */
        LinkedList<String> test = this.createFromArgsTest();
        LinkedList<String> exp = this.createFromArgsRef();
        int testLength;
        int expLength;

        /*
         * Call method under test
         */
        testLength = test.length();
        expLength = exp.size();

        /*
         * Compare contents of lists
         */
        String[] testContents = this.getContents(test);
        String[] expContents = this.getContents(exp);
        assertArrayEquals(expContents, testContents);
        assertEquals(expLength, testLength);
    }

    @Test
    public void lengthTest_singleEntry() {
        /*
         * Set up variables
         */
        LinkedList<String> test = this.createFromArgsTest("a");
        LinkedList<String> exp = this.createFromArgsRef("a");
        int testLength;
        int expLength;

        /*
         * Call method under test
         */
        testLength = test.length();
        expLength = exp.size();

        /*
         * Compare contents of lists
         */
        String[] testContents = this.getContents(test);
        String[] expContents = this.getContents(exp);
        assertArrayEquals(expContents, testContents);
        assertEquals(expLength, testLength);
    }

    /*
     * insert Method Tests
     */
    @Test
    public void insertTest_routine() {
        /*
         * Set up variables
         */
        LinkedList<String> test = this.createFromArgsTest("a", "b", "c",
                "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
        String insertion = "x";
        int position = 4;
        test.moveToPosition(position);

        /*
         * Call method under test
         */
        test.insert(insertion);
        exp.add(position + 1, insertion);

        /*
         * Compare contents of lists
         */
        String[] testContents = this.getContents(test);
        String[] expContents = this.getContents(exp);
        assertArrayEquals(expContents, testContents);
    }

    @Test
    public void insertTest_boundary() {
        /*
         * Set up variables
         */
        LinkedList<String> test = this.createFromArgsTest("a");
        LinkedList<String> exp = this.createFromArgsRef("a");
        String insertion = "x";
        int position = 0;
        test.moveToPosition(position);

        /*
         * Call method under test
         */
        test.insert(insertion);
        exp.add(position + 1, insertion);

        /*
         * Compare contents of lists
         */
        String[] testContents = this.getContents(test);
        String[] expContents = this.getContents(exp);
        assertArrayEquals(expContents, testContents);
    }

    /*
     * focus Method tests
     */
    @Test
    public void focusTest_routine() {
        /*
         * Set up variables
         */
        LinkedList<String> test = this.createFromArgsTest("a", "b", "c",
                "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
        String testFocus;
        String expFocus = "d";
        test.moveToPosition(3);

        /*
         * Call method under test
         */
        testFocus = test.focus();

        /*
         * Compare contents of lists
         */
        String[] testContents = this.getContents(test);
        String[] expContents = this.getContents(exp);
        assertArrayEquals(expContents, testContents);
        assertEquals(expFocus, testFocus);
    }

    @Test
    public void focusTest_boundary() {
        /*
         * Set up variables
         */
        LinkedList<String> test = this.createFromArgsTest("a");
        LinkedList<String> exp = this.createFromArgsRef("a");
        String testFocus;
        String expFocus = "a";

        /*
         * Call method under test
         */
        testFocus = test.focus();

        /*
         * Compare contents of lists
         */
        String[] testContents = this.getContents(test);
        String[] expContents = this.getContents(exp);
        assertArrayEquals(expContents, testContents);
        assertEquals(expFocus, testFocus);
    }

    @Test
    public void focusTest_end() {
        /*
         * Set up variables
         */
        LinkedList<String> test = this.createFromArgsTest("a", "b", "c",
                "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
        String testFocus;
        String expFocus = "g";
        test.moveToPosition(6);

        /*
         * Call method under test
         */
        testFocus = test.focus();

        /*
         * Compare contents of lists
         */
        String[] testContents = this.getContents(test);
        String[] expContents = this.getContents(exp);
        assertArrayEquals(expContents, testContents);
        assertEquals(expFocus, testFocus);
    }

    /*
     * moveToRear Method Tests
     */
    @Test
    public void moveToRearTest_routine() {
        /*
         * Set up variables
         */
        LinkedList<String> test = this.createFromArgsTest("a", "b", "c",
                "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
        String rear = exp.peekLast();
        test.moveToPosition(3);

        /*
         * Call method under test
         */
        test.moveToRear();

        /*
         * Compare contents of lists
         */
        String[] testContents = this.getContents(test);
        String[] expContents = this.getContents(exp);
        assertArrayEquals(expContents, testContents);
        assertEquals(test.length() - 1, test.position());
        assertEquals(rear, test.focus());
    }

    @Test
    public void moveToRearTest_boundary() {
        /*
         * Set up variables
         */
        LinkedList<String> test = this.createFromArgsTest("a");
        LinkedList<String> exp = this.createFromArgsRef("a");
        String rear = exp.peekLast();

        /*
         * Call method under test
         */
        test.moveToRear();

        /*
         * Compare contents of lists
         */
        String[] testContents = this.getContents(test);
        String[] expContents = this.getContents(exp);
        assertArrayEquals(expContents, testContents);
        assertEquals(test.length() - 1, test.position());
        assertEquals(rear, test.focus());
    }

    /*
     * ************************************************************************
     * **********************Secondary Method Tests****************************
     * ************************************************************************
     */
    @Test
    public void equalsTest_routineTrue() {
        /*
         * Set up variables
         */
        LinkedList<String> test1 = this.createFromArgsTest("a", "b", "c",
                "d", "e", "f", "g");
        LinkedList<String> test2 = this.createFromArgsTest("a", "b", "c",
                "d", "e", "f", "g");
        boolean test;
        boolean expTest = true;
        int positionBefore = test1.position();
        int positionAfter;

        /*
         * Call method under test
         */
        test = test1.equals(test2);
        positionAfter = test1.position();

        /*
         * Compare contents of lists
         */
        assertEquals(expTest, test);
        assertEquals(positionAfter, positionBefore);
    }

    @Test
    public void equalsTest_routinefalse() {
        /*
         * Set up variables
         */
        LinkedList<String> test1 = this.createFromArgsTest("a", "b", "c",
                "d", "e", "f", "g");
        LinkedList<String> test2 = this.createFromArgsTest("a", "b", "c");
        boolean test;
        boolean expTest = false;

        /*
         * Call method under test
         */
        test = test1.equals(test2);

        /*
         * Compare contents of lists
         */
        assertEquals(expTest, test);
    }

    @Test
    public void equalsTest_boundaryTrue() {
        /*
         * Set up variables
         */
        LinkedList<String> test1 = this.createFromArgsTest();
        LinkedList<String> test2 = this.createFromArgsTest();
        boolean test;
        boolean expTest = true;

        /*
         * Call method under test
         */
        test = test1.equals(test2);

        /*
         * Compare contents of lists
         */
        assertEquals(expTest, test);
    }

    @Test
    public void equalsTest_boundaryFalse() {
        /*
         * Set up variables
         */
        LinkedList<String> test1 = this.createFromArgsTest("a");
        LinkedList<String> test2 = this.createFromArgsTest("b");
        boolean test;
        boolean expTest = false;

        /*
         * Call method under test
         */
        test = test1.equals(test2);

        /*
         * Compare contents of lists
         */
        assertEquals(expTest, test);
    }

    /*
     * toString Method Tests
     */
    @Test
    public void toStringTest_routine() {
        /*
         * Set up variables
         */
        LinkedList<String> test = this.createFromArgsTest("a", "b", "c",
                "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsTest("a", "b", "c",
                "d", "e", "f", "g");
        String testString;
        String expString = "<a, b, c, d, e, f, g>";

        /*
         * Call method under test
         */
        testString = test.toString();

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);
        assertEquals(expString, testString);
    }

    @Test
    public void toStringTest_nonZeroPosition() {
        /*
         * Set up variables
         */
        LinkedList<String> test = this.createFromArgsTest("a", "b", "c",
                "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsTest("a", "b", "c",
                "d", "e", "f", "g");
        String testString;
        String expString = "<a, b, c, d, e, f, g>";
        int position = 3;
        test.moveToPosition(position);

        /*
         * Call method under test
         */
        testString = test.toString();

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);
        assertEquals(expString, testString);
        assertEquals(position, test.position());
    }

    /*
     * removeFront Method Tests
     */
    @Test
    public void removeFrontTest_routine() {
        /*
         * Set up variables
         */
        LinkedList<String> test = this.createFromArgsTest("a", "b", "c",
                "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsTest("a", "b", "c",
                "d", "e", "f", "g");
        String testString;
        String expString = "<a, b, c, d, e, f, g>";
        int position = 3;
        test.moveToPosition(position);

        /*
         * Call method under test
         */
        testString = test.toString();

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);
        assertEquals(expString, testString);
        assertEquals(position, test.position());
    }
}
