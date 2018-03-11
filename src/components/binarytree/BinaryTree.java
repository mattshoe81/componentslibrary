package components.binarytree;

public interface BinaryTree<T> extends BinaryTreeKernel<T> {

    public int height();

    public T replaceRoot(T replacement);

    public void remove(T node);

    public boolean contains(T node);
}
