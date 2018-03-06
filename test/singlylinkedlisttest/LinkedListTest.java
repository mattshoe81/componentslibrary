package singlylinkedlisttest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.Test;

public abstract class LinkedListTest {

    protected abstract linkedlist.LinkedList<String> constructorTest();

    /*
     * ************************************************************************
     * Single point control of change
     * ************************************************************************
     */

    private linkedlist.LinkedList<String> createFromArgsTest(int position,
            String... args) {
        if (args.length > 0) {
            assert position < args.length : "Position must be valid index";
        } else {
            assert position == 0 : "Position must be zero if length is zero";
        }

        linkedlist.LinkedList<String> list = this.constructorTest();
        for (String arg : args) {
            list.add(arg);
        }

        for (int k = 0; k < position; k++) {
            list.advance();
        }

        return list;
    }

    /*
     * ***********************************************************************
     * Helper methods
     * ***********************************************************************
     */

    private LinkedList<String> createFromArgsRef(String... args) {
        java.util.LinkedList<String> list = new java.util.LinkedList<>();
        for (String arg : args) {
            list.add(arg);
        }

        return list;
    }

    private String[] getContents(linkedlist.LinkedList<String> list) {
        String[] contents = new String[list.length()];
        if (list.length() > 0) {
            int position = list.position();
            list.moveToFront();
            if (list.length() > 0) {
                contents[0] = list.focus();
                for (int k = 1; k < list.length(); k++) {
                    list.advance();
                    contents[k] = list.focus();
                }
            }
            if (list.length() > 0) {
                list.moveToPosition(position);
            }
        }

        return contents;
    }

    private String[] getContents(java.util.LinkedList<String> list) {
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
     * /////////////////////////////////////////////////////////////////////////
     * / add Method Test Cases
     *//////////////////////////////////////////////////////////////////////////
    @Test
    public void addTest_routine() {
        /*
         * Set up variables
         */
        linkedlist.LinkedList<String> test = this.createFromArgsTest(0, "a",
                "b", "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
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
        linkedlist.LinkedList<String> test = this.createFromArgsTest(0);
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
    public void addTest_nonZeroPosition() {
        /*
         * Set up variables
         */
        linkedlist.LinkedList<String> test = this.createFromArgsTest(3, "a",
                "b", "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
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

    @Test
    public void addTest_finalPosition() {
        /*
         * Set up variables
         */
        linkedlist.LinkedList<String> test = this.createFromArgsTest(6, "a",
                "b", "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
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

    @Test
    public void addTest_singleEntry() {
        /*
         * Set up variables
         */
        linkedlist.LinkedList<String> test = this.createFromArgsTest(0, "a");
        LinkedList<String> exp = this.createFromArgsRef("a");
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
     * /////////////////////////////////////////////////////////////////////////
     * / addToFront Method Tests
     *//////////////////////////////////////////////////////////////////////////
    @Test
    public void addToFrontTest_routine() {
        /*
         * Set up variables
         */
        linkedlist.LinkedList<String> test = this.createFromArgsTest(3, "a",
                "b", "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
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
        linkedlist.LinkedList<String> test = this.createFromArgsTest(0);
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

    @Test
    public void addToFrontTest_nonZeroPosition() {
        /*
         * Set up variables
         */
        linkedlist.LinkedList<String> test = this.createFromArgsTest(3, "a",
                "b", "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
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
    public void addToFrontTest_finalPosition() {
        /*
         * Set up variables
         */
        linkedlist.LinkedList<String> test = this.createFromArgsTest(3, "a",
                "b", "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
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
    public void addToFrontTest_frontPosition() {
        /*
         * Set up variables
         */
        linkedlist.LinkedList<String> test = this.createFromArgsTest(0, "a",
                "b", "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
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
     * /////////////////////////////////////////////////////////////////////////
     * / remove Method Tests
     *//////////////////////////////////////////////////////////////////////////
    @Test
    public void removeTest_routine() {
        /*
         * Set up variables
         */
        int position = 3;
        linkedlist.LinkedList<String> test = this.createFromArgsTest(position,
                "a", "b", "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
        String testRemoval;
        String expRemoval;

        /*
         * Call method under test
         */
        testRemoval = test.remove();
        expRemoval = exp.remove(position);

        /*
         * Compare contents of lists
         */
        String[] testContents = this.getContents(test);
        String[] expContents = this.getContents(exp);
        assertArrayEquals(expContents, testContents);
        assertEquals(expRemoval, testRemoval);
    }

    @Test
    public void removeTest_front() {
        /*
         * Set up variables
         */
        int position = 0;
        linkedlist.LinkedList<String> test = this.createFromArgsTest(position,
                "a", "b", "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
        String testRemoval;
        String expRemoval;

        /*
         * Call method under test
         */
        testRemoval = test.remove();
        expRemoval = exp.remove(position);

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
        int position = 6;
        linkedlist.LinkedList<String> test = this.createFromArgsTest(position,
                "a", "b", "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
        String testRemoval;
        String expRemoval;

        /*
         * Call method under test
         */
        testRemoval = test.remove();
        expRemoval = exp.remove(position);

        /*
         * Compare contents of lists
         */
        String[] testContents = this.getContents(test);
        String[] expContents = this.getContents(exp);
        assertArrayEquals(expContents, testContents);
        assertEquals(expRemoval, testRemoval);
    }

    @Test
    public void removeTest_toEmpty() {
        /*
         * Set up variables
         */
        int position = 0;
        linkedlist.LinkedList<String> test = this.createFromArgsTest(position,
                "a");
        LinkedList<String> exp = this.createFromArgsRef("a");
        String testRemoval;
        String expRemoval;

        /*
         * Call method under test
         */
        testRemoval = test.remove();
        expRemoval = exp.remove(position);

        /*
         * Compare contents of lists
         */
        String[] testContents = this.getContents(test);
        String[] expContents = this.getContents(exp);
        assertArrayEquals(expContents, testContents);
        assertEquals(expRemoval, testRemoval);
    }

    @Test
    public void removeTest_toSingleEntryFront() {
        /*
         * Set up variables
         */
        int position = 0;
        linkedlist.LinkedList<String> test = this.createFromArgsTest(position,
                "a", "b");
        LinkedList<String> exp = this.createFromArgsRef("a", "b");
        String testRemoval;
        String expRemoval;

        /*
         * Call method under test
         */
        testRemoval = test.remove();
        expRemoval = exp.remove(position);

        /*
         * Compare contents of lists
         */
        String[] testContents = this.getContents(test);
        String[] expContents = this.getContents(exp);
        assertArrayEquals(expContents, testContents);
        assertEquals(expRemoval, testRemoval);
    }

    @Test
    public void removeTest_toSingleEntryBack() {
        /*
         * Set up variables
         */
        int position = 1;
        linkedlist.LinkedList<String> test = this.createFromArgsTest(position,
                "a", "b");
        LinkedList<String> exp = this.createFromArgsRef("a", "b");
        String testRemoval;
        String expRemoval;

        /*
         * Call method under test
         */
        testRemoval = test.remove();
        expRemoval = exp.remove(position);

        /*
         * Compare contents of lists
         */
        String[] testContents = this.getContents(test);
        String[] expContents = this.getContents(exp);
        assertArrayEquals(expContents, testContents);
        assertEquals(expRemoval, testRemoval);
    }

    /*
     * /////////////////////////////////////////////////////////////////////////
     * / moveToFront Method Tests
     *//////////////////////////////////////////////////////////////////////////
    @Test
    public void moveToFrontTest_routine() {
        /*
         * Set up variables
         */
        linkedlist.LinkedList<String> test = this.createFromArgsTest(3, "a",
                "b", "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");

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

    @Test
    public void moveToFrontTest_alreadyFront() {
        /*
         * Set up variables
         */
        linkedlist.LinkedList<String> test = this.createFromArgsTest(0, "a",
                "b", "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");

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

    @Test
    public void moveToFrontTest_boundary() {
        /*
         * Set up variables
         */
        linkedlist.LinkedList<String> test = this.createFromArgsTest(0, "a");
        LinkedList<String> exp = this.createFromArgsRef("a");

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

    @Test
    public void moveToFrontTest_boundaryPlusOne() {
        /*
         * Set up variables
         */
        linkedlist.LinkedList<String> test = this.createFromArgsTest(1, "a",
                "b");
        LinkedList<String> exp = this.createFromArgsRef("a", "b");

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

    @Test
    public void moveToFrontTest_rear() {
        /*
         * Set up variables
         */
        linkedlist.LinkedList<String> test = this.createFromArgsTest(6, "a",
                "b", "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");

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
     * /////////////////////////////////////////////////////////////////////////
     * / length Method TEsts
     *//////////////////////////////////////////////////////////////////////////
    @Test
    public void lengthTest_routine() {
        /*
         * Set up variables
         */
        linkedlist.LinkedList<String> test = this.createFromArgsTest(0, "a",
                "b", "c", "d", "e", "f", "g");
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
        linkedlist.LinkedList<String> test = this.createFromArgsTest(0);
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
        linkedlist.LinkedList<String> test = this.createFromArgsTest(0, "a");
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
     * /////////////////////////////////////////////////////////////////////////
     * / insert Method Tests
     *//////////////////////////////////////////////////////////////////////////
    @Test
    public void insertTest_routine() {
        /*
         * Set up variables
         */
        int position = 3;
        linkedlist.LinkedList<String> test = this.createFromArgsTest(position,
                "a", "b", "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
        String insertion = "x";

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
        int position = 0;
        linkedlist.LinkedList<String> test = this.createFromArgsTest(position,
                "a");
        LinkedList<String> exp = this.createFromArgsRef("a");
        String insertion = "x";

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
     * /////////////////////////////////////////////////////////////////////////
     * / focus Method tests
     *//////////////////////////////////////////////////////////////////////////
    @Test
    public void focusTest_routine() {
        /*
         * Set up variables
         */
        int position = 3;
        linkedlist.LinkedList<String> test = this.createFromArgsTest(position,
                "a", "b", "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
        String testFocus;
        String expFocus = "d";

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
    public void focusTest_front() {
        /*
         * Set up variables
         */
        int position = 0;
        linkedlist.LinkedList<String> test = this.createFromArgsTest(position,
                "a", "b", "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
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
        int position = 6;
        linkedlist.LinkedList<String> test = this.createFromArgsTest(position,
                "a", "b", "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
        String testFocus;
        String expFocus = "g";

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
        int position = 0;
        linkedlist.LinkedList<String> test = this.createFromArgsTest(position,
                "a");
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

    /*
     * /////////////////////////////////////////////////////////////////////////
     * / moveToRear Method Tests
     *//////////////////////////////////////////////////////////////////////////
    @Test
    public void moveToRearTest_routine() {
        /*
         * Set up variables
         */
        int position = 3;
        linkedlist.LinkedList<String> test = this.createFromArgsTest(position,
                "a", "b", "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
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

    @Test
    public void moveToRearTest_boundary() {
        /*
         * Set up variables
         */
        int position = 0;
        linkedlist.LinkedList<String> test = this.createFromArgsTest(position,
                "a");
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

    @Test
    public void moveToRearTest_end() {
        /*
         * Set up variables
         */
        int position = 6;
        linkedlist.LinkedList<String> test = this.createFromArgsTest(position,
                "a", "b", "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
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

    /*
     * /////////////////////////////////////////////////////////////////////////
     * / equals Method Tests
     *//////////////////////////////////////////////////////////////////////////
    @Test
    public void equalsTest_routineTrue() {
        /*
         * Set up variables
         */
        int position = 3;
        linkedlist.LinkedList<String> test1 = this.createFromArgsTest(position,
                "a", "b", "c", "d", "e", "f", "g");
        linkedlist.LinkedList<String> test2 = this.createFromArgsTest(position,
                "a", "b", "c", "d", "e", "f", "g");
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
        String[] testContents = this.getContents(test1);
        String[] expContents = this.getContents(test2);
        assertArrayEquals(expContents, testContents);
        assertEquals(expTest, test);
        assertEquals(positionAfter, positionBefore);
    }

    @Test
    public void equalsTest_routineFalse() {
        /*
         * Set up variables
         */
        int position = 3;
        linkedlist.LinkedList<String> test1 = this.createFromArgsTest(position,
                "a", "b", "c", "d", "e", "f", "g");
        linkedlist.LinkedList<String> test2 = this.createFromArgsTest(position,
                "a", "b", "c", "XYZ", "e", "f", "g");
        boolean test;
        boolean expTest = false;
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
    public void equalsTest_boundaryTrue() {
        /*
         * Set up variables
         */
        int position = 0;
        linkedlist.LinkedList<String> test1 = this.createFromArgsTest(position);
        linkedlist.LinkedList<String> test2 = this.createFromArgsTest(position);
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
        String[] testContents = this.getContents(test1);
        String[] expContents = this.getContents(test2);
        assertArrayEquals(expContents, testContents);
        assertEquals(expTest, test);
        assertEquals(positionAfter, positionBefore);
    }

    @Test
    public void equalsTest_boundaryFalse() {
        /*
         * Set up variables
         */
        int position = 0;
        linkedlist.LinkedList<String> test1 = this.createFromArgsTest(position,
                "a");
        linkedlist.LinkedList<String> test2 = this.createFromArgsTest(position,
                "XYZ");
        boolean test;
        boolean expTest = false;
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

    /*
     * /////////////////////////////////////////////////////////////////////////
     * / toString Method Tests
     *//////////////////////////////////////////////////////////////////////////
    @Test
    public void toStringTest_routine() {
        /*
         * Set up variables
         */
        int position = 3;
        linkedlist.LinkedList<String> test = this.createFromArgsTest(position,
                "a", "b", "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
        String testString;
        String expString = "<a, b, c, d, e, f, g>";

        /*
         * Call method under test
         */
        testString = test.toString();
        /*
         * Compare contents of lists
         */
        String[] testContents = this.getContents(test);
        String[] expContents = this.getContents(exp);
        assertArrayEquals(expContents, testContents);
        assertEquals(expString, testString);
    }

    @Test
    public void toStringTest_frontPosition() {
        /*
         * Set up variables
         */
        int position = 0;
        linkedlist.LinkedList<String> test = this.createFromArgsTest(position,
                "a", "b", "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
        String testString;
        String expString = "<a, b, c, d, e, f, g>";

        /*
         * Call method under test
         */
        testString = test.toString();

        /*
         * Compare contents of lists
         */
        String[] testContents = this.getContents(test);
        String[] expContents = this.getContents(exp);
        assertArrayEquals(expContents, testContents);
        assertEquals(expString, testString);
        assertEquals(position, test.position());
    }

    @Test
    public void toStringTest_empty() {
        /*
         * Set up variables
         */
        int position = 0;
        linkedlist.LinkedList<String> test = this.createFromArgsTest(position);
        LinkedList<String> exp = this.createFromArgsRef();
        String testString;
        String expString = "<>";

        /*
         * Call method under test
         */
        testString = test.toString();

        /*
         * Compare contents of lists
         */
        String[] testContents = this.getContents(test);
        String[] expContents = this.getContents(exp);
        assertArrayEquals(expContents, testContents);
        assertEquals(expString, testString);
        assertEquals(position, test.position());
    }

    @Test
    public void toStringTest_singleEntry() {
        /*
         * Set up variables
         */
        int position = 0;
        linkedlist.LinkedList<String> test = this.createFromArgsTest(position,
                "a");
        LinkedList<String> exp = this.createFromArgsRef("a");
        String testString;
        String expString = "<a>";

        /*
         * Call method under test
         */
        testString = test.toString();

        /*
         * Compare contents of lists
         */
        String[] testContents = this.getContents(test);
        String[] expContents = this.getContents(exp);
        assertArrayEquals(expContents, testContents);
        assertEquals(expString, testString);
        assertEquals(position, test.position());
    }

    /*
     * /////////////////////////////////////////////////////////////////////////
     * / removeFront Method Tests
     *//////////////////////////////////////////////////////////////////////////
    @Test
    public void removeFrontTest_routine() {
        /*
         * Set up variables
         */
        int position = 3;
        linkedlist.LinkedList<String> test = this.createFromArgsTest(position,
                "a", "b", "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
        String testFront;
        String expFront;

        /*
         * Call method under test
         */
        testFront = test.removeFront();
        expFront = exp.removeFirst();

        /*
         * Compare contents of lists
         */
        String[] testContents = this.getContents(test);
        String[] expContents = this.getContents(exp);
        assertArrayEquals(expContents, testContents);
        assertEquals(expFront, testFront);
        assertEquals(position - 1, test.position());
    }

    @Test
    public void removeFrontTest_boundary() {
        /*
         * Set up variables
         */
        int position = 0;
        linkedlist.LinkedList<String> test = this.createFromArgsTest(position,
                "a");
        LinkedList<String> exp = this.createFromArgsRef("a");
        String testFront;
        String expFront;

        /*
         * Call method under test
         */
        testFront = test.removeFront();
        expFront = exp.removeFirst();

        /*
         * Compare contents of lists
         */
        String[] testContents = this.getContents(test);
        String[] expContents = this.getContents(exp);
        assertArrayEquals(expContents, testContents);
        assertEquals(expFront, testFront);
        assertEquals(position, test.position());
    }
}
