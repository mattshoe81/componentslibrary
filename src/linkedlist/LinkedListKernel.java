package linkedlist;

import standard.Standard;

/**
 * {@code LinkedList} kernel component containing method headers and contracts
 * for all methods that will directly interact with the underlying {@code Node}
 * variables of LinkedList. All sub-interface methods will use only these
 * methods to perform operations on the {@code LinkedList}.
 *
 * @author Matthew Shoemaker
 *
 * @param <T>
 */
public interface LinkedListKernel<T> extends Standard<LinkedList<T>> {

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
     * Removes {@code this.focus} and returns it to the caller.
     * {@code this.focus} will be shifted to the right, and if
     * {@code #this.focus} was the last element, then {@code this.focus} shifts
     * to the first element in {@code #this}.
     *
     *
     * @return {@code #this.focus}
     *
     * @updates this
     * @requires 0 < #this.length
     * @ensures remove = #this.focus and if #this.focus is the final element in
     *          the list, this.focus will be the first element in the array.
     */
    public T remove();

    /**
     * Shifts {@code #this.focus} forward by 1 position.
     *
     * @requires #this.focus is not the last element in the list
     * @ensures this.focus = #this.focus.next
     */
    public void advance();

    /**
     * Shifts {@code this.focus} to the front of the list.
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
     * Inserts {@code element} into {@code #this} at the position directly
     * following the {@code #this.focus}.
     *
     * @param element
     *            element to be inserted into the list
     *
     * @updates this
     * @ensures this = [(elements before #this.focus) * #this.focus * element *
     *          (elements after #this.focus)] and [this.focus = #this.focus]
     *
     */
    public void insert(T element);

    /**
     * Returns a reference to {@code #this.focus}.
     *
     * @return {@code #this.focus}
     *
     * @requires 0 < this.length
     * @ensures this = #this and focus = #this.focus
     */
    public T focus();

    /**
     * Moves {@code #this.focus} to the last element in {@code this}.
     *
     * @requires 0 < this.length
     * @ensures this.focus = final element in this
     */
    public void moveToRear();

    /**
     * Returns the position of {@code #this.focus}.
     *
     * @return the index position of {@code this.focus}
     *
     * @requires 0 < this.length
     * @ensures position = [the index position of the current element in this
     *          that holds the focus]
     */
    public int position();
}
