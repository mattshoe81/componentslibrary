package components.binarytree;

public final class BinaryTreeUtility {

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
}
