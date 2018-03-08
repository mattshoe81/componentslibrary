package components.sequence;

public interface Sequence<T> extends SequenceKernel<T>, Iterable<T> {

    /**
     * Appends the entries in {@code seq} to the end of {@code this}.
     *
     * @param seq
     *            sequence whose entries will be appended to this
     * @updates this
     * @requires seq is not null
     * @ensures this = #this * seq
     */
    public void append(Sequence<T> seq);

    /**
     * Appends {@code entry} to the end of {@code this}.
     *
     * @param entry
     *            entry to be appended to {@code this}
     * @updates this
     * @requires entry is not null
     * @ensures this = #this * entry
     */
    public void append(T entry);

    /**
     * Returns a reference to the entry at index {@code pos} of {@code this}.
     *
     * @param pos
     *            index position
     * @return entry at index {@code pos} of {@code this}
     * @requires pos < this.length and this.length > 0
     * @ensures entry = [entry at index {@code pos} of {@code this}]
     */
    public T entry(int pos);

    /**
     * Replaces the entry at index {@code pos} of {@code #this} with
     * {@code entry}.
     *
     * @param pos
     *            index of entry in {@code #this} to be replaced
     * @param entry
     *            entry that will take the place of the entry at index
     *            {@code pos} of {@code #this}
     * @return the entry at index {@code pos} of {@code #this}
     * @requires pos < this.length and this.length > 0
     * @ensures <pre>
     * replaceEntry = [the entry at index {@code pos} of {@code #this}] and
     * [the entry at index {@code pos} of {@code #this} is replaced with {@code entry}]
     * </pre>
     */
    public T replaceEntry(int pos, T entry);

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
