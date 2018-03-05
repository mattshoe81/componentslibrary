package linkedlist;

/**
 * Additional functionality upon the bare-bones functionality afforded by the
 * {@code LinkedListKernel} interface. All method implementations must, by
 * design, use only the LinkedListKernel methods to perform operations on the
 * component.
 *
 * @author Matthew Shoemaker
 *
 * @param <T>
 */
public interface LinkedList<T> extends LinkedListKernel<T>, Iterable<T> {

    /**
     * Removes and returns the first entry in {@code this}.
     *
     * @return the first entry in {@code this}
     * @updates this
     * @requires 0 < this.length
     * @ensures removeFront = [the first entry of #this] and this = #this /
     *          front
     */
    T removeFront();

    /**
     * Removes and returns the final entry in {@code this}.
     *
     * @return the final entry in {@code this}
     * @updates this
     * @requires 0 < this.length
     * @ensures removeFront = [the final entry of #this] and this = #this / rear
     */
    T removeRear();

    /**
     * Reports whether {@code this} contains {@code entry}.
     *
     * @param entry
     *            entry to check for in {@code this}
     * @return boolean as to whether {@code this} contains {@code entry}
     * @ensures contains = [entry is in #this]
     */
    boolean contains(T entry);

    /**
     * Shifts {@code this.focus} to the ({@code pos} + 1)th entry in
     * {@code this}. A linked list has no index value, but this can be
     * essentially thought of as a tool for index value in the most simple
     * terms.
     *
     * @param pos
     *            position to which the {@code focus} will shift
     * @requires <pre>
     *          pos < this.length and 0 <= pos
     *          </pre>
     * @ensures this.position = pos
     *
     */
    void moveToPosition(int pos);

}
