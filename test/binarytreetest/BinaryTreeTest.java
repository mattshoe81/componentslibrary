package binarytreetest;

import components.binarytree.BinaryTree;
import components.binarytree.BinaryTreeNL;

public abstract class BinaryTreeTest {

    protected abstract BinaryTree<String> constructorTest();

    protected abstract BinaryTree<String> constructorRef();

    public BinaryTree<String> createFromArgsTest(int... args) {
        BinaryTree<String> tree = new BinaryTreeNL<>();

        return tree;
    }

}
