public class maximum_non_negative_product_in_amatrix {
    public int maxProductPath(int[][] grid) {
        int mod = 1000000007;
        int m = grid.length;
        int n =grid[0].length;

        long[][] maxDp = new long[m][n];
        long[][] minDp = new long[m][n];

        maxDp[0][0] =grid[0][0];
        minDp[0][0] =grid[0][0];

        for (int j =1; j<n; j++){
               maxDp[0][j] =maxDp[0][j-1]*grid[0][j];
               minDp[0][j] =minDp[0][j-1]*grid[0][j];
        }
        for (int i=1; i<m; i++){
            maxDp[i][0] =maxDp[i-1][0]* grid[i][0];
            minDp[i][0] =minDp[i-1][0]* grid[i][0];
        }
        for (int i =1; i< m; i++){
            for (int j =1; j<n; j++){
                long topMax = maxDp[i-1][j] *grid[i][j];
                long topMin = minDp[i-1][j] * grid[i][j];
                long leftMin = minDp[i][j-1] *grid[i][j];
                long leftMax = maxDp[i][j-1]* grid[i][j];

                maxDp[i][j] = Math.max(Math.max(topMax,topMin),Math.max(leftMax,leftMin));
                minDp[i][j] = Math.min(Math.min(topMax, topMin), Math.min(leftMin, leftMax));
            }
        }
        if (maxDp[m-1][n-1]<0) return -1;
        return (int) ((maxDp[m-1][n-1]) %mod);
    }
    public static void main(String[] args) {
     maximum_non_negative_product_in_amatrix maximumNonNegativeProductInAmatrix = new maximum_non_negative_product_in_amatrix();
     int[][] grid = {{-1,-2,-3},{-2,-3,-3},{-3,-3,-2}};
        System.out.println(maximumNonNegativeProductInAmatrix.maxProductPath(grid));
    }
}
