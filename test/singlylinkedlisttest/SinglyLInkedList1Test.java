package singlylinkedlisttest;

import linkedlist.SinglyLinkedList;
import linkedlist.SinglyLinkedList1;

public class SinglyLinkedList1Test extends SinglyLinkedListTest {

    @Override
    protected SinglyLinkedList<String> constructorTest() {
        return new SinglyLinkedList1<String>();
    }

}
