package components.binarytree;

/**
 * {@code BinaryTree} implemented as a recursive data structure, not layered on
 * any other components. The {@code NL} in {@code BinaryTreeNL} conveys that
 * this is a Non-Layered implementation.
 *
 * @author Matthew Shoemaker
 *
 * @param <T>
 */
public class BinaryTreeNL<T> extends BinaryTreeSecondary<T> {

    private BinaryTreeNL<T> left;
    private BinaryTreeNL<T> right;
    private T root;
    private int size;
    private int height;

    private void createNewRep() {
        this.size = 0;
        this.height = 0;
        this.left = null;
        this.right = null;
        this.root = null;
    }

    public BinaryTreeNL() {
        this.createNewRep();
    }

    @Override
    public void build(T root, BinaryTree<T> left, BinaryTree<T> right) {
        assert root != null : "Violation of: root is not null";
        assert left != null : "Violation of: left is not null";
        assert right != null : "Violation of: right is not null";
        assert left != this : "Violation of: left is not this";
        assert right != this : "Violation of: right is not this";
        assert left != right : "Violation of: left is not right";
        assert left instanceof BinaryTreeNL<?> : ""
                + "Violation of: left is a BinaryTreeNL<?>";
        assert right instanceof BinaryTreeNL<?> : ""
                + "Violation of: right is a BinaryTreeNL<?>";

        BinaryTreeNL<T> localLeft = (BinaryTreeNL<T>) left;
        BinaryTreeNL<T> localRight = (BinaryTreeNL<T>) right;
        if (localLeft.height > localRight.height) {
            this.height = 1 + localLeft.height;
        } else {
            this.height = 1 + localRight.height;
        }
        this.root = root;
        if (this.left == null) {
            this.left = new BinaryTreeNL<T>();
        }
        this.left.transferFrom(localLeft);
        if (this.right == null) {
            this.right = new BinaryTreeNL<T>();
        }
        this.right.transferFrom(localRight);

        this.size = 1 + localLeft.size + localRight.size;
    }

    @Override
    public BinaryTree<T> leftSubtree() {
        BinaryTree<T> localLeft = this.newInstance();
        localLeft.transferFrom(this.left);

        return localLeft;
    }

    @Override
    public BinaryTree<T> rightSubtree() {
        BinaryTree<T> localRight = this.newInstance();
        localRight.transferFrom(this.right);
        return localRight;
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
        this.root = localSource.root;
        this.size = localSource.size;
        localSource.createNewRep();
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

    @Override
    public int height() {
        return this.height;
    }

}
