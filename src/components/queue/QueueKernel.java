
/**
 *
 */
package components.queue;

import components.standard.Standard;

/**
 * {@code Queue} kernel component containing method headers and contracts for
 * all methods that will directly interact with the data representations of all
 * Queue implementations. All sub-interface methods should use only these
 * methods to perform operations on the {@code Queue}.
 *
 * @author Matthew Shoemaker
 *
 */
public interface QueueKernel<T> extends Standard<Queue<T>> {

    /**
     * Adds {@code entry} to the back of {@code this}.
     *
     * @param entry
     *            entry to be enqueued
     *
     * @updates this
     * @ensures this = #this * entry
     */
    public void enqueue(T entry);

    /**
     * Removes the entry at the front of {@code this}.
     *
     * @return the front of the queue
     *
     * @updates this
     * @ensures <pre>
     * dequeue = [entry at the front of the queue] and
     * [the front of the queue is removed]
     * </pre>
     *
     */
    public T dequeue();

    /**
     * Reports the number of entries in the queue.
     *
     * @return |this|
     *
     * @ensures length = [number of entries in the queue]
     */
    public int length();

    /**
     * Reports, but does not remove, the entry at the front of {@code this}.
     *
     * @return a reference to the entry at the front of {@code this}
     *
     * @requires #this.length > 0
     * @ensures front = [front of the queue]
     */
    public T front();

    /**
     * Replaces the entry at the front of {@code this} with {@code entry}, and
     * returns the entry at the front of {@code #this}.
     *
     * @param entry
     *            new front of the queue
     * @return entry at the front of #this
     * @updates this
     * @requires #this.length > 0
     * @ensures <pre>
     * replaceFront = #this.front and
     * this = (#this with the front of the queue swapped with {@code entry})
     * </pre>
     */
    public T replaceFront(T entry);
}
