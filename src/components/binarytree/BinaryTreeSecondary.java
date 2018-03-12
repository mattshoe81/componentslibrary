package components.binarytree;

/**
 * Abstract class providing the implementation of all of the layered secondary
 * methods that were defined in the {@code BinaryTree} interface, as well as the
 * implementation for {@code equals}, {@code toString}, and {@code hashCode}
 * methods.
 *
 * @author Matthew Shoemaker
 *
 * @param <T>
 */
public abstract class BinaryTreeSecondary<T> implements BinaryTree<T> {

    @Override
    public String toString() {
        return treeToString(this);
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object o) {
        boolean equals = false;
        if (o instanceof BinaryTreeNL) {
            BinaryTreeNL<T> local = (BinaryTreeNL<T>) o;
            if (local.size() == this.size()) {
                if (local.size() == 0) {
                    equals = true;
                } else {
                    if (local.height() == this.height()) {
                        if (local.root().equals(this.root())) {
                            equals = true;
                            if (local.size() > 1) {
                                BinaryTree<T> leftLocal = local.leftSubtree();
                                BinaryTree<T> rightLocal = local.rightSubtree();
                                T rootLocal = local.root();
                                BinaryTree<T> leftThis = this.leftSubtree();
                                BinaryTree<T> rightThis = this.rightSubtree();
                                T rootThis = this.root();
                                equals = leftLocal.equals(leftThis);
                                if (equals) {
                                    equals = rightLocal.equals(rightThis);
                                }
                                this.build(rootThis, leftThis, rightThis);
                                local.build(rootLocal, leftLocal, rightLocal);
                            }
                        }
                    }
                }
            }
        }

        return equals;
    }

    /**
     * Returns the {@code String} prefix representation of the given
     * {@code BinaryTree<T>}.
     *
     * @param <T>
     *            the type of the {@code BinaryTree} node labels
     * @param t
     *            the {@code BinaryTree} to convert to a {@code String}
     * @return the prefix representation of {@code t}
     * @ensures treeToString = [the String prefix representation of t]
     */
    private static <T> String treeToString(BinaryTree<T> t) {
        String result = "";
        if (t.size() > 0) {

            /*
             * Disassemble tree for analysis
             */
            BinaryTree<T> left = t.leftSubtree();
            BinaryTree<T> right = t.rightSubtree();
            T root = t.root();
            /*
             * initialize string representation to empty tree, change if needed
             */
            String leftString = "()";
            String rightString = "()";
            // If left tree is nonempty, recurse on left tree
            if (left.size() > 0) {
                leftString = "(" + treeToString(left) + ")";
            }
            // If right tree is nonempty, recurse on right tree
            if (right.size() > 0) {
                rightString = "(" + treeToString(right) + ")";
            }
            // Concatenate the representations together
            result += root.toString() + leftString + rightString;

            // Restore tree
            t.build(root, left, right);
        }

        return result;
    }

    @Override
    public T replaceRoot(T replacement) {
        BinaryTree<T> left = this.leftSubtree();
        BinaryTree<T> right = this.rightSubtree();
        T root = this.root();

        this.build(replacement, left, right);

        return root;
    }

    @Override
    public boolean contains(T node) {
        boolean contains = false;
        if (this.size() > 0) {
            T root = this.root();
            if (root.equals(node)) {
                contains = true;
            } else {

                BinaryTree<T> left = this.leftSubtree();
                BinaryTree<T> right = this.rightSubtree();
                if (left.size() > 0) {
                    contains = left.contains(node);
                }
                if (!contains && right.size() > 0) {
                    contains = right.contains(node);
                }

                this.build(root, left, right);
            }
        }

        return contains;
    }

    @Override
    public void remove(T node) {
        BinaryTree<T> left = this.leftSubtree();
        BinaryTree<T> right = this.rightSubtree();
        T root = this.root();

        if (root.equals(node)) {
            if (right.size() > 0) {
                root = BinaryTreeUtility.removeLeftMost(right);
                this.build(root, left, right);
            } else if (left.size() > 0) {
                root = BinaryTreeUtility.removeRightMost(left);
                this.build(root, left, right);
            } else {
                this.clear();
            }
        } else {
            if (left.contains(node)) {
                left.remove(node);
            } else {
                right.remove(node);
            }
            this.build(root, left, right);
        }
    }

}
