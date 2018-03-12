package components.binarytree;

/**
 * Additional functionality upon the bare-bones functionality afforded by the
 * {@code BinaryTreeKernel} interface. All method implementations must, by
 * design, use only the BinaryTreeKernel methods to perform operations on the
 * component.
 *
 * @author Matthew Shoemaker
 *
 * @param <T>
 */
public interface BinaryTree<T> extends BinaryTreeKernel<T> {

    /**
     * Swaps {@code #this.root} with {@code replacement} and returns
     * {@code #this.root}.
     *
     * @param replacement
     *            new root of {@code this}
     * @return #this.root
     * @updates this
     * @requires this.size > 0 and replacement is not null
     * @ensures this.root = replacement and replacement = #this.root
     */
    public T replaceRoot(T replacement);

    /**
     * Searches {@code this} for {@code node}, and removes it from {@code this}.
     * The binary tree represented by {@code this} is restructured such that the
     * left-most node of the right subtree of the binary tree rooted at
     * {@code node} is moved to the root of that subtree. If there is no right
     * subtree, then the right-most node of the left subtree of the binary tree
     * rooted at {@code node} is moved to the root of that subtree. In the case
     * that {@code node} is a leaf, it is simply removed.
     *
     * @param node
     *            node to be removed from this
     * @updates this
     * @requires [node is in this] and [node is not null]
     * @ensures [The binary tree represented by {@code this} is restructured
     *          such that the left-most node of the right subtree of the binary
     *          tree rooted at {@code node} is moved to the root of that
     *          subtree. If there is no right subtree, then the right-most node
     *          of the left subtree of the binary tree rooted at {@code node} is
     *          moved to the root of that subtree. In the case that {@code node}
     *          is a leaf, it is simply removed]
     */
    public void remove(T node);

    /**
     * Reports whether {@code node} is in {@code this}.
     *
     * @param node
     *            node to search for
     * @return whether node is in this
     * @ensures contains = [node is in this]
     */
    public boolean contains(T node);
}
