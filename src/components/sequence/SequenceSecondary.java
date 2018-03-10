package components.sequence;

/**
 * Abstract class providing the implementation of all of the layered secondary
 * methods that were defined in the Sequence interface, as well as the
 * implementation for equals, toString, and hashCode methods.
 *
 * @author Matthew Shoemaker
 *
 * @param <T>
 */
public abstract class SequenceSecondary<T> implements Sequence<T> {

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object o) {
        boolean equals = true;
        if (o instanceof Sequence) {
            Sequence<T> q = (Sequence<T>) o;
            if (q.length() == this.length()) {
                for (T entryThis : this) {
                    if (equals) {
                        equals = q.contains(entryThis);
                    }
                }
            } else {
                equals = false;
            }
        } else {
            equals = false;
        }

        return equals;
    }

    @Override
    public String toString() {
        String toString = "<";
        int k = 0;
        for (T entry : this) {
            if (k == this.length() - 1) {
                toString += entry.toString();
            } else {
                toString += entry.toString() + ", ";
            }
            k++;
        }
        toString += ">";
        return toString;
    }

    @Override
    public int hashCode() {
        int result = 0;
        for (int k = 0; k < this.length() && k < 5; k++) {
            result *= this.entry(k).hashCode() * 7;
        }

        return result;
    }

    @Override
    public boolean contains(T entry) {
        boolean contains = false;
        for (T entryThis : this) {
            if (!contains) {
                contains = entryThis.equals(entry);
            }
        }

        return contains;
    }

    @Override
    public void append(Sequence<T> seq) {
        for (T entry : seq) {
            this.add(this.length(), entry);
        }
        seq.clear();
    }

    @Override
    public void append(T entry) {
        this.add(this.length(), entry);
    }

    @Override
    public T entry(int pos) {
        T entry = this.remove(pos);
        this.add(pos, entry);

        return entry;
    }

    @Override
    public T replaceEntry(int pos, T entry) {
        T replaceEntry = this.remove(pos);
        this.add(pos, entry);

        return replaceEntry;
    }

}
