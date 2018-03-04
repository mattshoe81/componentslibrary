package linkedlist;

import standard.Standard;

/**
 * {@code SinglyLinkedList} kernel component containing method headers and
 * contracts for all methods that will directly interact with the underlying
 * {@code Node} variables of SinglyLinkedList. All sub-interface methods will
 * use only these methods to perform operations on the {@code SinglyLinkedList}.
 *
 * @author Matthew Shoemaker
 *
 * @param <T>
 */
public interface SinglyLInkedListKernel<T>
        extends Standard<SinglyLinkedList<T>> {

    /**
     * Appends {@code element} to the end of #this.
     *
     * @param element
     *
     * @updates this
     * @requires element != null
     * @ensures this = #this * element
     */
    public void add(T element);

    /**
     * Adds {@code element} to the front of #this.
     *
     * @param element
     *
     * @updates this
     * @requires 0 < #this.length
     * @ensures this = element * #this
     */
    public void addToFront(T element);

    /**
     * Removes {@code focus} from {@code this} and returns it to the caller. The
     * new focus will be shifted to the right, and if the original focus was the
     * last element, then the focus shifts to the first element in
     * {@code #this}.
     *
     *
     * @return the {@code focus} of {@code this}
     *
     * @updates this
     * @requires 0 < this.length
     * @ensures remove = #this.focus and if #this.focus is the final element in
     *          the list, this.focus will be the first element in the array.
     */
    public T remove();

    /**
     * Advances the {@code focus} of {@code this} forward by 1 position.
     *
     * @requires #this.focus is not the last element in the list
     * @ensures this.focus = #this.focus + 1
     */
    public void advance();

    /**
     * Shifts {@code focus} to the front of the list.
     *
     * @requires 0 < length
     * @ensures this.focus is the first element of the list
     */
    public void moveToFront();

    /**
     * Returns the number of elements in {@code this}.
     *
     * @return the number of element of {@code this}
     *
     * @ensures length = |this|
     */
    public int length();

    /**
     * Inserts {@code element} into {#this} at the position directly following
     * the current {@code focus} of {@code this}.
     *
     * @param element
     *
     * @updates this
     * @ensures element is inserted at the next position in the list directly
     *          following this.focus.
     *
     */
    public void insert(T element);

    /**
     * Returns a reference to the element in {@code this} that currently holds
     * the {@code focus}.
     *
     * @return {@code this.focus}
     *
     * @requires 0 < this.length
     * @ensures this = #this and focus = #this.focus
     */
    public T focus();

    /**
     * Moves the current {@code focus} of {@code this} to the last element in
     * {@code this}.
     *
     * @requires 0 < this.length
     * @ensures this.focus = final element in this
     */
    public void moveToRear();

    /**
     * Returns the position of {@code focus} in {@code this}
     *
     * @return the index position of {@code focus} int {@code this}
     *
     * @requires 0 < this.length
     * @ensures position = [the index position of the current element in this
     *          that holds the focus]
     */
    public int position();
}
