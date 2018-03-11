/**
 *
 */
package components.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A non-layered implementation of a singly-linked list using 2 sentinel nodes.
 *
 * @convention <pre>
 *      [$this.preFront is not null]
 *      [$this.preFocus is not null]
 *      [$this.rear is not null]
 *      [$this.length >= 0]
 *      [$this.position < length]
 *      [$this.position = -1 if $this.length = 0]
 *      [$this.position = distance of this.focus from $this.preFront]
 *      [$this.preFocus points to the node just before the
 *          node containing the label that is in focus to
 *          the client if ($this.length > 0) and points to
 *          $this.preFront if $this.length = 0]
 *      [$this.preFront points to the leading sentinel node]
 *      [$this.postRear points to the trailing sentinel node]
 *      [$this.rear points to the node directly before $this.postRear]
 *      [$this.length = total number of nodes minus 2 for the sentinel nodes]
 *  </pre>
 * @correspondence <pre>
 *      this = [label in nodes between, and not including, $this.preFront and $this.postRear]
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
         * The label stored in the node.
         */
        T data;
        /**
         * The reference to the next node in the list. Null if final node.
         */
        Node next;

        /**
         * No-arg constructor initializes label and next to null.
         */
        Node() {
            this.data = null;
            this.next = null;
        }

        /**
         * Constructor that accept the label value for the node.
         *
         * @param label
         *            this.data
         */
        Node(T data) {
            this.data = data;
        }
    }

    /**
     * Leading Sentinel node for {@code this}.
     */
    private Node preFront;

    /**
     * Trailing Sentinel node for {@code this}.
     */
    private Node postRear;
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
     * Single point of control over change for the construction of a new label
     * representation. Initializes this to its initial value.
     */
    private void createNewRep() {
        this.preFront = new Node();
        this.postRear = new Node();

        this.preFront.next = this.postRear;
        this.postRear.next = null;
        this.preFocus = this.preFront;
        this.rear = this.preFront;
        this.length = 0;
        this.position = -1;
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
            return this.cursor.next != SinglyLinkedList.this.postRear;
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
        newNode.next = this.postRear;
        this.rear.next = newNode;
        this.rear = newNode;

        if (this.length == 1) {
            this.position = 0;
        }
    }

    @Override
    public void addToFront(T entry) {

        Node newFront = new Node(entry);
        newFront.next = this.preFront.next;
        this.preFront.next = newFront;
        this.length++;

        if (this.length == 1) {
            this.position = 0;
        }
        if (this.position > 0) {
            this.position++;
        }
    }

    @Override
    public T remove() {
        assert this.length > 0 : "Violation of: 0 <= this.length";

        Node preFocus = this.preFocus;
        Node focus = this.preFocus.next;
        Node postFocus = focus.next;

        T focusData = focus.data;
        preFocus.next = postFocus;

        if (postFocus == this.postRear) {
            this.position = 0;
            this.preFocus = this.preFront;
            this.rear = preFocus;
        }

        this.length--;

        return focusData;
    }

    @Override
    public void advance() {
        assert this.position < this.length : "Violation of: #this.position < #this.length";

        Node next = this.preFocus.next;
        this.preFocus = next;
        this.position++;
    }

    @Override
    public void retreat() {
        if (this.length == 0) {
            assert this.position == -1 : "Violation of: If length = 0, then position = -1";
        } else {
            assert this
                    .position() >= 0 : "Violation of: this.position >= 0 if length > 0";
        }

        int originalPosition = this.position;
        Node cursor = this.preFront;
        for (int k = 0; k < originalPosition; k++) {
            Node next = cursor.next;
            cursor = next;
        }
        this.preFocus = cursor;
        this.position--;
    }

    @Override
    public void moveToFront() {
        assert this.length > 0 : "Violation of: this.length > 0";
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
        assert this.length > 0 : "Violation of: 0 < this.length";

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
            return this.getClass().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    /***************************************************************************
     * hashCode overridden here rather than secondary for performance purposes.
     * *************************************************************************
     */
    /**
     * Note: Opted for a more efficient implementation.
     */
    @Override
    public int hashCode() {
        int result = 0;
        int multiplier = 19;
        Node front = this.preFront;
        for (int k = 0; k < this.length() && k < 5; k++) {
            Node next = front.next;
            result += next.data.hashCode() * multiplier;
            front = next;
        }

        return result;
    }

}
