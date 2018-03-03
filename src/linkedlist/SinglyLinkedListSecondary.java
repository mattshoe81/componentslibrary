package linkedlist;

public abstract class SinglyLinkedListSecondary<T>
        implements SinglyLinkedList<T> {

    /*
     * ************************************************************************
     * Object Superclass methods
     * ************************************************************************
     */
    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract String toString();

    @Override
    public abstract int hashCode();

    /*
     * Not quite sure what could be implemented in here? Tried, and things got
     * pretty wonky.
     */

}
