package linkedlist;

import standard.Standard;

public interface SinglyLInkedListKernel<T>
        extends Standard<SinglyLinkedList<T>> {

    public void add(T element);

    public void addToFront(T element);

    public T remove();

    public void advance();

    public void moveToFront();

    public int length();

    public void insert(T element);

    public T focus();

    public void moveToRear();

    public int position();
}
