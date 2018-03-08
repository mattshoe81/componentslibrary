package components.stack;

public abstract class StackSecondary<T> implements Stack<T> {

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object o) {
        boolean equals = true;
        if (o instanceof Stack) {
            Stack<T> q = (Stack<T>) o;
            if (q.size() == this.size()) {
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
            if (k == this.size() - 1) {
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
        // TODO
        return 0;
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
    public void flip() {
        Stack<T> temp = this.newInstance();
        while (this.size() > 0) {
            temp.push(this.pop());
        }

        while (temp.size() > 0) {
            this.push(temp.pop());
        }
    }

    @Override
    public T swapTop(T entry) {
        T top = this.pop();
        this.push(entry);

        return top;
    }

    @Override
    public T top() {
        T top = this.pop();
        this.push(top);
        return top;
    }

}
