/**
 *
 */
package components.queue;

import java.util.Collection;
import java.util.Comparator;

import components.linkedlist.DoublyLinkedList;

/**
 *
 * @author Matthew Shoemaker
 *
 */
public abstract class QueueSecondary<T> implements Queue<T> {

    @Override
    public void flip() {
        DoublyLinkedList<T> temp = new DoublyLinkedList<>();
        while (this.length() > 0) {
            T nq = this.dequeue();
            temp.add(nq);
        }

        while (temp.length() > 0) {
            T rear = temp.removeRear();
            this.enqueue(rear);
        }
    }

    @Override
    public void append(Collection<T> collection) {
        for (T entry : collection) {
            this.enqueue(entry);
        }
    }

    @Override
    public void append(Queue<T> collection) {
        for (T entry : collection) {
            this.enqueue(entry);
        }
    }

    @Override
    public void sort(Comparator<T> comparator) {

    }

    @Override
    public boolean contains(T entry) {
        boolean contains = false;
        for (T entryThis : this) {
            if (!contains) {
                contains = entryThis.equals(entry);
            }
        }

        return contains;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object o) {
        boolean equals = true;
        if (o instanceof Queue) {
            Queue<T> q = (Queue<T>) o;
            if (q.length() == this.length()) {
                for (T entryThis : this) {
                    if (equals) {
                        equals = q.contains(entryThis);
                    }
                }
            } else {
                equals = false;
            }
        } else {
            equals = false;
        }

        return equals;
    }

    @Override
    public String toString() {
        String toString = "<";
        int k = 0;
        for (T entry : this) {
            if (k == this.length() - 1) {
                toString += entry.toString();
            } else {
                toString += entry.toString() + ", ";
            }
            k++;
        }

        toString += ">";

        return toString;
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
//
//
//
//
//
//
//
//
