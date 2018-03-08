package components.linkedlist;

/**
 * Abstract class providing the implementation of all of the layered secondary
 * methods that were defined in the LinkedList interface, as well as the
 * implementation for equals, toString, and hashCode methods.
 *
 * @author Matthew Shoemaker
 *
 * @param <T>
 */
public abstract class LinkedListSecondary<T> implements LinkedList<T> {

    /*
     * ************************************************************************
     * Object Superclass methods
     * ************************************************************************
     */

    @Override
    public boolean equals(Object obj) {
        boolean equals = false;
        if (obj instanceof LinkedList) {
            equals = this.toString().equals(obj.toString());
        }

        return equals;
    }

    @Override
    public String toString() {
        String result = "<";
        if (this.length() > 0) {
            int pos = this.position();
            this.moveToFront();
            int k = 0;
            for (T entry : this) {
                if (k == this.length() - 1) {
                    result += entry;
                } else {
                    result += entry.toString() + ", ";
                }
                k++;
            }

            this.moveToPosition(pos);
        }

        result += ">";

        return result;
    }

    /**
     * Note: Opted for a relatively more efficient implementation.
     */
    @Override
    public int hashCode() {
        int result = 0;
        int multiplier = 19;
        int originalPosition = this.position();
        this.moveToFront();
        for (int k = 0; k < this.length() && k < 5; k++) {
            result += this.focus().hashCode() * multiplier;
            this.advance();
        }
        this.moveToPosition(originalPosition);

        return result;
    }

    /*
     * ************************************************************************
     * Secondary Methods
     * ************************************************************************
     */
    @Override
    public T removeFront() {
        assert this.length() > 0 : "Violation of: 0 < this.length";

        int position = this.position();
        this.moveToFront();
        T removeFront = this.remove();
        if (this.length() > 0 && position > 0) {
            this.moveToPosition(position - 1);
        }

        return removeFront;
    }

    @Override
    public T removeRear() {
        assert this.length() > 0 : "Violation of: 0 <= this.length";

        this.moveToRear();
        T rear = this.remove();
        return rear;
    }

    @Override
    public boolean contains(T entry) {
        boolean contains = false;
        int k = 0;
        this.moveToFront();
        while (k < this.length() && !contains) {
            if (this.focus().equals(entry)) {
                contains = true;
            }
            this.advance();
        }

        return contains;
    }

    @Override
    public void moveToPosition(int pos) {
        assert pos >= 0 : "Violation of: pos >= 0";
        assert pos < this.length() : "Violation of: pos < this.length";

        int currentPos = this.position();
        if (currentPos <= pos) {
            for (int k = currentPos; k < pos; k++) {
                this.advance();
            }
        } else {
            this.moveToFront();
            for (int k = 0; k < pos; k++) {
                this.advance();
            }
        }
    }

}
