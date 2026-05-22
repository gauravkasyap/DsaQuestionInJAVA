public class minimum_path_sum {
//    public int minPathSum(int[][] grid) {
//        for (int i =grid.length-1; i>=0; i--){
//            for (int j =grid[0].length-1; j>=0;j--){
//                if (i== grid.length-1 && j==grid[0].length-1 ){
//
//                } else if (i==grid.length-1) {
//                    grid[i][j] +=grid[i][j+1];
//                } else if (j==grid[0].length-1) {
//                    grid[i][j] +=grid[i+1][j];
//                }else {
//                    grid[i][j] += Math.min(grid[i][j+1],grid[i+1][j]);
//                }
//            }
//        }
//
//        return grid[0][0];
//    }
    //************************ same solution with other method ***********************
public int minPathSum(int[][] grid) {
    for (int i =0; i<1; i++){
        for (int j =1; j<grid[0].length;j++){
          grid[0][j]+=grid[i][j-1];
        }
    }
    for (int i=1; i<grid.length; i++){
        grid[i][0] +=grid[i-1][0];
    }
    for (int i =1; i< grid.length; i++){
        for (int j =1; j<grid[0].length; j++){
            grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
        }
    }

    return grid[grid.length-1][grid[0].length-1];
}

    public static void main(String[] args) {
        minimum_path_sum minimumPathSum= new minimum_path_sum();
        int[][] grid = {{1,2,3},{4,5,6}};
        System.out.println(minimumPathSum.minPathSum(grid));

    }
}
