package components.stack;

import components.standard.Standard;

/**
 * {@code Stack} kernel component containing method headers and contracts for
 * all methods that will directly interact with the data representations of all
 * Stack implementations. All sub-interface methods should use only these
 * methods to perform operations on the {@code Stack}.
 *
 * @author Matthew Shoemaker
 *
 * @param <T>
 */
public interface StackKernel<T> extends Standard<Stack<T>> {

    /**
     * Pushes {@code entry} to the top of the stack.
     *
     * @param entry
     *            entry to be pushed to the top of the stack.
     * @requires [entry is not null]
     * @ensures this = entry * #this
     */
    public void push(T entry);

    /**
     * Removes the top of the stack and returns it.
     *
     * @return top of the stack
     * @requires this.size > 0
     * @ensures <pre>
     * pop = [top of the stack] and
     * #this = <pop> * this
     * </pre>
     */
    public T pop();

    /**
     * Reports the size of {@code this}.
     *
     * @return |this|
     *
     * @ensures size = |this|
     */
    public int size();
}
