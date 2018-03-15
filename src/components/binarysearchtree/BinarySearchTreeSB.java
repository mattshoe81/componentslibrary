package components.binarysearchtree;

import components.binarytree.BinaryTree;
import components.binarytree.BinaryTreeNL;

public class BinarySearchTreeSB<T extends Comparable<T>>
        extends BinarySearchTreeSecondary<T> {

    /**************************************************************************
     * Private stuff
     */
    private BinaryTreeNL<T> rep;

    private void createNewRep() {
        this.rep = new BinaryTreeNL<T>();
    }

    private void balance(BinaryTree<T> tree) {
        int balanceFactor = this.rep.balanceFactor();
        if (balanceFactor < -1) {

        } else if (balanceFactor > 1) {

        }
    }

    private void rightRotation(BinaryTree<T> tree) {

    }

    private void leftRotation(BinaryTree<T> tree) {

    }

    /**
     * Inserts {@code x} in {@code t}.
     *
     * @param <T>
     *            type of {@code BinaryTree} labels
     * @param t
     *            the {@code BinaryTree} to be searched
     * @param x
     *            the label to be inserted
     * @aliases reference {@code x}
     * @updates t
     * @requires IS_BST(t) and x is not in labels(t)
     * @ensures IS_BST(t) and labels(t) = labels(#t) union {x}
     */
    private static <T extends Comparable<T>> void insertInTree(BinaryTree<T> t,
            T x) {
        assert t != null : "Violation of: t is not null";
        assert x != null : "Violation of: x is not null";

        // Base case, if size 0 then assemble - x as root with empty subtrees
        if (t.size() == 0) {
            t.build(x, t.newInstance(), t.newInstance());
        } else {
            // Size not zero, disassemble t
            BinaryTree<T> left = t.leftSubtree();
            BinaryTree<T> right = t.rightSubtree();
            T root = t.root();

            // Determine which subtree, left or right, that x will belong in,
            // recursively insert x into that tree
            if (x.compareTo(root) > 0) {
                insertInTree(right, x);
            } else {
                insertInTree(left, x);
            }

            // Reassemble  t
            t.build(root, left, right);
        }
    }

    /**************************************************************************
     * Constructor
     */

    public BinarySearchTreeSB() {
        this.createNewRep();
    }

    /***************************************************************************
     * Kernel Methods
     */
    @Override
    public void insert(T node) {
        insertInTree(this.rep, node);
        this.balance(this.rep);
    }

    @Override
    public void remove(T node) {
        this.rep.remove(node);
    }

    @Override
    public int size() {
        return this.rep.size();
    }

    @Override
    public int height() {
        return this.rep.height();
    }

    /***************************************************************************
     * Standard Methods
     */
    @Override
    public void clear() {
        this.createNewRep();
    }

    @Override
    public void transferFrom(BinarySearchTree<T> source) {
        BinarySearchTreeSB<T> localSource = (BinarySearchTreeSB<T>) source;
        this.rep = localSource.rep;
    }

    @SuppressWarnings("unchecked")
    @Override
    public BinarySearchTreeSB<T> newInstance() {
        try {
            return this.getClass().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    /***************************************************************************
     * Object superclass stuff overridden for simplicity
     */

    @Override
    public String toString() {
        return this.rep.toString();
    }

    @Override
    public boolean equals(Object o) {
        return this.rep.equals(o);
    }

    @Override
    public int hashCode() {
        return this.rep.hashCode();
    }

}
