package singlylinkedlisttest;

import linkedlist.SinglyLinkedList;

public abstract class SinglyLinkedLIstTest {

    protected abstract SinglyLinkedList<String> constructorTest();

    private SinglyLinkedList<String> createFromArgs(String... args) {
        SinglyLinkedList<String> list = this.constructorTest();
        for (String arg : args) {
            list.add(arg);
        }

        return list;
    }

}
