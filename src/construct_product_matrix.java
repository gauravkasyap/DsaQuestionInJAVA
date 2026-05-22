import java.util.Arrays;

public class construct_product_matrix {
//    public int[][] constructProductMatrix(int[][] grid) {
//        int m =grid.length, n=grid[0].length;
//        int[][] prod = new int[m][n];
//        int mod =12345;
//        int p=0 , o=0;
//        for (int i=0; i<m*n; i++){
//            long mlt =1;
//            for (int j=0; j<m;j++){
//                for (int k=0; k<n; k++){
//                    if (p==j && o==k ){
//
//                    }else {
//                        mlt *=grid[j][k];
//                    }
//                }
//            }
//            prod[p][o] = (int) (mlt%mod);
//            if (o<n-1){
//                o++;
//            }else {
//              if (p<m-1) p++;
//              o=0;
//            }
//        }
//        return prod;
//    }
    //********************************optimize code*******************
public int[][] constructProductMatrix(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    int size = m * n;
    int mod = 12345;

    int[] arr = new int[size];

    // flatten matrix
    int idx = 0;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            arr[idx++] = grid[i][j] % mod;
        }
    }

    // prefix product
    int[] prefix = new int[size];
    prefix[0] = 1;
    for (int i = 1; i < size; i++) {
        prefix[i] = (prefix[i - 1] * arr[i - 1]) % mod;
    }

    // suffix product
    int[] suffix = new int[size];
    suffix[size - 1] = 1;
    for (int i = size - 2; i >= 0; i--) {
        suffix[i] = (suffix[i + 1] * arr[i + 1]) % mod;
    }

    // result
    int[][] result = new int[m][n];
    idx = 0;

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            result[i][j] = (prefix[idx] * suffix[idx]) % mod;
            idx++;
        }
    }

    return result;
}
    public static void main(String[] args) {
        construct_product_matrix constructProductMatrix =new construct_product_matrix();
        int[][] grid={{1,2},{3,4}};

        System.out.println(Arrays.deepToString(constructProductMatrix.constructProductMatrix(grid)));

    }
}
