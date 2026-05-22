import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class minimum_total_distance_traveled {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);

        int n = robot.size();
        int m = factory.length;

        long INF = (long)1e18;
        long[][] dp = new long[n + 1][m + 1];

        for (int i = 0; i <= n; i++)
            Arrays.fill(dp[i], INF);

        for (int j = 0; j <= m; j++)
            dp[0][j] = 0;

        for (int j = 1; j <= m; j++) {
            int pos = factory[j - 1][0];
            int limit = factory[j - 1][1];

            for (int i = 0; i <= n; i++) {
                dp[i][j] = dp[i][j - 1];

                long dist = 0;
                for (int k = 1; k <= limit && i - k >= 0; k++) {
                    dist += Math.abs(robot.get(i - k) - pos);
                    dp[i][j] = Math.min(dp[i][j], dp[i - k][j - 1] + dist);
                }
            }
        }

        return dp[n][m];
    }
    public static void main(String[] args) {
        minimum_total_distance_traveled minimumTotalDistanceTraveled = new minimum_total_distance_traveled();

        int[][] factory = {{2,2},{6,2}};
        List<Integer> robot = new ArrayList<>();
        robot.add(0);
        robot.add(4);
        robot.add(6);

        System.out.println(minimumTotalDistanceTraveled.minimumTotalDistance(robot,factory));

    }
}
