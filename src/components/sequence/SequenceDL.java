package components.sequence;

import java.util.Iterator;

import components.linkedlist.DoublyLinkedList;

/**
 * An implementation of a Sequence data structure layered on the
 * DoublyLinkedList component.
 *
 * @author Matthew Shoemaker
 *
 * @param <T>
 *
 * @convention this = $this.rep
 */
public class SequenceDL<T> extends SequenceSecondary<T> {

    DoublyLinkedList<T> rep;

    private void createNewRep() {
        this.rep = new DoublyLinkedList<T>();
    }

    public SequenceDL() {
        this.createNewRep();
    }

    @Override
    public void add(int pos, T entry) {
        assert pos <= this.rep.length() : "Violation of: pos < this.length";
        assert pos >= 0 : "Violation of: pos >= 0";
        if (pos == this.rep.length()) {
            this.rep.add(entry);
        } else if (pos > 0) {
            this.rep.moveToPosition(pos - 1);
            this.rep.insert(entry);
        } else {
            this.rep.addToFront(entry);
        }

    }

    @Override
    public T remove(int pos) {
        this.rep.moveToPosition(pos);
        T remove = this.rep.remove();
        return remove;
    }

    @Override
    public int length() {
        return this.rep.length();
    }

    @Override
    public void clear() {
        this.createNewRep();
    }

    @Override
    public void transferFrom(Sequence<T> source) {
        SequenceDL<T> localSource = (SequenceDL<T>) source;
        this.rep = localSource.rep;
        source.clear();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Sequence<T> newInstance() {
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
