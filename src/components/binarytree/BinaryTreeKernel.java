package components.binarytree;

import components.standard.Standard;

/**
 * {@code BinaryTree} kernel component containing method headers and contracts
 * for all methods that will directly interact with the data representations of
 * all BinaryTree implementations. All sub-interface methods should use only
 * these methods to perform operations on the {@code BinaryTree}.
 *
 * @author Matthew Shoemaker
 *
 * @param <T>
 */
public interface BinaryTreeKernel<T> extends Standard<BinaryTree<T>> {

    /**
     * Builds {@code this} into a Binary Tree with {@code root} as the root of
     * the tree, {@code left} as the left subtree of {@code this}, and {@code
     * right} as the right subtree of {@code this}.
     *
     * @param root
     *            the new root of {@code this}
     *
     * @param left
     *            the new left subtree of {@code this}
     * @param right
     *            the new right subtree of {@code this}
     * @replaces this
     * @requires <pre>
     * [left is not null] and
     * [right is not null] and
     * [left != right] and
     * [left != this] and
     * [right != this]
     * </pre>
     * @ensures this = [binary tree with {@code root} at its root node,
     *          {@code left} as the left subtree of {@code this}, and
     *          {@code right} as the right subtree of {@code this}]
     */
    public void build(T root, BinaryTree<T> left, BinaryTree<T> right);

    /**
     * Removes the left subtree from {@code this} and returns it.
     *
     * @return this.left
     * @clears #this.left
     * @ensures leftSubtree = #this.left
     */
    public BinaryTree<T> leftSubtree();

    /**
     * Removes the right subtree from {@code this} and returns it.
     *
     * @return this.right
     * @clears #this.right
     * @ensures rightSubtree = #this.right
     */
    public BinaryTree<T> rightSubtree();

    /**
     * Returns a reference to the root of {@code this}.
     *
     * @return this.root
     * @requires this.size > 0
     * @ensures root = this.root
     */
    public T root();

    /**
     * Reports the number of nodes int {@code this}.
     *
     * @return number of nodes in this
     * @ensures size = [number of nodes in this]
     */
    public int size();

    /**
     * Reports the height of {@code this}.
     *
     * @return the height of {@code this}
     * @ensures height = [height of {@code this}]
     */
    int height();
}
