package components.sequence;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A sequence data structure layered on top of a java.util.ArrayList.
 *
 * @author Matthew Shoemaker
 *
 * @param <T>
 *
 * @correspondence this = $this.rep
 */
public class Sequence1L<T> extends SequenceSecondary<T> {

    private ArrayList<T> rep;

    private void createNewRep() {
        this.rep = new ArrayList<T>();
    }

    public Sequence1L() {
        this.createNewRep();
    }

    @Override
    public void add(int pos, T entry) {
        assert pos <= this.rep.size() : "Violation of: pos < this.length";
        assert pos >= 0 : "Violation of: pos >= 0";
        this.rep.add(pos, entry);

    }

    @Override
    public T remove(int pos) {
        T remove = this.rep.remove(pos);
        return remove;
    }

    @Override
    public int length() {
        return this.rep.size();
    }

    @Override
    public void clear() {
        this.createNewRep();
    }

    @Override
    public void transferFrom(Sequence<T> source) {
        Sequence1L<T> localSource = (Sequence1L<T>) source;
        this.rep = localSource.rep;
        source.clear();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Sequence<T> newInstance() {
        try {
            return this.getClass().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return this.rep.iterator();
    }

}
