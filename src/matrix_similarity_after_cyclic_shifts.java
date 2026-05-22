import java.lang.reflect.Array;
import java.util.Arrays;

public class matrix_similarity_after_cyclic_shifts {
//    public boolean areSimilar(int[][] mat, int k) {
//        int m=mat.length, n =mat[0].length;
//      int[][] identical = new int[m][n];
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                identical[i][j] = mat[i][j];
//            }
//        }
//      while (k>0){
//          for (int i=0; i<m;i++){
//              int[] p =identical[i].clone();
//              for (int j=0; j<n; j++) {
//                  if (i % 2 == 0) {
//                      int l = j - 1;
//                      if (l < 0) identical[i][n - 1] = p[j];
//                      else identical[i][l] = p[j];
//                  } else {
//                      if (j + 1 >= m) identical[i][0] = p[j];
//                      else identical[i][j + 1] = p[j];
//                  }
//              }
//          }
//          k--;
//      }
//      return Arrays.deepEquals(mat,identical);
//    }
    //***********************optimize code*********************

    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        k = k % n;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int newIndex;

                if (i % 2 == 0) {
                    // left shift
                    newIndex = (j + k) % n;
                } else {
                    // right shift
                    newIndex = (j - k % n + n) % n;
                }

                if (mat[i][j] != mat[i][newIndex]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        matrix_similarity_after_cyclic_shifts matrixSimilarityAfterCyclicShifts = new matrix_similarity_after_cyclic_shifts();

        int[][] mat ={{1,2,1,2},{5,5,5,5},{6,3,6,3}};
        int k=4;

        System.out.println(matrixSimilarityAfterCyclicShifts.areSimilar(mat,k));

    }
}
