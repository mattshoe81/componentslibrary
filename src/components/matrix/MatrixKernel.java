/**
 *
 */
package components.matrix;

import components.standard.Standard;

/**
 * @author Matthew Shoemaker
 *
 */
public interface MatrixKernel<T> extends Standard<Matrix<T>> {

    public T setEntry(T entry, int row, int column);

    public T entry(int row, int column);
}
