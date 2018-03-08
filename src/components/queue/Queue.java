/**
 *
 */
package components.queue;

import java.util.Collection;
import java.util.Comparator;

/**
 * Additional functionality upon the bare-bones functionality afforded by the
 * {@code QueueKernel} interface. All method implementations must, by design,
 * use only the QueueKernel methods to perform operations on the component.
 *
 * @author Matthew Shoemaker
 *
 */
public interface Queue<T> extends QueueKernel<T>, Iterable<T> {

    /**
     * Reverses the order of the entries in {@code this}.
     *
     * @updates this
     * @ensures this = rev(#this)
     */
    public void flip();

    /**
     * Appends the entries in {@code collection} to the end of {@code this}.
     *
     * @param collection
     *            collections whose entries will be appended to this
     * @updates this
     * @requires collection is not null
     * @ensures this = #this * collection
     */
    public void append(Collection<T> collection);

    /**
     * Appends the entries in {@code collection} to the end of {@code this}.
     *
     * @param collection
     *            collections whose entries will be appended to this
     * @updates this
     * @requires collection is not null
     * @ensures this = #this * collection
     */
    public void append(Queue<T> collection);

    /**
     * Sorts the entries in {@code this} according to the order provided by
     * {@code comparator}.
     *
     * @param comparator
     *            ordering to be imposed on #this
     * @updates this
     * @requires comparator is not null
     * @ensures this = [#this.entries sorted in the order provided by
     *          comparator]
     */
    public void sort(Comparator<T> comparator);

    /**
     * Reports whether {@code entry} is in {@code this}.
     *
     * @param entry
     *            entry to be looked for
     * @return [entry is in #this]
     * @ensures contains = [entry is in this]
     */
    public boolean contains(T entry);

}
