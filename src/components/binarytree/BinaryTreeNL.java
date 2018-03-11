package components.binarytree;

public class BinaryTreeNL<T> extends BinaryTreeSecondary<T> {

    //    private class Node {
    //        Node left;
    //        Node right;
    //        T label;
    //
    //        Node() {
    //            this.left = null;
    //            this.right = null;
    //            this.label = null;
    //        }
    //
    //        Node(T label) {
    //            this.left = null;
    //            this.right = null;
    //            this.label = label;
    //        }
    //    }

    private BinaryTreeNL<T> left;
    private BinaryTreeNL<T> right;
    private T root;
    private int size;

    private void createNewRep() {
        this.size = 0;
        this.left = null;
        this.right = null;
        this.root = null;
    }

    public BinaryTreeNL() {
        this.createNewRep();
    }

    @Override
    public void build(T root, BinaryTree<T> left, BinaryTree<T> right) {
        BinaryTreeNL<T> localLeft = (BinaryTreeNL<T>) left;
        BinaryTreeNL<T> localRight = (BinaryTreeNL<T>) right;

        this.left = localLeft;
        this.right = localRight;
        this.root = root;

        int leftSize = left.size();
        int rightSize = right.size();
        int thisSize = this.size();

        this.size = left.size() + right.size() + 1;
    }

    @Override
    public BinaryTree<T> leftSubtree() {
        BinaryTree<T> left = this.left;
        return left;
    }

    @Override
    public BinaryTree<T> rightSubtree() {
        BinaryTree<T> right = this.right;
        return right;
    }

    @Override
    public T root() {
        return this.root;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        this.createNewRep();

    }

    @Override
    public void transferFrom(BinaryTree<T> source) {
        BinaryTreeNL<T> localSource = (BinaryTreeNL<T>) source;
        this.left = localSource.left;
        this.right = localSource.right;
        this.size = localSource.size;
        source.clear();
    }

    @SuppressWarnings("unchecked")
    @Override
    public BinaryTreeNL<T> newInstance() {
        try {
            return this.getClass().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

}
