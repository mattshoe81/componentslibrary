/**
 *
 */
package components.queue;

import java.util.Iterator;

import components.linkedlist.DoublyLinkedList;

/**
 * An implementation of a Queue layered on the DoublyLinkedList component.
 *
 * @author Matthew Shoemaker
 *
 * @param <T>
 *            Generic type of this
 *
 * @correspondence this = [entries($this.rep) in their natural order]
 *
 */
public class QueueDL<T> extends QueueSecondary<T> {

    DoublyLinkedList<T> rep;

    private void createNewRep() {
        this.rep = new DoublyLinkedList<>();
    }

    public QueueDL() {
        this.createNewRep();
    }

    @Override
    public void enqueue(T entry) {
        this.rep.add(entry);
    }

    @Override
    public T dequeue() {
        T front = this.rep.removeFront();
        return front;
    }

    @Override
    public int length() {
        return this.rep.length();
    }

    @Override
    public T front() {
        this.rep.moveToFront();
        T front = this.rep.focus();
        return front;
    }

    @Override
    public T replaceFront(T entry) {
        T front = this.rep.removeFront();
        this.rep.addToFront(entry);
        this.rep.moveToFront();
        return front;
    }

    @Override
    public void clear() {
        this.createNewRep();
    }

    @Override
    public void transferFrom(Queue<T> source) {
        QueueDL<T> localSource = (QueueDL<T>) source;
        this.rep = localSource.rep;
        localSource.clear();
    }

    @SuppressWarnings("unchecked")
    @Override
    public QueueDL<T> newInstance() {
        try {
            return this.getClass().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public Iterator<T> iterator() {

        return this.rep.iterator();
    }

}
