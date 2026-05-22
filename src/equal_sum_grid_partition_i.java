public class equal_sum_grid_partition_i {
//    public boolean canPartitionGrid(int[][] grid) {
//        int m = grid.length; int n = grid[0].length;
//
//        if (m%2==0){
//            int sum=0, sum1=0 ;
//            for (int i=0; i<m/2;i++){
//                for (int j=0; j<n;j++){
//                    sum +=grid[i][j];
//                }
//            }
//
//            for (int i=m/2; i<m;i++){
//                for (int j=0; j<n;j++){
//                    sum1 +=grid[i][j];
//                }
//            }
//           if (sum==sum1)return true;
//        }
//        if (n%2==0){
//            int sum=0, sum1=0 ;
//            for (int i=0; i<m;i++){
//                for (int j=0; j<n/2;j++){
//                    sum +=grid[i][j];
//                }
//            }
//
//            for (int i=0; i<m;i++){
//                for (int j=n/2; j<n;j++){
//                    sum1 +=grid[i][j];
//                }
//            }
//            if (sum==sum1)return true;
//        }
//        if (m%2!=0){
//            int sum=0, sum1=0 ;
//            for (int i=0; i<m/2;i++){
//                for (int j=0; j<n;j++){
//                    sum +=grid[i][j];
//                }
//            }
//
//            for (int i=m/2; i<m;i++){
//                for (int j=0; j<n;j++){
//                    sum1 +=grid[i][j];
//                }
//            }
//            if (sum==sum1)return true;
//        }
//        if (m%2!=0) {
//            int sum=0, sum1=0 ;
//            for (int i=0; i<(m-(m/2));i++){
//                for (int j=0; j<n;j++){
//                    sum +=grid[i][j];
//                }
//            }
//
//            for (int i=(m-(m/2)); i<m;i++){
//                for (int j=0; j<n;j++){
//                    sum1 +=grid[i][j];
//                }
//            }
//            if (sum==sum1)return true;
//        }
//
//        if (n%2!=0){
//            int sum=0, sum1=0 ;
//            for (int i=0; i<m;i++){
//                for (int j=0; j<n/2;j++){
//                    sum +=grid[i][j];
//                }
//            }
//
//            for (int i=0; i<m;i++){
//                for (int j=n/2; j<n;j++){
//                    sum1 +=grid[i][j];
//                }
//            }
//            if (sum==sum1)return true;
//        }
//        if (n%2!=0){
//            int sum=0, sum1=0 ;
//            for (int i=0; i<m;i++){
//                for (int j=0; j<(n-(n/2));j++){
//                    sum +=grid[i][j];
//                }
//            }
//
//            for (int i=0; i<m;i++){
//                for (int j=(n-(n/2)); j<n;j++){
//                    sum1 +=grid[i][j];
//                }
//            }
//            if (sum==sum1)return true;
//        }
//
//        return false;
//    }
                  //8888888888888888888888888888888888888888Optimize solution by me888888888888888888888888888888888888
//    public boolean canPartitionGrid(int[][] grid) {
//        int m = grid.length; int n = grid[0].length;
//
//        for (int i=1; i<m;i++){
//            int sum =0, sum1=0;
//            for (int j =0; j<i;j++){
//                for (int k=0; k<n; k++){
//                    sum +=grid[j][k];
//                }
//            }
//
//            for (int j=i; j<m; j++){
//                for (int k=0; k<n;k++){
//                    sum1 +=grid[j][k];
//                }
//            }
//            if (sum==sum1) return true;
//        }
//
//        for (int i=1; i<n;i++){
//            int sum =0, sum1=0;
//            for (int j =0; j<m;j++){
//                for (int k=0; k<i; k++){
//                    sum +=grid[j][k];
//                }
//            }
//
//            for (int j=0; j<m; j++){
//                for (int k=i; k<n;k++){
//                    sum1 +=grid[j][k];
//                }
//            }
//            if (sum==sum1) return true;
//        }
//
//        return false;
//    }
    ///////////////////////////////////////////optimize by Ai//////////////////////////////////

    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        long total = 0;

        for (int[] row : grid) {
            for (int val : row) {
                total += val;
            }
        }

       long prefix = 0;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                prefix += grid[i][j];
            }

            if (prefix == total - prefix) return true;
        }

        prefix = 0;
        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < m; i++) {
                prefix += grid[i][j];
            }

            if (prefix == total - prefix) return true;
        }

        return false;
    }
    public static void main(String[] args) {
        equal_sum_grid_partition_i equalSumGridPartitionI = new equal_sum_grid_partition_i();
        int[][] grid ={{1,4},{2,3}};

        System.out.println(equalSumGridPartitionI.canPartitionGrid(grid));
    }
}
