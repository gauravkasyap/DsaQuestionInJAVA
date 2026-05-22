import java.lang.reflect.Array;
import java.util.Arrays;

public class determine_whether_matrix_can_be_obtained_by_rotation {
    public boolean findRotation(int[][] mat, int[][] target) {
        int[][] revers = new int[mat.length][mat[0].length];
        for (int i=mat.length/2; i>=0; i--){
            for (int j =0; j<mat[0].length; j++){

            }
        }

        return Arrays.deepEquals(revers, target);
    }
    public static void main(String[] args) {
           determine_whether_matrix_can_be_obtained_by_rotation determineWhetherMatrixCanBeObtainedByRotation = new determine_whether_matrix_can_be_obtained_by_rotation();
           int[][] mat= {{0,0,0},{0,1,0},{1,1,1}};
           int[][] target={{1,1,1},{0,1,0},{0,0,0}};
        System.out.println(determineWhetherMatrixCanBeObtainedByRotation.findRotation(mat,target));
    }
}
