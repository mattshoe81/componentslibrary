package components.binarytree;

public abstract class BinaryTreeSecondary<T> implements BinaryTree<T> {

    @Override
    public String toString() {
        return treeToString(this);
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
            // Concatenate the represenations together
            result += root.toString() + leftString + rightString;

            // Restore tree
            t.build(root, left, right);
        }

        return result;
    }

    @Override
    public int height() {
        int height = 1;

        if (this.size() > 0) {
            BinaryTree<T> left = this.leftSubtree();
            BinaryTree<T> right = this.rightSubtree();
            T root = this.root();
            int leftHeight = 0;
            int rightHeight = 0;
            if (left.size() > 0) {
                leftHeight = left.height();
            }
            if (right.size() > 0) {
                rightHeight = right.height();
            }

            if (leftHeight > rightHeight) {
                height += leftHeight;
            } else {
                height += rightHeight;
            }

            this.build(root, left, right);
        }
        return height;
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
    public void remove(T node) {
        assert this.contains(node) : "Violation of: node is in this";

        BinaryTree<T> left = this.leftSubtree();
        BinaryTree<T> right = this.rightSubtree();
        T root = this.root();

        if (root.equals(node)) {
            root = this.removeBottomLeft(right);
        } else {
            if (left.contains(node)) {
                left.remove(node);
            } else {
                right.remove(node);
            }
        }

        this.build(root, left, right);
    }

    @Override
    public boolean contains(T node) {
        boolean contains = false;
        BinaryTree<T> left = this.leftSubtree();
        BinaryTree<T> right = this.rightSubtree();
        T root = this.root();
        if (root.equals(node)) {
            contains = true;
        } else {
            if (left.size() > 0) {
                contains = left.contains(node);
            }
            if (!contains && right.size() > 0) {
                contains = right.contains(node);
            }
        }

        return contains;
    }

    private T removeBottomLeft(BinaryTree<T> tree) {
        T bottomLeft;
        BinaryTree<T> left = tree.leftSubtree();
        BinaryTree<T> right = tree.rightSubtree();
        T root = tree.root();
        bottomLeft = root;

        if (left.size() == 1) {
            bottomLeft = left.root();
            tree.build(root, tree.newInstance(), right);
        } else {
            bottomLeft = this.removeBottomLeft(left);
            tree.build(root, left, right);
        }

        return bottomLeft;
    }

}
