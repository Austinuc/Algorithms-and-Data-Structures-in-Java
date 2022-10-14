package GeneralAlgorithms;
import java.util.List;

public class DiagonalDifference {

    /**
     * calculates the absolute difference between the sums of the diagonals of a square matrix
     * Method: used two pointers i & j to traverse the matrix diagonally in opposite direction
     *
     * @param squareMatrix
     * @return: the absolute difference btw the two diags of the 2D-Array
     */
    public static int diagonalDifference(List<List<Integer>> squareMatrix) {

        Integer left = 0, right = 0;
        for (int i = 0, j = squareMatrix.get(0).size() - 1; i < squareMatrix.get(0).size(); i++, j--) {
            left += squareMatrix.get(i).get(i); //sums diagonally from upper left to lower right
            right += squareMatrix.get(j).get(i); //sumgits diagonally from upper right to lower left
        }

        return Math.abs(left - right);
    }
}
