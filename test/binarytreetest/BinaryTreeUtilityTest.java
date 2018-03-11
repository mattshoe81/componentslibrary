package binarytreetest;

import org.junit.Test;

import components.binarytree.BinaryTree;
import components.binarytree.BinaryTreeUtility;

public class BinaryTreeUtilityTest {

    @Test
    public void treeFromStringTest() {
        String treeString = "a(b(d()())())(c()(e()()))";
        BinaryTree<String> tree = BinaryTreeUtility.treeFromString(treeString);

        System.out.println(tree.toString());
    }
}
