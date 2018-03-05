/**
 *
 */
package linkedlist;

import java.lang.reflect.Constructor;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A non-layered implementation of a singly-linked list using a single sentinel
 * {@code Node}.
 *
 * @convention <pre>
 *      [$this.preFront is not null]
 *      [$this.preFocus is not null]
 *      [$this.rear is not null]
 *      [$this.length >= 0]
 *      [$this.position < length]
 *      [$this.position >= 0]
 *      [$this.position = 0 if $this.length = 0]
 *      [$this.position = distance of this.focus from $this.preFront]
 *      [$this.preFocus points to the node just before the
 *          node containing the data that is in focus to
 *          the client if ($this.length > 0) and points to
 *          $this.preFront if $this.length = 0]
 *      [$this.preFront points to the sentinel node]
 *      [$this.rear points to the last node of $this]
 *      [$this.length = total number of nodes minus 1 for the sentinel node]
 *  </pre>
 * @correspondence <pre>
 *      this = [data in nodes from $this.preFront.next through $this.rear]
 *      focus = [this.preFocus.next]
 *  </pre>
 *
 * @author Matthew Shoemaker
 *
 * @param <T>
 *            the generic type of {@code this}
 *
 */
public class SinglyLinkedList<T> extends LinkedListSecondary<T> {

    /*
     * Private Members
     */
    /**
     * Node class for singly linked list.
     *
     */
    private class Node {
        /**
         * The data stored in the node.
         */
        T data;
        /**
         * The reference to the next node in the list. Null if final node.
         */
        Node next;

        /**
         * No-arg constructor initializes data and next to null.
         */
        Node() {
            this.data = null;
            this.next = null;
        }

        /**
         * Constructor that accept the data value for the node.
         *
         * @param data
         *            this.data
         */
        Node(T data) {
            this.data = data;
        }
    }

    /**
     * Sentinel node for {@code this}.
     */
    private Node preFront;
    /**
     * stores the reference to the value just before this.focus.
     *
     * [this.focus = $this.preFocus.next]
     */
    private Node preFocus;
    /**
     * Reference to the final entry in this.
     */
    private Node rear;
    /**
     * Number of nodes, besides the sentinel node, in this.
     */
    private int length;
    /**
     * the distance of the focus from {@code this.preFront}.
     */
    private int position;

    /**
     * Single point of control over change for the construction of a new data
     * representation. Initializes this to its initial value.
     */
    private void createNewRep() {
        this.preFront = new Node();
        this.preFocus = this.preFront;
        this.rear = this.preFront;
        this.length = 0;
        this.position = 0;
    }

    /**
     * Iterator class for {@code this}.
     *
     */
    private class SinglyLinkedList1Iterator implements Iterator<T> {

        /**
         * Reference to the current value in the iteration.
         */
        private Node cursor;

        /**
         * Constructor to initialize the cursor to the front of this list.
         */
        SinglyLinkedList1Iterator() {
            this.cursor = SinglyLinkedList.this.preFront;
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
    /**
     * No-arg constructor for {@code this}.
     */
    public SinglyLinkedList() {
        this.createNewRep();
    }

    /*
     * *************************************************************************
     * Kernel Methods
     * *************************************************************************
     */
    @Override
    public void add(T entry) {
        assert entry != null : "Violation of: entry is not null";

        this.length++;
        Node newNode = new Node(entry);
        newNode.next = null;
        this.rear.next = newNode;
        this.rear = newNode;
    }

    @Override
    public void addToFront(T entry) {

        Node newFront = new Node(entry);
        newFront.next = this.preFront.next;
        this.preFront.next = newFront;
        this.length++;
    }

    @Override
    public T remove() {
        assert this.length > 0 : "Violation of: 0 <= this.length";

        T focusData = this.preFocus.next.data;
        Node newNext = this.preFocus.next.next;
        if (newNext != null) {
            this.preFocus.next = newNext;
        } else {
            this.preFocus = this.preFront;
        }

        if (this.position == this.length - 1) {
            this.position--;
        }

        this.length--;

        return focusData;
    }

    @Override
    public void advance() {
        assert this.position != this.length
                - 1 : "Violation of: #this.focus is not the last entry in the list";

        Node next = this.preFocus.next;
        this.preFocus = next;
        this.position++;
    }

    @Override
    public void retreat() {
        assert this.position() > 0 : "Violation of: this.position > 0";

        int originalPosition = this.position;
        Node cursor = this.preFront;
        for (int k = 0; k < originalPosition; k++) {
            Node next = cursor.next;
            cursor = next;
        }
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
    public void insert(T entry) {
        Node newNode = new Node(entry);
        Node focus = this.preFocus.next;
        newNode.next = focus.next;
        focus.next = newNode;
        this.length++;
    }

    @Override
    public T focus() {
        assert this.length > 0 : "Violation of: 0 <= this.length";

        Node focus = this.preFocus.next;
        T focusData = focus.data;
        return focusData;
    }

    @Override
    public void moveToRear() {
        assert this.length > 0 : "Violation of: 0 <= this.length";

        while (this.preFocus.next != this.rear) {
            this.preFocus = this.preFocus.next;
        }
        this.position = this.length - 1;
    }

    @Override
    public int position() {
        assert this.length > 0 : "Violation of: 0 <= this.length";

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
    public void transferFrom(LinkedList<T> source) {
        SinglyLinkedList<T> localSource = (SinglyLinkedList<T>) source;
        this.preFront = localSource.preFront;
        this.preFocus = localSource.preFocus;
        this.rear = localSource.rear;
        this.length = localSource.length;
    }

    @SuppressWarnings("unchecked")
    @Override
    public SinglyLinkedList<T> newInstance() {
        try {
            Constructor<?> c = this.getClass().getConstructor(Comparator.class);
            return (SinglyLinkedList<T>) c.newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

}
