package binarytreetest;

import components.binarytree.BinaryTree;
import components.binarytree.BinaryTreeNL;

public class BinaryTreeNLTest extends BinaryTreeTest {

    @Override
    protected BinaryTree<String> constructorTest() {
        return new BinaryTreeNL<String>();
    }

    @Override
    protected BinaryTree<String> constructorRef() {
        return new BinaryTreeNL<String>();
    }

}
