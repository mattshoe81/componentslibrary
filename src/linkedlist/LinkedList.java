package linkedlist;

/**
 * Additional functionality upon the bare-bones functionality afforded by the
 * {@code SinglyLinkedListKernel} interface. All method implementations must, by
 * design, use only the SinglyLinkedListKernel methods to perform operations on
 * the component.
 *
 * @author Matthew Shoemaker
 *
 * @param <T>
 */
public interface LinkedList<T> extends LinkedListKernel<T>, Iterable<T> {

    /**
     * Removes and returns the first element in {@code this}.
     *
     * @return the first element in {@code this}
     * @updates this
     * @requires 0 < this.length
     * @ensures removeFront = [the first element of #this] and this = #this /
     *          front
     */
    public T removeFront();

    /**
     * Removes and returns the final element in {@code this}.
     *
     * @return the final element in {@code this}
     * @updates this
     * @requires 0 < this.length
     * @ensures removeFront = [the final element of #this] and this = #this /
     *          rear
     */
    public T removeRear();

    /**
     * Reports whether {@code this} contains {@code element}.
     *
     * @param element
     *            element to check for in {@code this}
     * @return boolean as to whether {@code this} contains {@code element}
     * @ensures contains = [element is in #this]
     */
    public boolean contains(T element);

    /**
     * Shifts {@code this.focus} to the element previous to {@code #this.focus}.
     *
     * @requires 1 < this.length
     * @ensures this.focus = #this.focus - 1
     */
    public void retreat();

    /**
     * Shifts {@code this.focus} to the ({@code pos} + 1)th element in
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
    public void moveToPosition(int pos);

}
