package linkedlist;

/**
 * Abstract class providing the implementation of all of the layered secondary
 * methods that were defined in the SinglyLinkedList interface, as well as the
 * implementation for equals, toString, and hashCode methods.
 *
 * @author Matthew Shoemaker
 *
 * @param <T>
 */
public abstract class SinglyLinkedListSecondary<T>
        implements SinglyLinkedList<T> {

    /*
     * ************************************************************************
     * Object Superclass methods
     * ************************************************************************
     */

    @Override
    public boolean equals(Object obj) {
        boolean equals = true;
        if (this.getClass().equals(obj.getClass())) {
            equals = this.toString().equals(obj.toString());
        }

        return equals;
    }

    @Override
    public String toString() {
        int pos = this.position();
        String result = "<";
        this.moveToFront();

        int k = 0;
        for (T element : this) {
            if (k == this.length() - 1) {
                result += element;
            } else {
                result += element.toString() + ", ";
            }
            k++;
        }
        result += ">";
        this.moveToPosition(pos);

        return result;
    }

    @Override
    public int hashCode() {
        int result = 0;
        // Hmmm, interesting dilemma

        return result;
    }

    /*
     * ************************************************************************
     * Secondary Methods
     * ************************************************************************
     */
    @Override
    public T removeFront() {
        this.moveToFront();
        T removeFront = this.remove();
        return removeFront;
    }

    @Override
    public T removeRear() {
        this.moveToRear();
        T rear = this.remove();
        return rear;
    }

    @Override
    public boolean contains(T element) {
        boolean contains = false;
        int k = 0;
        this.moveToFront();
        while (k < this.length() && !contains) {
            if (this.focus().equals(element)) {
                contains = true;
            }
            this.advance();
        }

        return contains;
    }

    @Override
    public void moveToPosition(int pos) {
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
