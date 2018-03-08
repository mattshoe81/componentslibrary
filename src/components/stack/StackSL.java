package components.stack;

import java.util.Iterator;

import components.linkedlist.SinglyLinkedList;

/**
 * An implementation of a stack layered on top of the component
 * SinlgyLinkedList.
 *
 * @author Matthew Shoemaker
 *
 * @param <T>
 *
 * @convention [top of stack is the first entry in $this.rep]
 *
 * @correspondence <pre>
 * this = contents($this.rep) and
 * this.top = $this.rep.entry(0)
 * </pre>
 *
 */
public class StackSL<T> extends StackSecondary<T> {

    private SinglyLinkedList<T> rep;

    private void createNewRep() {
        this.rep = new SinglyLinkedList<>();
    }

    public StackSL() {
        this.createNewRep();
    }

    @Override
    public void push(T entry) {
        this.rep.addToFront(entry);
    }

    @Override
    public T pop() {
        return this.rep.removeFront();
    }

    @Override
    public int size() {
        return this.rep.length();
    }

    @Override
    public void clear() {
        this.createNewRep();
    }

    @Override
    public Iterator<T> iterator() {
        return this.rep.iterator();
    }

    @Override
    public void transferFrom(Stack<T> source) {
        StackSL<T> localSource = (StackSL<T>) source;
        this.rep = localSource.rep;
        source.clear();

    }

    @SuppressWarnings("unchecked")
    @Override
    public StackSL<T> newInstance() {
        try {
            return this.getClass().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

}
