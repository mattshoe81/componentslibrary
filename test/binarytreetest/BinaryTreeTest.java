package binarytreetest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.binarytree.BinaryTree;
import components.binarytree.BinaryTreeUtility;

public abstract class BinaryTreeTest {

    protected abstract BinaryTree<String> constructorTest();

    protected abstract BinaryTree<String> constructorRef();

    /***************************************************************************
     * root tests
     */
    @Test
    public void rootTest_routine() {
        String treeString = "a(b()())(c()())";
        String treeStringExp = treeString;
        BinaryTree<String> test = BinaryTreeUtility.treeFromString(treeString);
        BinaryTree<String> exp = BinaryTreeUtility
                .treeFromString(treeStringExp);
        String root;
        String expRoot = "a";

        root = test.root();

        assertEquals(exp, test);
        assertEquals(expRoot, root);
    }

    /***************************************************************************
     * remove Tests
     */
    @Test
    public void removeTest_routineLeftSubtree() {
        String treeString = "a(b(d()())(e()()))(c(f()())(g()()))";
        String treeStringExp = "a(e(d()())())(c(f()())(g()()))";
        BinaryTree<String> test = BinaryTreeUtility.treeFromString(treeString);
        BinaryTree<String> exp = BinaryTreeUtility
                .treeFromString(treeStringExp);
        String removal = "b";

        test.remove(removal);

        assertEquals(exp, test);
    }

    @Test
    public void removeTest_routineRightSubtree() {
        String treeString = "a(b(d()())(e()()))(c(f()())(g()()))";
        String treeStringExp = "f(b(d()())(e()()))(c()(g()()))";
        BinaryTree<String> test = BinaryTreeUtility.treeFromString(treeString);
        BinaryTree<String> exp = BinaryTreeUtility
                .treeFromString(treeStringExp);
        String removal = "a";

        test.remove(removal);

        assertEquals(exp, test);
    }

    @Test
    public void removeTest_leftUnbalancedNonTrivial() {
        String treeString = "a(b(d()(g()()))(e(h()())()))(c()(f(i()())(j()())))";
        String treeStringExp = "a(h(d()(g()()))(e()()))(c()(f(i()())(j()())))";
        BinaryTree<String> test = BinaryTreeUtility.treeFromString(treeString);
        BinaryTree<String> exp = BinaryTreeUtility
                .treeFromString(treeStringExp);
        String removal = "b";

        test.remove(removal);

        assertEquals(exp, test);
    }

    @Test
    public void removeTest_leftLeaf() {
        String treeString = "a(b(d()(g()()))(e(h()())()))(c()(f(i()())(j()())))";
        String treeStringExp = "a(b(d()(g()()))(e()()))(c()(f(i()())(j()())))";
        BinaryTree<String> test = BinaryTreeUtility.treeFromString(treeString);
        BinaryTree<String> exp = BinaryTreeUtility
                .treeFromString(treeStringExp);
        String removal = "h";

        test.remove(removal);

        assertEquals(exp, test);
    }

    @Test
    public void removeTest_rightLeaf() {
        String treeString = "a(b(d()(g()()))(e(h()())()))(c()(f(i()())(j()())))";
        String treeStringExp = "a(b(d()())(e(h()())()))(c()(f(i()())(j()())))";
        BinaryTree<String> test = BinaryTreeUtility.treeFromString(treeString);
        BinaryTree<String> exp = BinaryTreeUtility
                .treeFromString(treeStringExp);
        String removal = "g";

        test.remove(removal);

        assertEquals(exp, test);
    }

    /***************************************************************************
     * size Tests
     */
    @Test
    public void sizeTest_routine() {
        String treeString = "a(b(d()())(e()()))(c(f()())(g()()))";
        BinaryTree<String> test = BinaryTreeUtility.treeFromString(treeString);
        int sizeExp = 7;
        int size;

        size = test.size();

        assertEquals(sizeExp, size);
    }

    /***************************************************************************
     * equals Tests
     */
    @Test
    public void equalsTest_routine() {
        String treeString = "a(b(d()())(e()()))(c(f()())(g()()))";
        BinaryTree<String> test = BinaryTreeUtility.treeFromString(treeString);
        BinaryTree<String> exp = BinaryTreeUtility.treeFromString(treeString);

        assertEquals(exp, test);
    }

}
