package components.linkedlist;

import java.util.Iterator;

public class LinkedList1L<T> extends LinkedListSecondary<T> {

    private java.util.LinkedList<T> rep;
    private int position;

    private void createNewRep() {
        this.rep = new java.util.LinkedList<>();
        this.position = -1;
    }

    public LinkedList1L() {
        this.createNewRep();
    }

    @Override
    public void add(T entry) {
        this.rep.add(entry);

        if (this.rep.size() == 1) {
            this.position = 0;
        }
    }

    @Override
    public void addToFront(T entry) {
        this.rep.addFirst(entry);

        if (this.rep.size() == 1) {
            this.position = 0;
        }
        if (this.position > 0) {
            this.position++;
        }
    }

    @Override
    public T remove() {
        T remove = this.rep.remove(this.position);
        if (this.position == this.rep.size()) {
            this.position = 0;
        }
        if (this.rep.size() == 0) {
            this.position = -1;
        }

        return remove;
    }

    @Override
    public void advance() {
        this.position++;

    }

    @Override
    public void retreat() {
        this.position--;

    }

    @Override
    public void moveToFront() {
        assert this.rep.size() > 0 : "Violation of: this.length > 0";
        this.position = 0;

    }

    @Override
    public int length() {
        return this.rep.size();
    }

    @Override
    public void insert(T entry) {
        this.rep.add(this.position + 1, entry);
    }

    @Override
    public T focus() {
        return this.rep.get(this.position);
    }

    @Override
    public void moveToRear() {
        this.position = this.rep.size() - 1;

    }

    @Override
    public int position() {
        return this.position;
    }

    @Override
    public void clear() {
        this.createNewRep();
    }

    @Override
    public void transferFrom(LinkedList<T> source) {
        LinkedList1L<T> localSource = (LinkedList1L<T>) source;
        this.rep = localSource.rep;
        source.clear();

    }

    @SuppressWarnings("unchecked")
    @Override
    public LinkedList<T> newInstance() {
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
