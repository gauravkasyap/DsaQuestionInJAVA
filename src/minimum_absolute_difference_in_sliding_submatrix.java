import java.util.*;

public class minimum_absolute_difference_in_sliding_submatrix {
    //*************************wrong answer by me ******************
//    public int[][] minAbsDiff(int[][] grid, int k) {
//        int m =grid.length;
//        int n = grid[0].length;
//        int[][] ans= new int[m-k+1][n-k+1];
//        if (k==1) return ans;
//        int big = Math.max(m-k+1,n-k+1);
//        int count=0;
//        int ik=k,jk=k;
//        for (int l =0;l<big; l++){
//            int[] num= new int[k*k];
//            int p=0;
//            int i=0;
//            while ( i<ik ){
//                int j=count;
//                while ( j<jk ){
//                    num[p] = grid[i][j];
//                    p++;
//                    j++;
//                }
//                i++;
//            }
//            if (m>ik){
//                i++;
//                ik++;
//            }
//            if (n>jk){
//                count++;
//                jk++;
//            }
//            int abs= Integer.MAX_VALUE;
//            for (int o =0; o<num.length; o++){
//                for (int q =0; q<num.length; q++){
//                    if (o!=q && num[o]!=num[q]){
//                        abs = Math.min(abs,Math.abs(num[o]-num[q]));
//                    }
//                }
//            }
//            ans[0][0]=abs;
//        }
//
//        return ans;
//    }
    public int[][] minAbsDiff(int[][] grid, int k) {
        int n = grid[0].length;
        int m = grid.length;
        int[][] ans= new int[m-k+1][n-k+1];
        for (int i=0; i<=m-k; i++){
            for (int j =0; j<=n-k; j++){
                TreeSet<Integer> set = new TreeSet<>();
                for (int l = i; l<=i+k-1; l++){
                    for (int o = j; o<=j+k-1; o++){
                        set.add(grid[l][o]);
                    }
                }
                if (set.size() < 2) {
                    ans[i][j] = 0;
                    continue;
                }
                int abs =Integer.MAX_VALUE;
                Integer prev = null;
                for (Integer curr : set) {
                    if (prev != null) {
                       abs = Math.min(abs, curr - prev);
                    }
                    prev = curr;
                }
                ans[i][j] = abs;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
      minimum_absolute_difference_in_sliding_submatrix minimumNumberOfSecondsToMakeMountainHeightZero = new minimum_absolute_difference_in_sliding_submatrix();
      int[][] grid={{3,-1}};
      int k=1;

        System.out.println(Arrays.deepToString(minimumNumberOfSecondsToMakeMountainHeightZero.minAbsDiff(grid, k)));
    }
}
