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
     * Appends {@code entry} to the end of #this.
     *
     * @param entry
     *            item to be appended to {@code this}
     *
     * @updates this
     * @requires entry != null
     * @ensures this = #this * entry
     */
    void add(T entry);

    /**
     * Adds {@code entry} to the front of #this.
     *
     * @param entry
     *            item to be prepended to {@code this}
     *
     * @updates this
     * @requires 0 < #this.length
     * @ensures this = entry * #this
     */
    void addToFront(T entry);

    /**
     * Removes {@code this.focus} and returns it to the caller.
     * {@code this.focus} will be shifted to the right, and if
     * {@code #this.focus} was the last entry, then {@code this.focus} shifts to
     * the first entry in {@code #this}.
     *
     *
     * @return {@code #this.focus}
     *
     * @updates this
     * @requires 0 < #this.length
     * @ensures remove = #this.focus and if #this.focus is the final entry in
     *          the list, this.focus will be the first entry in the array.
     */
    T remove();

    /**
     * Shifts {@code #this.focus} forward by 1 position.
     *
     * @requires #this.focus is not the last entry in the list
     * @ensures this.focus = #this.focus.next
     */
    void advance();

    /**
     * Shifts {@code this.focus} to the entry previous to {@code #this.focus}.
     *
     * @requires [#this.position > 0]
     * @ensures this.position = #this.position - 1
     */
    void retreat();

    /**
     * Shifts {@code this.focus} to the front of the list.
     *
     * @ensures this.focus is the first entry of the list
     */
    void moveToFront();

    /**
     * Returns the number of entries in {@code this}.
     *
     * @return the number of entry of {@code this}
     *
     * @ensures length = |this|
     */
    int length();

    /**
     * Inserts {@code entry} into {@code #this} at the position directly
     * following the {@code #this.focus}.
     *
     * @param entry
     *            entry to be inserted into the list
     *
     * @updates this
     * @ensures this = [(entries before #this.focus) * #this.focus * entry *
     *          (entries after #this.focus)] and [this.focus = #this.focus]
     *
     */
    void insert(T entry);

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
     * Moves {@code #this.focus} to the last entry in {@code this}.
     *
     * @requires 0 < this.length
     * @ensures this.focus = final entry in this
     */
    void moveToRear();

    /**
     * Returns the position of {@code #this.focus}.
     *
     * @return the distance of {@code this.focus} fron the front of the list
     *
     * @requires 0 < this.length
     * @ensures position = [the distance of the focus from the first entry in
     *          the list]
     */
    int position();
}
