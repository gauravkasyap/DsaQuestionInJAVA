public class count_submatrices_with_top_left_element_and_sum_less_than_k {
//    public int countSubmatrices(int[][] grid, int k) {
//        int n=grid.length;
//        int m =grid[0].length;
//        int count=0;
//        int[] num=new int[m];
//        for (int i=0; i<n; i++){
//            int sum=0;
//            for (int j=0; j<m;j++){
//                if (i==0 && sum<=k && grid[i][j]<=k){
//                    sum+=grid[i][j];
//                    count++;
//                    num[j]= sum;
//                }else if (grid[i][j]>k || sum>k) break;
//                if (i>0 && sum<=k && grid[i][j]<=k){
//                    sum+=num[j]+grid[i][j];
//                    count++;
//                    num[j]= sum;
//                }else if (grid[i][j]>k || sum>k) break;
//            }
//        }
//      return count-1;
//    }

    //***************************improve version****************************

    public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (i > 0) grid[i][j] += grid[i - 1][j];
                if (j > 0) grid[i][j] += grid[i][j - 1];
                if (i > 0 && j > 0) grid[i][j] -= grid[i - 1][j - 1];

                if (grid[i][j] <= k) count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        count_submatrices_with_top_left_element_and_sum_less_than_k countSubmatricesWithTopLeftElementAndSumLessThanK = new count_submatrices_with_top_left_element_and_sum_less_than_k();
        int[][] grid= {{7,7,10,9},{10,5,10,3}} ;
        int k =54;
        System.out.println(countSubmatricesWithTopLeftElementAndSumLessThanK.countSubmatrices(grid,k));
    }
}
