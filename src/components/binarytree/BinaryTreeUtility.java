package components.binarytree;

/**
 * A collection of useful methods for manipulating binary trees.
 *
 * @author Matthew Shoemaker
 *
 */
public final class BinaryTreeUtility {

    /**
     * Builds a binary tree from the given string. The string must be formatted
     * such that: each subtree is denoted by its String label and 2 sets of
     * parentheses, one for the right and one for the left. Empty subtrees must
     * be explicitly denoted with empty parenthesis.
     *
     * For example, the simple binary tree with the root of "x" and a left child
     * "y" and a right child "z" would be represented by:
     *
     * a(b()())(c()())
     *
     * A tree with "x" as its root node and no children would be:
     *
     * x()()
     *
     * A tree with "x" as its root, an empty left subtree, and "z" as its right
     * child would be denoted by:
     *
     * x()(z()())
     *
     * A tree with "x" as its root, "y" as its left child, and an empty right
     * subtree would be denoted by:
     *
     * x(y()())()
     *
     * Any tree can be expressed through the combination of the 4 examples.
     *
     * @param str
     * @return a binary tree with the structure conveyed by the string
     *         parameter.
     * @requires [str defines a valid tree structure following the guidelines]
     *           and [str is not null]
     * @ensures treeFromString = {a binary tree with exactly the structure
     *          conveyed by the str argument]
     */
    public static BinaryTree<String> treeFromString(String str) {
        String root;
        String treeString = str;
        // Extract the root of the tree
        root = treeString.substring(0, treeString.indexOf("("));

        // Find the index of the first left parenthesis, since the left subtree
        // will follow directly after the first '('
        int indexOfLeftParenthesis = treeString.indexOf("(");

        /**
         * Iterate through the characters in the tree string, starting at the
         * index after the first left parenthesis. Whenever you encounter a left
         * parenthesis, increment the counter. Whenever you encounter a right
         * parenthesis, decrement the counter. When the counter for the
         * parenthesis reaches 0, then that is the closing parenthesis, and k is
         * its index.
         */
        int k = indexOfLeftParenthesis + 1;
        int parenthesis = 1;
        while (parenthesis != 0) {
            char charAtK = treeString.charAt(k);
            if (charAtK == '(') {
                parenthesis++;
            } else if (charAtK == ')') {
                parenthesis--;
            }
            if (parenthesis != 0) {
                k++;
            }
        }
        // Extract the string for the left and right subtrees
        String leftString = treeString.substring(indexOfLeftParenthesis + 1, k);
        String rightString = treeString.substring(k + 2,
                treeString.length() - 1);

        // Initialize left and right to empty tree
        BinaryTree<String> left = new BinaryTreeNL<>();
        BinaryTree<String> right = new BinaryTreeNL<>();

        /*
         * If the leftString does not indicate an empty tree, recursively call
         * treeFromString on the substring for the left tree, and the same for
         * the right subtree
         */
        if (!leftString.equals("")) {
            left = treeFromString(leftString);
        }
        if (!rightString.equals("")) {
            right = treeFromString(rightString);
        }

        // Build a new binary tree for the return
        BinaryTree<String> newTree = new BinaryTreeNL<>();
        newTree.build(root, left, right);

        return newTree;
    }

    /**
     * Removes and returns the left-most node in {@code t}.
     *
     * @param <T>
     *            type of {@code BinaryTree} nodes
     * @param t
     *            the {@code BinaryTree} from which to remove the node
     * @return the left-most node in the given {@code BinaryTree}
     * @updates t
     * @requires t.size > 0
     * @ensures [the left-most node in t is removed from t and returned] and [if
     *          the left-most node has a right subtree, then its right subtree
     *          will be moved to the position in the tree where the left-most
     *          node was]
     */
    public static <T> T removeLeftMost(BinaryTree<T> t) {
        assert t != null : "Violation of: t is not null";

        // Declare/initialize left/right BT to hold t's subtrees, respectively,
        // then disassemble
        BinaryTree<T> left = t.leftSubtree();
        BinaryTree<T> right = t.rightSubtree();
        T root = t.root();

        // Set smallest to current root
        T leftMost = root;

        // If left subtree isn't the empty subtree then the current root is not
        // the smallest, recursively enter into left subtree, else current root
        // is smallest - transfer right subtree to t
        if (left.size() > 0) {
            leftMost = removeLeftMost(left);
            t.build(root, left, right);
        } else {
            t.transferFrom(right);
        }

        // Return smallest
        return leftMost;
    }

    /**
     * Removes and returns the right-most node in {@code t}.
     *
     * @param <T>
     *            type of {@code BinaryTree} nodes
     * @param t
     *            the {@code BinaryTree} from which to remove the node
     * @return the right-most node in the given {@code BinaryTree}
     * @updates t
     * @requires t.size > 0
     * @ensures [the right-most node in t is removed from t and returned] and
     *          [if the right-most node has a right subtree, then its right
     *          subtree will be moved to the position in the tree where the
     *          right-most node was]
     */
    public static <T> T removeRightMost(BinaryTree<T> t) {
        assert t != null : "Violation of: t is not null";

        // Declare/initialize left/right BT to hold t's subtrees, respectively,
        // then disassemble
        BinaryTree<T> left = t.leftSubtree();
        BinaryTree<T> right = t.rightSubtree();
        T root = t.root();

        // Set smallest to current root
        T rightMost = root;

        // If left subtree isn't the empty subtree then the current root is not
        // the smallest, recursively enter into left subtree, else current root
        // is smallest - transfer right subtree to t
        if (right.size() > 0) {
            rightMost = removeRightMost(right);
            t.build(root, left, right);
        } else {
            t.transferFrom(left);
        }

        // Return rightmost
        return rightMost;
    }
}
