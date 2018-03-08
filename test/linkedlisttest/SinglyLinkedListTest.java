package linkedlisttest;

import components.linkedlist.LinkedList;
import components.linkedlist.LinkedList1L;
import components.linkedlist.SinglyLinkedList;

public class SinglyLinkedListTest extends LinkedListTest {

    @Override
    protected LinkedList<String> constructorTest() {
        return new SinglyLinkedList<String>();
    }

    @Override
    protected LinkedList<String> constructorRef() {
        return new LinkedList1L<String>();
    }

}
