package components.stack;

public interface Stack<T> extends StackKernel<T>, Iterable<T> {

    /**
     * Reverses the order of the entries in {@code this}.
     *
     * @updates this
     * @ensures this = rev(#this)
     */
    public void flip();

    /**
     * Replaces the entry at the top of {@code this} with {@code entry}
     * 
     * @param entry
     *            new top of the stack
     * @return the top of {@code #this}
     * @updates this
     * @requires entry is not null and this.length > 0
     * @ensures <pre>
     * swapTop = [top of {@code #this}] and
     * [top of {@code #this} is replaced with {@code entry}]
     * </pre>
     */
    public T swapTop(T entry);

    /**
     * Reports whether {@code entry} is in {@code this}.
     *
     * @param entry
     *            entry to be looked for
     * @return [entry is in #this]
     * @ensures contains = [entry is in this]
     */
    public boolean contains(T entry);

    /**
     * Returns a reference to, but does not remove, the top of {@code this}.
     * 
     * @return a reference to the top of the stack
     * @requires this.size > 0
     * @ensures top = [the top of #this]
     *
     */
    public T top();
}
