package components.binarysearchtree;

import components.standard.Standard;

public interface BinarySearchTreeKernel<T>
        extends Standard<BinarySearchTree<T>> {

    public void insert(T node);

    public void remove(T node);

    public int size();

    public int height();
}
