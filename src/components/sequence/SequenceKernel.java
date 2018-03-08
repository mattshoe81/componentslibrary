package components.sequence;

import components.standard.Standard;

public interface SequenceKernel<T> extends Standard<Sequence<T>> {

    /**
     * Inserts {@code entry} into {@code this} at index position {@code pos}.
     * All entries following the insertion are shifted to the right.
     *
     * @param pos
     *            index of the insertion
     * @param entry
     *            entry to be inserted
     * @requires pos <= this.lenth and entry is not null
     * @ensures this = [#this with {@code entry} inserted at the {@code pos}
     *          position}
     */
    public void add(int pos, T entry);

    /**
     * Removes the entry at {@code pos} position of {@code #this}.
     *
     * @param pos
     *            index of the entry to be removed
     * @return entry at index {@code pos} of {@code #this}
     * @updates this
     * @requires pos < this.length and this.length > 0-
     * @ensures <pre>
     * remove = [entry at index {@code pos} of {@code #this}] and
     * this = [#this without the entry at index {@code pos}] and
     * [all entries following the removed entry shift to the left]
     * </pre>
     *
     */
    public T remove(int pos);

    /**
     * Reports the length of {@code this}.
     * 
     * @return |this|
     * @ensures length = [|this|]
     */
    public int length();
}
