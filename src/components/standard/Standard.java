package components.standard;

/**
 *
 * @param <T>
 */
public interface Standard<T> {

    /**
     * Resets {@code this} to its initial value.
     *
     * @clears this
     */
    public void clear();

    /**
     * Sets {@code this} to the incoming value of source, and resets
     * {@code source} to an initial value; the declaration notwithstanding, the
     * dynamic type of {@code source} must be the same as the dynamic type of
     * {@code this}. If the type T has a no-argument constructor, then
     * {@code source} satisfies the contract of the no-argument constructor for
     * T. If T does not have a no-argument constructor, then source satisfies
     * the contract of the constructor call that was used to initialize
     * {@code #source}.
     *
     * @param source
     *            object whose value is to be transferred
     * @replaces this
     * @clears source
     * @ensures this = #source
     *
     */
    public void transferFrom(T source);

    /**
     * Returns a new object with the same dynamic type as {@code this}, having
     * an initial value. If the type T has a no-argument constructor, then the
     * value of the new returned object satisfies the contract of the
     * no-argument constructor for T. If T does not have a no-argument
     * constructor, then the value of the new returned object satisfies the
     * contract of the constructor call that was used to initialize
     * {@code this}.
     *
     * @return new object "like" {@code this} with an initial value
     * @ensures is_initial(newInstance)
     *
     */
    public T newInstance();

}
