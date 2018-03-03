package linkedlist;

public abstract class SinglyLinkedListSecondary<T>
        implements SinglyLinkedList<T> {

    /*
     * ************************************************************************
     * Object Superclass methods
     * ************************************************************************
     */

    /*
     * Not quite sure what could be implemented in here? Tried, and things got
     * pretty wonky.
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
        String result = "<";
        this.moveToFront();

        int k = 0;
        for (T element : this) {
            if (k == this.length()) {
                result += element;
            } else {
                result += element.toString() + ", ";
            }

        }

        result += ">";

        return result;
    }

    @Override
    public int hashCode() {
        int result = 0;
        // Hmmm, interesting dilemma

        return result;
    }

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

}
