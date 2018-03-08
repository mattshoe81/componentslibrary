package components.queue;

import java.util.Iterator;

/**
 * An implementation of a Queue layered on a java.util.LinkedList.
 *
 * @author Matthew Shoemaker
 *
 * @param <T>
 *            Generic type of this
 *
 * @correspondence this = [entries($this.rep) in their natural order]
 * 
 */
public class Queue1L<T> extends QueueSecondary<T> {

    java.util.LinkedList<T> rep;

    private void createNewRep() {
        this.rep = new java.util.LinkedList<T>();
    }

    public Queue1L() {
        this.createNewRep();
    }

    @Override
    public void enqueue(T entry) {
        this.rep.add(entry);

    }

    @Override
    public T dequeue() {
        return this.rep.removeFirst();
    }

    @Override
    public int length() {
        return this.rep.size();
    }

    @Override
    public T front() {
        return this.rep.peekFirst();
    }

    @Override
    public T replaceFront(T entry) {
        T front = this.rep.removeFirst();
        this.rep.addFirst(entry);
        return front;
    }

    @Override
    public void clear() {
        this.createNewRep();

    }

    @Override
    public void transferFrom(Queue<T> source) {
        Queue1L<T> localSource = (Queue1L<T>) source;
        this.rep = localSource.rep;
        localSource.clear();

    }

    @SuppressWarnings("unchecked")
    @Override
    public Queue<T> newInstance() {
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

//
//
//
//
//
//
//
//
//
//
//
//
//
//
