package queuetest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.queue.Queue;

public abstract class QueueTest {

    protected abstract Queue<String> constructorTest();

    protected abstract Queue<String> constructorRef();

    /*
     * ************************************************************************
     * Single point control of change
     * ************************************************************************
     */

    private Queue<String> createFromArgsTest(String... args) {
        Queue<String> q = this.constructorTest();
        for (String arg : args) {
            q.enqueue(arg);
        }

        return q;
    }

    /*
     * ***********************************************************************
     * Helper methods
     * ***********************************************************************
     */

    private Queue<String> createFromArgsRef(String... args) {
        Queue<String> q = this.constructorRef();
        for (String arg : args) {
            q.enqueue(arg);
        }

        return q;
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
    public void enqueueTest_routine() {
        /*
         * Set up variables
         */
        Queue<String> test = this.createFromArgsTest("a", "b", "c");
        Queue<String> exp = this.createFromArgsRef("a", "b", "c");
        String entry = "d";

        /*
         * Call method under test
         */
        test.enqueue(entry);
        exp.enqueue(entry);

        /*
         * Compare contents
         */
        assertEquals(exp, test);
    }

    @Test
    public void enqueueTest_boundary() {
        /*
         * Set up variables
         */
        Queue<String> test = this.createFromArgsTest();
        Queue<String> exp = this.createFromArgsRef();
        String entry = "d";

        /*
         * Call method under test
         */
        test.enqueue(entry);
        exp.enqueue(entry);

        /*
         * Compare contents
         */
        assertEquals(exp, test);
    }

    @Test
    public void enqueueTest_singleEntry() {
        /*
         * Set up variables
         */
        Queue<String> test = this.createFromArgsTest("a");
        Queue<String> exp = this.createFromArgsRef("a");
        String entry = "d";

        /*
         * Call method under test
         */
        test.enqueue(entry);
        exp.enqueue(entry);

        /*
         * Compare contents
         */
        assertEquals(exp, test);
    }

    /***************************************************************************
     * dequeue tests
     */
    @Test
    public void dequeueTest_routine() {
        /*
         * Set up variables
         */
        Queue<String> test = this.createFromArgsTest("a", "b", "c");
        Queue<String> exp = this.createFromArgsRef("a", "b", "c");
        String dqTest;
        String dqExp;

        /*
         * Call method under test
         */
        dqTest = test.dequeue();
        dqExp = exp.dequeue();

        /*
         * Compare contents
         */
        assertEquals(exp, test);
        assertEquals(dqExp, dqTest);
    }

    @Test
    public void dequeueTest_boundary() {
        /*
         * Set up variables
         */
        Queue<String> test = this.createFromArgsTest("a");
        Queue<String> exp = this.createFromArgsRef("a");
        String dqTest;
        String dqExp;

        /*
         * Call method under test
         */
        dqTest = test.dequeue();
        dqExp = exp.dequeue();

        /*
         * Compare contents
         */
        assertEquals(exp, test);
        assertEquals(dqExp, dqTest);
    }

    /***************************************************************************
     * length tests
     */
    @Test
    public void lengthTest_routine() {
        /*
         * Set up variables
         */
        Queue<String> test = this.createFromArgsTest("a", "b", "c");
        Queue<String> exp = this.createFromArgsRef("a", "b", "c");
        int expLength = 3;
        int length;

        /*
         * Call method under test
         */
        length = test.length();

        /*
         * Compare contents
         */
        assertEquals(exp, test);
        assertEquals(expLength, length);
    }

    @Test
    public void lengthTest_boundary() {
        /*
         * Set up variables
         */
        Queue<String> test = this.createFromArgsTest();
        Queue<String> exp = this.createFromArgsRef();
        int expLength = 0;
        int length;

        /*
         * Call method under test
         */
        length = test.length();

        /*
         * Compare contents
         */
        assertEquals(exp, test);
        assertEquals(expLength, length);
    }

    /***************************************************************************
     * flip tests
     */
    @Test
    public void flipTest_routine() {
        /*
         * Set up variables
         */
        Queue<String> test = this.createFromArgsTest("a", "b", "c");
        Queue<String> exp = this.createFromArgsRef("c", "b", "a");

        /*
         * Call method under test
         */
        test.flip();

        /*
         * Compare contents
         */
        assertEquals(exp, test);
    }

    @Test
    public void flipTest_boundary() {
        /*
         * Set up variables
         */
        Queue<String> test = this.createFromArgsTest();
        Queue<String> exp = this.createFromArgsRef();

        /*
         * Call method under test
         */
        test.flip();

        /*
         * Compare contents
         */
        assertEquals(exp, test);
    }

    @Test
    public void flipTest_boundaryPlusOne() {
        /*
         * Set up variables
         */
        Queue<String> test = this.createFromArgsTest("a");
        Queue<String> exp = this.createFromArgsRef("a");

        /*
         * Call method under test
         */
        test.flip();

        /*
         * Compare contents
         */
        assertEquals(exp, test);
    }

    @Test
    public void flipTest_longOdd() {
        /*
         * Set up variables
         */
        Queue<String> test = this.createFromArgsTest("a", "b", "c", "d", "e",
                "f", "g", "h", "i");
        Queue<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e", "f",
                "g", "h", "i");

        /*
         * Call method under test
         */
        test.flip();
        exp.flip();

        /*
         * Compare contents
         */
        assertEquals(exp, test);
    }

    @Test
    public void flipTest_longeven() {
        /*
         * Set up variables
         */
        Queue<String> test = this.createFromArgsTest("a", "b", "c", "d", "e",
                "f", "g", "h", "i", "j");
        Queue<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e", "f",
                "g", "h", "i", "j");

        /*
         * Call method under test
         */
        test.flip();
        exp.flip();

        /*
         * Compare contents
         */
        assertEquals(exp, test);
    }

}

//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
