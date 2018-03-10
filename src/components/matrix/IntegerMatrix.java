package components.matrix;

public class IntegerMatrix extends MatrixSecondary<Integer> {

    int[][] rep;

    private void createNewRep(int m, int n) {
        this.rep = new int[m][n];
    }

    public IntegerMatrix(int rows, int columns) {
        this.createNewRep(rows, columns);
    }

    @Override
    public Integer setEntry(Integer entry, int row, int column) {
        int originalEntry = this.rep[row][column];
        this.rep[row][column] = entry;

        return originalEntry;
    }

    @Override
    public Integer entry(int row, int column) {
        return this.rep[row][column];
    }

    @Override
    public void clear() {
        this.createNewRep(1, 1);

    }

    @Override
    public void transferFrom(Matrix<Integer> source) {
        // TODO Auto-generated method stub

    }

    @Override
    public Matrix<Integer> newInstance() {
        // TODO Auto-generated method stub
        return null;
    }

}
