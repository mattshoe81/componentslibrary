package singlylinkedlisttest;

import linkedlist.LinkedList;
import linkedlist.SinglyLinkedList;

public class SinglyLinkedList1Test extends SinglyLinkedListTest {

    @Override
    protected LinkedList<String> constructorTest() {
        return new SinglyLinkedList<String>();
    }

}
