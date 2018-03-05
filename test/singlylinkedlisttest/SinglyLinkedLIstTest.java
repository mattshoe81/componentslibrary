package singlylinkedlisttest;

import linkedlist.LinkedList;
import linkedlist.SinglyLinkedList;

public class SinglyLinkedListTest extends LinkedListTest {

    @Override
    protected LinkedList<String> constructorTest() {
        return new SinglyLinkedList<String>();
    }

}
