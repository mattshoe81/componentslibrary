package stacktest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.stack.Stack;

public abstract class StackTest {
    protected abstract Stack<String> constructorTest();

    protected abstract Stack<String> constructorRef();

    private Stack<String> createFromArgsTest(String... args) {
        Stack<String> stack = this.constructorTest();
        for (String arg : args) {
            stack.push(arg);
        }
        stack.flip();

        return stack;
    }

    private Stack<String> createFromArgsRef(String... args) {
        Stack<String> stack = this.constructorRef();
        for (String arg : args) {
            stack.push(arg);
        }
        stack.flip();

        return stack;
    }

    @Test
    public void pushTest_routine() {
        Stack<String> test = this.createFromArgsTest("a", "b", "c", "d", "e",
                "f", "g");
        Stack<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e", "f",
                "g");
        String push = "X";

        test.push(push);
        exp.push(push);

        assertEquals(exp, test);
    }

    @Test
    public void pushTest_boundary() {
        Stack<String> test = this.createFromArgsTest();
        Stack<String> exp = this.createFromArgsRef();
        String push = "X";

        test.push(push);
        exp.push(push);

        assertEquals(exp, test);
    }

    @Test
    public void pushTest_singlEntry() {
        Stack<String> test = this.createFromArgsTest("a");
        Stack<String> exp = this.createFromArgsRef("a");
        String push = "X";

        test.push(push);
        exp.push(push);

        assertEquals(exp, test);
    }

    /***************************************************************************
     * pop tests
     */
    @Test
    public void popTest_routine() {
        Stack<String> test = this.createFromArgsTest("a", "b", "c", "d", "e",
                "f", "g");
        Stack<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e", "f",
                "g");
        String popTest;
        String popExp;

        popTest = test.pop();
        popExp = exp.pop();

        assertEquals(exp, test);
        assertEquals(popExp, popTest);
    }

    @Test
    public void popTest_toEmpty() {
        Stack<String> test = this.createFromArgsTest("a");
        Stack<String> exp = this.createFromArgsRef("a");
        String popTest;
        String popExp;

        popTest = test.pop();
        popExp = exp.pop();

        assertEquals(exp, test);
        assertEquals(popExp, popTest);
    }

    @Test
    public void popTest_toSingle() {
        Stack<String> test = this.createFromArgsTest("a");
        Stack<String> exp = this.createFromArgsRef("a");
        String popTest;
        String popExp;

        popTest = test.pop();
        popExp = exp.pop();

        assertEquals(exp, test);
        assertEquals(popExp, popTest);
    }

    /***************************************************************************
     * size tests
     */
    @Test
    public void sizeTest_routine() {
        Stack<String> test = this.createFromArgsTest("a", "b", "c", "d", "e",
                "f", "g");
        Stack<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e", "f",
                "g");
        int testSize;
        int expSize;

        testSize = test.size();
        expSize = exp.size();

        assertEquals(exp, test);
        assertEquals(expSize, testSize);
    }

    @Test
    public void sizeTest_boundary() {
        Stack<String> test = this.createFromArgsTest();
        Stack<String> exp = this.createFromArgsRef();
        int testSize;
        int expSize;

        testSize = test.size();
        expSize = exp.size();

        assertEquals(exp, test);
        assertEquals(expSize, testSize);
    }

    /***************************************************************************
     * flip tests
     */
    @Test
    public void flipTest_routine() {
        Stack<String> test = this.createFromArgsTest("a", "b", "c");
        Stack<String> exp = this.createFromArgsRef("c", "b", "a");

        test.flip();

        assertEquals(exp, test);
    }

    @Test
    public void flipTest_boundary() {
        Stack<String> test = this.createFromArgsTest();
        Stack<String> exp = this.createFromArgsRef();

        test.flip();

        assertEquals(exp, test);
    }

    @Test
    public void flipTest_nonTrivial() {
        Stack<String> test = this.createFromArgsTest("a", "b", "c", "d", "e",
                "f", "g");
        Stack<String> exp = this.createFromArgsRef("g", "f", "e", "d", "c", "b",
                "a");

        test.flip();

        assertEquals(exp, test);
    }

    @Test
    public void hashCodeTest_routine() {
        Stack<String> test = this.createFromArgsTest("a", "b", "c", "d", "e",
                "f", "g");
        Stack<String> exp = this.createFromArgsRef("g", "f", "e", "d", "c", "b",
                "a");

        int hashCode = test.hashCode();

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
