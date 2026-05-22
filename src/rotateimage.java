import java.util.Arrays;

public class rotateimage {
    public void rotate(int[][] matrix) {
        int n = matrix.length, k = n - 1;
        for (int i = 0; i < n >> 1; i++)
            for (int j = i; j < k - i; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[k - j][i];
                matrix[k - j][i] = matrix[k - i][k - j];
                matrix[k - i][k - j] = matrix[j][k - i];
                matrix[j][k - i] = t;
            }
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void main(String[] args) {
        rotateimage rotateimage = new rotateimage();

        int[][] matrx = {{1,2,3},{4,5,6},{7,8,9}};
        rotateimage.rotate(matrx);

    }
}
