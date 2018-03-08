package linkedlisttest;

import components.linkedlist.DoublyLinkedList;
import components.linkedlist.LinkedList;
import components.linkedlist.LinkedList1L;

public class DoublyLinkedListTest extends LinkedListTest {

    @Override
    protected LinkedList<String> constructorTest() {
        return new DoublyLinkedList<String>();
    }

    @Override
    protected LinkedList<String> constructorRef() {
        return new LinkedList1L<String>();
    }

}
