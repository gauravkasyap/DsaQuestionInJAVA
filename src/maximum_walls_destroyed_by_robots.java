import java.util.Arrays;

public class maximum_walls_destroyed_by_robots {
//    public int maxWalls(int[] robots, int[] distance, int[] walls) {
//        int DWall=0;
//        Arrays.sort(walls);
//         for (int i=0; i<robots.length ;i++){
//             for (int j=0; j<walls.length; j++){
//                 if ( robots[i]-distance[i]<=walls[j] && (distance[i]>=walls[j]||robots[i]>=walls[j]) ){
//                     if (i+1!=robots.length && robots[i]-distance[i]<=robots[i+1] && (distance[i]>=robots[i+1]||robots[i]>=robots[i+1])) break;
//                    DWall++;
//                 } else if (robots[i]+distance[i]>=walls[j]&& (robots[i]<=walls[j] || distance[i]<=walls[j])) {
//                     if (i+1!=robots.length && robots[i]+distance[i]>=robots[i+1]&&(robots[i]<=walls[j] || distance[i]<=walls[j])) break;
//                     DWall++;
//                 }
//             }
//         }
//        return DWall;
//    }

 public int maxWalls(int[] robots,int[] distances,int[] walls) {
     int n =robots.length;
     int[][] r = new int[n+2][2];
     for (int i=0; i<n; i++){
         r[i][0]=robots[i];
         r[i][1]=distances[i];
     }
     r[n][0]=-1;
     r[n][1]=0;
     r[n+1][0] =Integer.MAX_VALUE;
     r[n+1][1] =0;

     Arrays.sort(r,(a,b)->Integer.compare(a[0],b[0]));
     Arrays.sort(walls);

     int ll=0,lr=1,rl=2,rr=3;
     int[] dp =new int[4];
     int leftRobot =0;
     int rightRobot =1;

     for (int wall:walls){
         while (wall>r[rightRobot][0]){
             leftRobot++;
             rightRobot++;

             int maxL = Math.max(dp[ll],dp[rl]);
             int maxR = Math.max(dp[lr],dp[rr]);

             dp[ll] = maxL;
             dp[lr] = maxL;

             dp[rl] = maxR;
             dp[rr] = maxR;
         }

         int r1Reach = r[leftRobot][0]+r[leftRobot][1];
         int r2Reach = r[rightRobot][0]+r[rightRobot][0];

         boolean canR1 = wall<=r1Reach;
         boolean canR2 = wall>=r2Reach;

         boolean isRightPoint = wall ==r[rightRobot][0];

         if (canR2) dp[ll]++;
         if (isRightPoint) dp[lr]++;
         if (canR1|| canR2) dp[rl]++;
         if (canR1|| isRightPoint) dp[rr]++;
     }

     int ans =0;
     for (int v:dp){
         ans = Math.max(v,ans);
     }

     return ans;
 }
    public static void main(String[] args) {
       maximum_walls_destroyed_by_robots maximumWallsDestroyedByRobots = new maximum_walls_destroyed_by_robots();

       int[] r ={1,2};
       int[] d = {100,1};
       int[] w ={10};

        System.out.println(maximumWallsDestroyedByRobots.maxWalls(r,d,w));
    }
}
