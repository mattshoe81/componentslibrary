package linkedlist;

import standard.Standard;

/**
 * {@code LinkedList} kernel component containing method headers and contracts
 * for all methods that will directly interact with the data representations of
 * all LinkedList implementations. All sub-interface methods should use only
 * these methods to perform operations on the {@code LinkedList}.
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
     *            item to be appended to {@code this}
     *
     * @updates this
     * @requires element != null
     * @ensures this = #this * element
     */
    void add(T element);

    /**
     * Adds {@code element} to the front of #this.
     *
     * @param element
     *            item to be prepended to {@code this}
     *
     * @updates this
     * @requires 0 < #this.length
     * @ensures this = element * #this
     */
    void addToFront(T element);

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
    T remove();

    /**
     * Shifts {@code #this.focus} forward by 1 position.
     *
     * @requires #this.focus is not the last element in the list
     * @ensures this.focus = #this.focus.next
     */
    void advance();

    /**
     * Shifts {@code this.focus} to the front of the list.
     *
     * @ensures this.focus is the first element of the list
     */
    void moveToFront();

    /**
     * Returns the number of elements in {@code this}.
     *
     * @return the number of element of {@code this}
     *
     * @ensures length = |this|
     */
    int length();

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
    void insert(T element);

    /**
     * Returns a reference to {@code #this.focus}.
     *
     * @return {@code #this.focus}
     *
     * @requires 0 < this.length
     * @ensures this = #this and focus = #this.focus
     */
    T focus();

    /**
     * Moves {@code #this.focus} to the last element in {@code this}.
     *
     * @requires 0 < this.length
     * @ensures this.focus = final element in this
     */
    void moveToRear();

    /**
     * Returns the position of {@code #this.focus}.
     *
     * @return the distance of {@code this.focus} fron the front of the list
     *
     * @requires 0 < this.length
     * @ensures position = [the distance of the focus from the first element in
     *          the list]
     */
    int position();
}
