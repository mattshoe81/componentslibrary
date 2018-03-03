package linkedlist;

public interface SinglyLinkedList<T>
        extends SinglyLInkedListKernel<T>, Iterable<T> {

    public T removeFront();

    public T removeRear();

    public boolean contains(T element);

    public void retreat();

}
