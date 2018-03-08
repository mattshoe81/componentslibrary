package components.stack;

import components.standard.Standard;

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
