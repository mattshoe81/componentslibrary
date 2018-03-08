package sequencetest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.sequence.Sequence;

public abstract class SequenceTest {
    protected abstract Sequence<String> constructorTest();

    protected abstract Sequence<String> constructorRef();

    private Sequence<String> createFromArgsTest(String... args) {
        Sequence<String> seq = this.constructorTest();
        for (String arg : args) {
            seq.append(arg);
        }

        return seq;
    }

    private Sequence<String> createFromArgsRef(String... args) {
        Sequence<String> seq = this.constructorRef();
        for (String arg : args) {
            seq.append(arg);
        }

        return seq;
    }

    @Test
    public void addTest_routine() {
        Sequence<String> test = this.createFromArgsTest("a", "b", "c", "d", "e",
                "f");
        Sequence<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f");
        int pos = 3;
        String entry = "x";

        test.add(pos, entry);
        exp.add(pos, entry);

        assertEquals(exp, test);
    }

    @Test
    public void addTest_toFrontNonEmpty() {
        Sequence<String> test = this.createFromArgsTest("a", "b", "c", "d", "e",
                "f");
        Sequence<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f");
        int pos = 0;
        String entry = "x";

        test.add(pos, entry);
        exp.add(pos, entry);

        assertEquals(exp, test);
    }

    @Test
    public void addTest_toEndNonEmpty() {
        Sequence<String> test = this.createFromArgsTest("a", "b", "c", "d", "e",
                "f");
        Sequence<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f");
        int pos = 6;
        String entry = "x";

        test.add(pos, entry);
        exp.add(pos, entry);

        assertEquals(exp, test);
    }

    @Test
    public void addTest_boundary() {
        Sequence<String> test = this.createFromArgsTest();
        Sequence<String> exp = this.createFromArgsRef();
        int pos = 0;
        String entry = "x";

        test.add(pos, entry);
        exp.add(pos, entry);

        assertEquals(exp, test);
    }

    @Test
    public void addTest_toFrontSingleEntry() {
        Sequence<String> test = this.createFromArgsTest("a");
        Sequence<String> exp = this.createFromArgsRef("a");
        int pos = 0;
        String entry = "x";

        test.add(pos, entry);
        exp.add(pos, entry);

        assertEquals(exp, test);
    }

    @Test
    public void addTest_toEndSingleEntry() {
        Sequence<String> test = this.createFromArgsTest("a");
        Sequence<String> exp = this.createFromArgsRef("a");
        int pos = 1;
        String entry = "x";

        test.add(pos, entry);
        exp.add(pos, entry);

        assertEquals(exp, test);
    }

    @Test
    public void addTest_beforeEndNonEmpty() {
        Sequence<String> test = this.createFromArgsTest("a", "b", "c", "d", "e",
                "f");
        Sequence<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f");
        int pos = 5;
        String entry = "x";

        test.add(pos, entry);
        exp.add(pos, entry);

        assertEquals(exp, test);
    }

    /***************************************************************************
     * remove tests
     */
    @Test
    public void removeTest_routine() {
        Sequence<String> test = this.createFromArgsTest("a", "b", "c", "d", "e",
                "f");
        Sequence<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f");
        int pos = 3;
        String entryTest;
        String entryExp;

        entryTest = test.remove(pos);
        entryExp = exp.remove(pos);

        assertEquals(exp, test);
        assertEquals(entryExp, entryTest);
    }

    @Test
    public void removeTest_toEmpty() {
        Sequence<String> test = this.createFromArgsTest("a");
        Sequence<String> exp = this.createFromArgsRef("a");
        int pos = 0;
        String entryTest;
        String entryExp;

        entryTest = test.remove(pos);
        entryExp = exp.remove(pos);

        assertEquals(exp, test);
        assertEquals(entryExp, entryTest);
    }

    @Test
    public void removeTest_front() {
        Sequence<String> test = this.createFromArgsTest("a", "b", "c", "d", "e",
                "f");
        Sequence<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f");
        int pos = 0;
        String entryTest;
        String entryExp;

        entryTest = test.remove(pos);
        entryExp = exp.remove(pos);

        assertEquals(exp, test);
        assertEquals(entryExp, entryTest);
    }

    @Test
    public void removeTest_end() {
        Sequence<String> test = this.createFromArgsTest("a", "b", "c", "d", "e",
                "f");
        Sequence<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f");
        int pos = 5;
        String entryTest;
        String entryExp;

        entryTest = test.remove(pos);
        entryExp = exp.remove(pos);

        assertEquals(exp, test);
        assertEquals(entryExp, entryTest);
    }

    /****************************************************************************
     * length tests
     */
    @Test
    public void lengthTest_routine() {
        Sequence<String> test = this.createFromArgsTest("a", "b", "c", "d", "e",
                "f");
        Sequence<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f");
        int lengthTest;
        int lengthExp;

        lengthTest = test.length();
        lengthExp = exp.length();

        assertEquals(exp, test);
        assertEquals(lengthExp, lengthTest);
    }

    @Test
    public void lengthTest_boundary() {
        Sequence<String> test = this.createFromArgsTest();
        Sequence<String> exp = this.createFromArgsRef();
        int lengthTest;
        int lengthExp;

        lengthTest = test.length();
        lengthExp = exp.length();

        assertEquals(exp, test);
        assertEquals(lengthExp, lengthTest);
    }

    @Test
    public void lengthTest_single() {
        Sequence<String> test = this.createFromArgsTest("a");
        Sequence<String> exp = this.createFromArgsRef("a");
        int lengthTest;
        int lengthExp;

        lengthTest = test.length();
        lengthExp = exp.length();

        assertEquals(exp, test);
        assertEquals(lengthExp, lengthTest);
    }

    /***************************************************************************
     * append(sequence) tests
     */
    @Test
    public void appendSequenceTest_routine() {
        Sequence<String> test = this.createFromArgsTest("a", "b", "c", "d", "e",
                "f");
        Sequence<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f");
        Sequence<String> testAppend = this.createFromArgsTest("t", "u", "v",
                "w", "x", "y", "z");
        Sequence<String> expAppend = this.createFromArgsRef("t", "u", "v", "w",
                "x", "y", "z");
        Sequence<String> emptySequence = this.createFromArgsRef();

        test.append(testAppend);
        exp.append(expAppend);

        assertEquals(exp, test);
        assertEquals(emptySequence, testAppend);
        assertEquals(emptySequence, expAppend);
    }

    @Test
    public void appendSequenceTest_boundary() {
        Sequence<String> test = this.createFromArgsTest();
        Sequence<String> exp = this.createFromArgsRef();
        Sequence<String> testAppend = this.createFromArgsTest();
        Sequence<String> expAppend = this.createFromArgsRef();
        Sequence<String> emptySequence = this.createFromArgsRef();

        test.append(testAppend);
        exp.append(expAppend);

        assertEquals(exp, test);
        assertEquals(emptySequence, testAppend);
        assertEquals(emptySequence, expAppend);
    }

    @Test
    public void appendSequenceTest_empty() {
        Sequence<String> test = this.createFromArgsTest("a", "b", "c", "d", "e",
                "f");
        Sequence<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f");
        Sequence<String> testAppend = this.createFromArgsTest();
        Sequence<String> expAppend = this.createFromArgsRef();
        Sequence<String> emptySequence = this.createFromArgsRef();

        test.append(testAppend);
        exp.append(expAppend);

        assertEquals(exp, test);
        assertEquals(emptySequence, testAppend);
        assertEquals(emptySequence, expAppend);
    }

    @Test
    public void appendSequenceTest_toEmpty() {
        Sequence<String> test = this.createFromArgsTest();
        Sequence<String> exp = this.createFromArgsRef();
        Sequence<String> testAppend = this.createFromArgsTest("t", "u", "v",
                "w", "x", "y", "z");
        Sequence<String> expAppend = this.createFromArgsRef("t", "u", "v", "w",
                "x", "y", "z");
        Sequence<String> emptySequence = this.createFromArgsRef();

        test.append(testAppend);
        exp.append(expAppend);

        assertEquals(exp, test);
        assertEquals(emptySequence, testAppend);
        assertEquals(emptySequence, expAppend);
    }

    /***************************************************************************
     * append(T) tests
     */
    @Test
    public void appendTest_routine() {
        Sequence<String> test = this.createFromArgsTest("a", "b", "c", "d", "e",
                "f");
        Sequence<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f");
        String testAppend = "x";

        test.append(testAppend);
        exp.append(testAppend);

        assertEquals(exp, test);
    }

    @Test
    public void appendTest_toEmpty() {
        Sequence<String> test = this.createFromArgsTest();
        Sequence<String> exp = this.createFromArgsRef();
        String testAppend = "x";

        test.append(testAppend);
        exp.append(testAppend);

        assertEquals(exp, test);
    }

    /***************************************************************************
     * entry tests
     */
    @Test
    public void entryTest_routine() {
        Sequence<String> test = this.createFromArgsTest("a", "b", "c", "d", "e",
                "f");
        Sequence<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f");
        int pos = 3;
        String testEntry;
        String expEntry;

        testEntry = test.entry(pos);
        expEntry = exp.entry(pos);

        assertEquals(exp, test);
        assertEquals(expEntry, testEntry);
    }

    @Test
    public void entryTest_boundary() {
        Sequence<String> test = this.createFromArgsTest("a");
        Sequence<String> exp = this.createFromArgsRef("a");
        int pos = 0;
        String testEntry;
        String expEntry;

        testEntry = test.entry(pos);
        expEntry = exp.entry(pos);

        assertEquals(exp, test);
        assertEquals(expEntry, testEntry);
    }

    @Test
    public void entryTest_front() {
        Sequence<String> test = this.createFromArgsTest("a", "b", "c", "d", "e",
                "f");
        Sequence<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f");
        int pos = 0;
        String testEntry;
        String expEntry;

        testEntry = test.entry(pos);
        expEntry = exp.entry(pos);

        assertEquals(exp, test);
        assertEquals(expEntry, testEntry);
    }

    @Test
    public void entryTest_end() {
        Sequence<String> test = this.createFromArgsTest("a", "b", "c", "d", "e",
                "f");
        Sequence<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f");
        int pos = 5;
        String testEntry;
        String expEntry;

        testEntry = test.entry(pos);
        expEntry = exp.entry(pos);

        assertEquals(exp, test);
        assertEquals(expEntry, testEntry);
    }

    /***************************************************************************
     * replaceEntry tests
     */
    @Test
    public void replaceEntryTest_routine() {
        Sequence<String> test = this.createFromArgsTest("a", "b", "c", "d", "e",
                "f");
        Sequence<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f");
        int pos = 3;
        String replacement = "X";

        test.replaceEntry(pos, replacement);
        exp.replaceEntry(pos, replacement);

        assertEquals(exp, test);
    }

    @Test
    public void replaceEntryTest_boundary() {
        Sequence<String> test = this.createFromArgsTest("a");
        Sequence<String> exp = this.createFromArgsRef("a");
        int pos = 0;
        String replacement = "X";

        test.replaceEntry(pos, replacement);
        exp.replaceEntry(pos, replacement);

        assertEquals(exp, test);
    }

    @Test
    public void replaceEntryTest_front() {
        Sequence<String> test = this.createFromArgsTest("a", "b", "c", "d", "e",
                "f");
        Sequence<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f");
        int pos = 3;
        String replacement = "X";

        test.replaceEntry(pos, replacement);
        exp.replaceEntry(pos, replacement);

        assertEquals(exp, test);
    }

    @Test
    public void replaceEntryTest_end() {
        Sequence<String> test = this.createFromArgsTest("a", "b", "c", "d", "e",
                "f");
        Sequence<String> exp = this.createFromArgsRef("a", "b", "c", "d", "e",
                "f");
        int pos = 3;
        String replacement = "X";

        test.replaceEntry(pos, replacement);
        exp.replaceEntry(pos, replacement);

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
