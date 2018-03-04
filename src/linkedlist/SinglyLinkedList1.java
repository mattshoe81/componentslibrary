/**
 *
 */
package linkedlist;

import java.lang.reflect.Constructor;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Matthew Shoemaker
 *
 */
public class SinglyLinkedList1<T> extends SinglyLinkedListSecondary<T> {

    /*
     * Private Members
     */
    private class Node {
        T data;
        Node next;

        public Node() {
            this.data = null;
            this.next = null;
        }

        public Node(T data) {
            this.data = data;
        }
    }

    private Node preFront;
    private Node preFocus;
    private Node rear;
    private int length;
    private int position;

    private void createNewRep() {
        this.preFront = new Node();
        this.preFocus = this.preFront;
        this.rear = this.preFront;
        this.length = 0;
        this.position = 0;
    }

    private class SinglyLinkedList1Iterator implements Iterator<T> {

        Node cursor;

        public SinglyLinkedList1Iterator() {
            this.cursor = SinglyLinkedList1.this.preFront;
        }

        @Override
        public boolean hasNext() {
            return this.cursor.next != null;
        }

        @Override
        public T next() {
            if (this.hasNext()) {
                Node nextNode = this.cursor.next;
                this.cursor = nextNode;
                return this.cursor.data;
            }
            throw new NoSuchElementException();
        }
    }

    /*
     * *************************************************************************
     * Constructor
     * *************************************************************************
     */
    public SinglyLinkedList1() {
        this.createNewRep();
    }

    /*
     * *************************************************************************
     * Kernel Methods
     * *************************************************************************
     */
    @Override
    public void add(T element) {
        this.length++;
        Node newNode = new Node(element);
        newNode.next = null;
        this.rear.next = newNode;
        this.rear = newNode;
    }

    @Override
    public void addToFront(T element) {
        Node newFront = new Node(element);
        newFront.next = this.preFront.next;
        this.preFront.next = newFront;
        this.length++;
    }

    @Override
    public T remove() {
        T focusData = this.preFocus.next.data;
        Node newNext = this.preFocus.next.next;
        this.preFocus.next = newNext;
        this.length--;

        return focusData;
    }

    @Override
    public void advance() {
        Node next = this.preFocus.next;
        this.preFocus = next;
        this.position++;
    }

    @Override
    public void retreat() {
        Node preFocusOriginal = this.preFocus;
        this.preFocus = this.preFront;
        while (this.preFocus.next != preFocusOriginal) {
            Node next = this.preFocus.next;
            this.preFocus = next;
        }
        this.position--;
    }

    @Override
    public void moveToFront() {
        this.preFocus = this.preFront;
        this.position = 0;
    }

    @Override
    public int length() {
        return this.length;
    }

    @Override
    public void insert(T element) {
        Node newNode = new Node(element);
        Node focus = this.preFocus.next;
        newNode.next = focus.next;
        focus.next = newNode;
        this.length++;
    }

    @Override
    public T focus() {
        Node focus = this.preFocus.next;
        T focusData = focus.data;
        return focusData;
    }

    @Override
    public void moveToRear() {
        while (this.preFocus.next != this.rear) {
            this.preFocus = this.preFocus.next;
        }
        this.position = this.length - 1;
    }

    @Override
    public int position() {
        return this.position;
    }

    @Override
    public Iterator<T> iterator() {
        return new SinglyLinkedList1Iterator();
    }

    /*
     * *************************************************************************
     * Standard Methods
     * *************************************************************************
     */
    @Override
    public void clear() {
        this.createNewRep();
    }

    @Override
    public void transferFrom(SinglyLinkedList<T> source) {
        SinglyLinkedList1<T> localSource = (SinglyLinkedList1<T>) source;
        this.preFront = localSource.preFront;
        this.preFocus = localSource.preFocus;
        this.rear = localSource.rear;
        this.length = localSource.length;
    }

    @SuppressWarnings("unchecked")
    @Override
    public SinglyLinkedList1<T> newInstance() {
        try {
            Constructor<?> c = this.getClass().getConstructor(Comparator.class);
            return (SinglyLinkedList1<T>) c.newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

}
