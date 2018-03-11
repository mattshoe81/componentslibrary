package components.binarytree;

import components.standard.Standard;

public interface BinaryTreeKernel<T> extends Standard<BinaryTree<T>> {

    public void build(T root, BinaryTree<T> left, BinaryTree<T> right);

    public BinaryTree<T> leftSubtree();

    public BinaryTree<T> rightSubtree();

    public T root();

    public int size();
}
