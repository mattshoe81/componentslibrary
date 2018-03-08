package components.stack;

import java.util.Iterator;

/**
 * An implementation thinly layered on top of a java.util.Stack.
 *
 * @author Matthew Shoemaker
 *
 * @param <T>
 *
 * @correspondence this = $this.rep
 */
public class Stack1L<T> extends StackSecondary<T> {

    private java.util.Stack<T> rep;

    private void createNewRep() {
        this.rep = new java.util.Stack<T>();
    }

    public Stack1L() {
        this.createNewRep();
    }

    @Override
    public void push(T entry) {
        this.rep.push(entry);

    }

    @Override
    public T pop() {
        T pop = this.rep.pop();
        return pop;
    }

    @Override
    public int size() {
        return this.rep.size();
    }

    @Override
    public void clear() {
        this.createNewRep();

    }

    @Override
    public void transferFrom(Stack<T> source) {
        Stack1L<T> localSource = (Stack1L<T>) source;
        this.rep = localSource.rep;
        source.clear();

    }

    @SuppressWarnings("unchecked")
    @Override
    public Stack1L<T> newInstance() {
        try {
            return this.getClass().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public Iterator<T> iterator() {
        return this.rep.iterator();
    }

}
