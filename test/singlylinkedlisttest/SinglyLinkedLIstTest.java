package singlylinkedlisttest;

import static org.junit.Assert.assertArrayEquals;

import java.util.LinkedList;

import org.junit.Test;

import linkedlist.SinglyLinkedList;

public abstract class SinglyLinkedListTest {

    protected abstract SinglyLinkedList<String> constructorTest();

    /*
     * ************************************************************************
     * Single point control of change
     * ************************************************************************
     */

    private SinglyLinkedList<String> createFromArgsTest(String... args) {
        SinglyLinkedList<String> list = this.constructorTest();
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

    private String[] getContents(SinglyLinkedList<String> list) {
        String[] contents = new String[list.length()];
        list.moveToFront();
        if (list.length() > 0) {
            contents[0] = list.focus();
            for (int k = 1; k < list.length(); k++) {
                list.advance();
                contents[k] = list.focus();
            }
        }

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
     * ***************************Test Cases***********************************
     * ************************************************************************
     */

    /*
     * add Method Test Cases
     */
    @Test
    public void addTest_Routine() {
        SinglyLinkedList<String> test = this.createFromArgsTest("a", "b", "c");
        LinkedList<String> exp = this.createFromArgsRef("a", "b", "c");

        String[] testContents = this.getContents(test);
        String[] expContents = this.getContents(exp);

        assertArrayEquals(expContents, testContents);
    }

}
