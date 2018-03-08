package linkedlisttest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.linkedlist.LinkedList;

public abstract class LinkedListTest {

    protected abstract LinkedList<String> constructorTest();

    protected abstract LinkedList<String> constructorRef();

    /*
     * ************************************************************************
     * Single point control of change
     * ************************************************************************
     */

    private LinkedList<String> createFromArgsTest(int position,
            String... args) {
        if (args.length > 0) {
            assert position < args.length : "Position must be valid index";
        } else {
            assert position == 0 : "Position must be zero if length is zero";
        }

        LinkedList<String> list = this.constructorTest();
        if (args.length > 0) {
            for (String arg : args) {
                list.add(arg);
            }

            list.moveToPosition(position);
        }

        return list;
    }

    private LinkedList<String> createFromArgsRef(int position, String... args) {
        LinkedList<String> list = this.constructorRef();
        if (args.length > 0) {
            for (String arg : args) {
                list.add(arg);
            }

            list.moveToPosition(position);
        }

        return list;
    }

    private LinkedList<String> createFromArgsRef(String... args) {
        LinkedList<String> list = this.constructorRef();
        if (args.length > 0) {
            for (String arg : args) {
                list.add(arg);
            }
        }

        return list;
    }

    private LinkedList<String> createFromArgsTest() {

        return new components.linkedlist.SinglyLinkedList<>();
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
        LinkedList<String> test = this.createFromArgsTest(0, "a", "b", "c", "d",
                "e", "f", "g");
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
        assertEquals(exp, test);
        assertEquals(exp, test);
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
        assertEquals(exp, test);

    }

    @Test
    public void addTest_nonZeroPosition() {
        /*
         * Set up variables
         */
        LinkedList<String> test = this.createFromArgsTest(3, "a", "b", "c", "d",
                "e", "f", "g");
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
        assertEquals(exp, test);

    }

    @Test
    public void addTest_finalPosition() {
        /*
         * Set up variables
         */
        LinkedList<String> test = this.createFromArgsTest(6, "a", "b", "c", "d",
                "e", "f", "g");
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
        assertEquals(exp, test);

    }

    @Test
    public void addTest_singleEntry() {
        /*
         * Set up variables
         */
        LinkedList<String> test = this.createFromArgsTest(0, "a");
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
        assertEquals(exp, test);

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
        LinkedList<String> test = this.createFromArgsTest(3, "a", "b", "c", "d",
                "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
        String addition = "x";

        /*
         * Call method under test
         */
        test.addToFront(addition);
        exp.addToFront(addition);

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

    }

    @Test
    public void addToFrontTest_nonZeroPosition() {
        /*
         * Set up variables
         */
        LinkedList<String> test = this.createFromArgsTest(3, "a", "b", "c", "d",
                "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
        String addition = "x";

        /*
         * Call method under test
         */
        test.addToFront(addition);
        exp.addToFront(addition);

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

    }

    @Test
    public void addToFrontTest_finalPosition() {
        /*
         * Set up variables
         */
        LinkedList<String> test = this.createFromArgsTest(3, "a", "b", "c", "d",
                "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
        String addition = "x";

        /*
         * Call method under test
         */
        test.addToFront(addition);
        exp.addToFront(addition);

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

    }

    @Test
    public void addToFrontTest_frontPosition() {
        /*
         * Set up variables
         */
        LinkedList<String> test = this.createFromArgsTest(0, "a", "b", "c", "d",
                "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
        String addition = "x";

        /*
         * Call method under test
         */
        test.addToFront(addition);
        exp.addToFront(addition);

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

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
        LinkedList<String> test = this.createFromArgsTest(position, "a", "b",
                "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef(position, "a", "b", "c",
                "d", "e", "f", "g");
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
        assertEquals(exp, test);

        assertEquals(expRemoval, testRemoval);
    }

    @Test
    public void removeTest_front() {
        /*
         * Set up variables
         */
        int position = 0;
        LinkedList<String> test = this.createFromArgsTest(position, "a", "b",
                "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef(position, "a", "b", "c",
                "d", "e", "f", "g");
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
        assertEquals(exp, test);

        assertEquals(expRemoval, testRemoval);
    }

    @Test
    public void removeTest_end() {
        /*
         * Set up variables
         */
        int position = 6;
        LinkedList<String> test = this.createFromArgsTest(position, "a", "b",
                "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef(position, "a", "b", "c",
                "d", "e", "f", "g");
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
        assertEquals(exp, test);

        assertEquals(expRemoval, testRemoval);
    }

    @Test
    public void removeTest_toEmpty() {
        /*
         * Set up variables
         */
        int position = 0;
        LinkedList<String> test = this.createFromArgsTest(position, "a");
        LinkedList<String> exp = this.createFromArgsRef(position, "a");
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
        assertEquals(exp, test);

        assertEquals(expRemoval, testRemoval);
    }

    @Test
    public void removeTest_toSingleEntryFront() {
        /*
         * Set up variables
         */
        int position = 0;
        LinkedList<String> test = this.createFromArgsTest(position, "a", "b");
        LinkedList<String> exp = this.createFromArgsRef(position, "a", "b");
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
        assertEquals(exp, test);

        assertEquals(expRemoval, testRemoval);
    }

    @Test
    public void removeTest_toSingleEntryBack() {
        /*
         * Set up variables
         */
        int position = 1;
        LinkedList<String> test = this.createFromArgsTest(position, "a", "b");
        LinkedList<String> exp = this.createFromArgsRef(position, "a", "b");
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
        assertEquals(exp, test);

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
        LinkedList<String> test = this.createFromArgsTest(3, "a", "b", "c", "d",
                "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef(3, "a", "b", "c", "d",
                "e", "f", "g");

        /*
         * Call method under test
         */
        test.moveToFront();
        exp.moveToFront();

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

        assertEquals(exp.focus(), test.focus());
    }

    @Test
    public void moveToFrontTest_alreadyFront() {
        /*
         * Set up variables
         */
        LinkedList<String> test = this.createFromArgsTest(0, "a", "b", "c", "d",
                "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef(0, "a", "b", "c", "d",
                "e", "f", "g");

        /*
         * Call method under test
         */
        test.moveToFront();
        exp.moveToFront();

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

        assertEquals(exp.focus(), test.focus());
    }

    @Test
    public void moveToFrontTest_boundary() {
        /*
         * Set up variables
         */
        LinkedList<String> test = this.createFromArgsTest(0, "a");
        LinkedList<String> exp = this.createFromArgsRef(0, "a");

        /*
         * Call method under test
         */
        test.moveToFront();
        exp.moveToFront();

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

        assertEquals(exp.focus(), test.focus());
    }

    @Test
    public void moveToFrontTest_boundaryPlusOne() {
        /*
         * Set up variables
         */
        LinkedList<String> test = this.createFromArgsTest(1, "a", "b");
        LinkedList<String> exp = this.createFromArgsRef(1, "a", "b");

        /*
         * Call method under test
         */
        test.moveToFront();
        exp.moveToFront();

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

        assertEquals(exp.focus(), test.focus());
    }

    @Test
    public void moveToFrontTest_rear() {
        /*
         * Set up variables
         */
        LinkedList<String> test = this.createFromArgsTest(6, "a", "b", "c", "d",
                "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef(6, "a", "b", "c", "d",
                "e", "f", "g");

        /*
         * Call method under test
         */
        test.moveToFront();
        exp.moveToFront();

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

        assertEquals(exp.focus(), test.focus());
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
        LinkedList<String> test = this.createFromArgsTest(0, "a", "b", "c", "d",
                "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
        int testLength;
        int expLength;

        /*
         * Call method under test
         */
        testLength = test.length();
        expLength = exp.length();

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

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
        expLength = exp.length();

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

        assertEquals(expLength, testLength);
    }

    @Test
    public void lengthTest_singleEntry() {
        /*
         * Set up variables
         */
        LinkedList<String> test = this.createFromArgsTest(0, "a");
        LinkedList<String> exp = this.createFromArgsRef("a");
        int testLength;
        int expLength;

        /*
         * Call method under test
         */
        testLength = test.length();
        expLength = exp.length();

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

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
        LinkedList<String> test = this.createFromArgsTest(position, "a", "b",
                "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef(position, "a", "b", "c",
                "d", "e", "f", "g");
        String insertion = "x";

        /*
         * Call method under test
         */
        test.insert(insertion);
        exp.insert(insertion);

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

    }

    @Test
    public void insertTest_boundary() {
        /*
         * Set up variables
         */
        int position = 0;
        LinkedList<String> test = this.createFromArgsTest(position, "a");
        LinkedList<String> exp = this.createFromArgsRef(position, "a");
        String insertion = "x";

        /*
         * Call method under test
         */
        test.insert(insertion);
        exp.insert(insertion);

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

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
        LinkedList<String> test = this.createFromArgsTest(position, "a", "b",
                "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef(position, "a", "b", "c",
                "d", "e", "f", "g");
        String testFocus;
        String expFocus = "d";

        /*
         * Call method under test
         */
        testFocus = test.focus();
        expFocus = exp.focus();

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

        assertEquals(expFocus, testFocus);
    }

    @Test
    public void focusTest_front() {
        /*
         * Set up variables
         */
        int position = 0;
        LinkedList<String> test = this.createFromArgsTest(position, "a", "b",
                "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef(position, "a", "b", "c",
                "d", "e", "f", "g");
        String testFocus;
        String expFocus;

        /*
         * Call method under test
         */
        testFocus = test.focus();
        expFocus = exp.focus();

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

        assertEquals(expFocus, testFocus);
    }

    @Test
    public void focusTest_end() {
        /*
         * Set up variables
         */
        int position = 6;
        LinkedList<String> test = this.createFromArgsTest(position, "a", "b",
                "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef(position, "a", "b", "c",
                "d", "e", "f", "g");
        String testFocus;
        String expFocus;

        /*
         * Call method under test
         */
        testFocus = test.focus();
        expFocus = exp.focus();

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

        assertEquals(expFocus, testFocus);
    }

    @Test
    public void focusTest_boundary() {
        /*
         * Set up variables
         */
        int position = 0;
        LinkedList<String> test = this.createFromArgsTest(position, "a");
        LinkedList<String> exp = this.createFromArgsRef(position, "a");
        String testFocus;
        String expFocus;

        /*
         * Call method under test
         */
        testFocus = test.focus();
        expFocus = exp.focus();

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

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
        LinkedList<String> test = this.createFromArgsTest(position, "a", "b",
                "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
        exp.moveToRear();
        String rear = exp.focus();

        /*
         * Call method under test
         */
        test.moveToRear();

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

        assertEquals(test.length() - 1, test.position());
        assertEquals(rear, test.focus());
    }

    @Test
    public void moveToRearTest_boundary() {
        /*
         * Set up variables
         */
        int position = 0;
        LinkedList<String> test = this.createFromArgsTest(position, "a");
        LinkedList<String> exp = this.createFromArgsRef("a");
        exp.moveToRear();
        String rear = exp.focus();

        /*
         * Call method under test
         */
        test.moveToRear();

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

        assertEquals(test.length() - 1, test.position());
        assertEquals(rear, test.focus());
    }

    @Test
    public void moveToRearTest_end() {
        /*
         * Set up variables
         */
        int position = 6;
        LinkedList<String> test = this.createFromArgsTest(position, "a", "b",
                "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
        exp.moveToRear();
        String rear = exp.focus();

        /*
         * Call method under test
         */
        test.moveToRear();

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

        assertEquals(test.length() - 1, test.position());
        assertEquals(rear, test.focus());
    }

    /*
     * position tests
     */
    @Test
    public void positionTest_routine() {
        /*
         * Set up variables
         */
        int expPosition = 3;
        LinkedList<String> test = this.createFromArgsTest(expPosition, "a", "b",
                "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef(expPosition, "a", "b",
                "c", "d", "e", "f", "g");
        exp.moveToPosition(expPosition);
        String expFocus = exp.focus();

        /*
         * Call method under test
         */
        int position = test.position();

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

        assertEquals(expPosition, position);
        assertEquals(expFocus, test.focus());
    }

    @Test
    public void positionTest_boundary() {
        /*
         * Set up variables
         */
        LinkedList<String> test = this.createFromArgsTest();
        LinkedList<String> exp = this.createFromArgsRef();

        /*
         * Call method under test
         */
        int position = test.position();

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

        assertEquals(-1, position);
    }

    @Test
    public void positionTest_singleEntry() {
        /*
         * Set up variables
         */
        int expPosition = 0;
        LinkedList<String> test = this.createFromArgsTest(expPosition, "a");
        LinkedList<String> exp = this.createFromArgsRef("a");
        exp.moveToPosition(expPosition);
        String expFocus = exp.focus();

        /*
         * Call method under test
         */
        int position = test.position();

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

        assertEquals(expPosition, position);
        assertEquals(expFocus, test.focus());
    }

    @Test
    public void positionTest_end() {
        /*
         * Set up variables
         */
        int expPosition = 6;
        LinkedList<String> test = this.createFromArgsTest(expPosition, "a", "b",
                "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
        exp.moveToPosition(expPosition);
        String expFocus = exp.focus();

        /*
         * Call method under test
         */
        int position = test.position();

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

        assertEquals(expPosition, position);
        assertEquals(expFocus, test.focus());
    }

    @Test
    public void positionTest_retreatThenAdvanceRoutine() {
        /*
         * Set up variables
         */
        int expPosition = 3;
        LinkedList<String> test = this.createFromArgsTest(expPosition, "a", "b",
                "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
        exp.moveToPosition(expPosition);
        String expFocus = exp.focus();
        test.retreat();
        test.retreat();
        test.advance();
        test.advance();

        /*
         * Call method under test
         */
        int position = test.position();

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

        assertEquals(expPosition, position);
        assertEquals(expFocus, test.focus());
    }

    @Test
    public void positionTest_retreatThenAdvanceToEnd() {
        /*
         * Set up variables
         */
        int expPosition = 5;
        LinkedList<String> test = this.createFromArgsTest(expPosition, "a", "b",
                "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
        exp.moveToPosition(expPosition + 1);
        String expFocus = exp.focus();
        test.retreat();
        test.retreat();
        test.advance();
        test.advance();
        test.advance();

        /*
         * Call method under test
         */
        int position = test.position();

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

        assertEquals(expPosition + 1, position);
        assertEquals(expFocus, test.focus());
    }

    @Test
    public void positionTest_afterRemoveRoutine() {
        /*
         * Set up variables
         */
        int expPosition = 3;
        LinkedList<String> test = this.createFromArgsTest(expPosition, "a", "b",
                "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "e", "f",
                "g");
        exp.moveToPosition(expPosition);
        String expFocus = exp.focus();
        test.remove();

        /*
         * Call method under test
         */
        int position = test.position();

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

        assertEquals(expPosition, position);
        assertEquals(expFocus, test.focus());
    }

    @Test
    public void positionTest_afterRemoveOnFront() {
        /*
         * Set up variables
         */
        int expPosition = 0;
        LinkedList<String> test = this.createFromArgsTest(expPosition, "a", "b",
                "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("b", "c", "d", "e", "f",
                "g");
        exp.moveToPosition(expPosition);
        String expFocus = exp.focus();
        test.remove();

        /*
         * Call method under test
         */
        int position = test.position();

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

        assertEquals(expPosition, position);
        assertEquals(expFocus, test.focus());
    }

    @Test
    public void positionTest_afterRemoveOnEnd() {
        /*
         * Set up variables
         */
        int expPosition = 6;
        LinkedList<String> test = this.createFromArgsTest(expPosition, "a", "b",
                "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f");
        exp.moveToPosition(0);
        String expFocus = exp.focus();
        test.remove();

        /*
         * Call method under test
         */
        int position = test.position();

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

        assertEquals(0, position);
        assertEquals(expFocus, test.focus());
    }

    @Test
    public void positionTest_afterAddToFrontRoutine() {
        /*
         * Set up variables
         */
        int expPosition = 3;
        LinkedList<String> test = this.createFromArgsTest(expPosition, "a", "b",
                "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
        exp.moveToPosition(expPosition);
        String expFocus = exp.focus();
        String addition = "X";
        test.addToFront(addition);
        exp.addToFront(addition);

        /*
         * Call method under test
         */
        int position = test.position();

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

        assertEquals(expPosition + 1, position);
        assertEquals(expFocus, test.focus());
    }

    @Test
    public void positionTest_afterAddToFrontAtFront() {
        /*
         * Set up variables
         */
        int expPosition = 0;
        LinkedList<String> test = this.createFromArgsTest(expPosition, "a", "b",
                "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef(expPosition, "a", "b",
                "c", "d", "e", "f", "g");
        String addition = "X";
        test.addToFront(addition);
        exp.addToFront(addition);

        /*
         * Call method under test
         */
        int position = test.position();

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

        assertEquals(expPosition, position);
        assertEquals("X", test.focus());
        assertEquals("X", exp.focus());
    }

    @Test
    public void positionTest_afterAddToFrontAtEnd() {
        /*
         * Set up variables
         */
        int expPosition = 6;
        LinkedList<String> test = this.createFromArgsTest(expPosition, "a", "b",
                "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
        exp.moveToPosition(expPosition);
        String expFocus = exp.focus();
        String addition = "X";
        test.addToFront(addition);
        exp.addToFront(addition);

        /*
         * Call method under test
         */
        int position = test.position();

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

        assertEquals(expPosition + 1, position);
        assertEquals(expFocus, test.focus());
    }

    @Test
    public void positionTest_afterMoveToFront() {
        /*
         * Set up variables
         */
        int position = 3;
        LinkedList<String> test = this.createFromArgsTest(position, "a", "b",
                "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
        exp.moveToPosition(0);
        String expFocus = exp.focus();
        test.moveToFront();

        /*
         * Call method under test
         */
        position = test.position();

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

        assertEquals(0, position);
        assertEquals(expFocus, test.focus());
    }

    @Test
    public void positionTest_afterMoveToFrontAtFront() {
        /*
         * Set up variables
         */
        int position = 0;
        LinkedList<String> test = this.createFromArgsTest(position, "a", "b",
                "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
        exp.moveToPosition(position);
        String expFocus = exp.focus();
        test.moveToFront();

        /*
         * Call method under test
         */
        position = test.position();

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

        assertEquals(0, position);
        assertEquals(expFocus, test.focus());
    }

    @Test
    public void positionTest_afterMoveToFrontAtEnd() {
        /*
         * Set up variables
         */
        int position = 6;
        LinkedList<String> test = this.createFromArgsTest(position, "a", "b",
                "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
        exp.moveToPosition(0);
        String expFocus = exp.focus();
        test.moveToFront();

        /*
         * Call method under test
         */
        position = test.position();

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

        assertEquals(0, position);
        assertEquals(expFocus, test.focus());
    }

    @Test
    public void positionTest_afterMoveToRear() {
        /*
         * Set up variables
         */
        int position = 3;
        LinkedList<String> test = this.createFromArgsTest(position, "a", "b",
                "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
        test.moveToRear();
        exp.moveToPosition(6);
        String expFocus = exp.focus();

        /*
         * Call method under test
         */
        position = test.position();

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

        assertEquals(test.length() - 1, position);
        assertEquals(expFocus, test.focus());
    }

    @Test
    public void positionTest_afterMoveToRearAtFront() {
        /*
         * Set up variables
         */
        int position = 0;
        LinkedList<String> test = this.createFromArgsTest(position, "a", "b",
                "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
        exp.moveToPosition(6);
        String expFocus = exp.focus();
        test.moveToRear();

        /*
         * Call method under test
         */
        position = test.position();

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

        assertEquals(test.length() - 1, position);
        assertEquals(expFocus, test.focus());
    }

    @Test
    public void positionTest_afterMoveToRearAtEnd() {
        /*
         * Set up variables
         */
        int position = 3;
        LinkedList<String> test = this.createFromArgsTest(position, "a", "b",
                "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
        exp.moveToPosition(6);
        String expFocus = exp.focus();
        test.moveToRear();

        /*
         * Call method under test
         */
        position = test.position();

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

        assertEquals(test.length() - 1, position);
        assertEquals(expFocus, test.focus());
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
        LinkedList<String> test1 = this.createFromArgsTest(position, "a", "b",
                "c", "d", "e", "f", "g");
        LinkedList<String> test2 = this.createFromArgsTest(position, "a", "b",
                "c", "d", "e", "f", "g");
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
    public void equalsTest_routineFalse() {
        /*
         * Set up variables
         */
        int position = 3;
        LinkedList<String> test1 = this.createFromArgsTest(position, "a", "b",
                "c", "d", "e", "f", "g");
        LinkedList<String> test2 = this.createFromArgsTest(position, "a", "b",
                "c", "XYZ", "e", "f", "g");
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
        LinkedList<String> test1 = this.createFromArgsTest(position);
        LinkedList<String> test2 = this.createFromArgsTest(position);
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
    public void equalsTest_boundaryFalse() {
        /*
         * Set up variables
         */
        int position = 0;
        LinkedList<String> test1 = this.createFromArgsTest(position, "a");
        LinkedList<String> test2 = this.createFromArgsTest(position, "XYZ");
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
        LinkedList<String> test = this.createFromArgsTest(position, "a", "b",
                "c", "d", "e", "f", "g");
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
        assertEquals(exp, test);

        assertEquals(expString, testString);
    }

    @Test
    public void toStringTest_frontPosition() {
        /*
         * Set up variables
         */
        int position = 0;
        LinkedList<String> test = this.createFromArgsTest(position, "a", "b",
                "c", "d", "e", "f", "g");
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
        assertEquals(exp, test);

        assertEquals(expString, testString);
        assertEquals(position, test.position());
    }

    @Test
    public void toStringTest_empty() {
        /*
         * Set up variables
         */
        LinkedList<String> test = this.createFromArgsTest();
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
        assertEquals(exp, test);

        assertEquals(expString, testString);
        assertEquals(-1, test.position());
    }

    @Test
    public void toStringTest_singleEntry() {
        /*
         * Set up variables
         */
        int position = 0;
        LinkedList<String> test = this.createFromArgsTest(position, "a");
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
        assertEquals(exp, test);

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
        LinkedList<String> test = this.createFromArgsTest(position, "a", "b",
                "c", "d", "e", "f", "g");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f", "g");
        String testFront;
        String expFront;

        /*
         * Call method under test
         */
        testFront = test.removeFront();
        expFront = exp.removeFront();

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

        assertEquals(expFront, testFront);
        assertEquals(position - 1, test.position());
    }

    @Test
    public void removeFrontTest_boundary() {
        /*
         * Set up variables
         */
        int position = 0;
        LinkedList<String> test = this.createFromArgsTest(position, "a");
        LinkedList<String> exp = this.createFromArgsRef("a");
        String testFront;
        String expFront;

        /*
         * Call method under test
         */
        testFront = test.removeFront();
        expFront = exp.removeFront();

        /*
         * Compare contents of lists
         */
        assertEquals(exp, test);

        assertEquals(expFront, testFront);
        assertEquals(position, test.position());
    }
}
