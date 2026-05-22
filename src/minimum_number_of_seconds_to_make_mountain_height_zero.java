public class minimum_number_of_seconds_to_make_mountain_height_zero {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long lo = 1, hi = 10000000000000000L;

        while (lo < hi) {
            long mid = (lo + hi) >> 1;
            long tot = 0;
            for (int i = 0; i < workerTimes.length && tot < mountainHeight; i++)
                tot += (long) (Math.sqrt((double) mid / workerTimes[i] * 2 + 0.25) - 0.5);
            if (tot >= mountainHeight)
                hi = mid;
            else
                lo = mid + 1;
        }

        return lo;
    }
    public static void main(String[] args) {
        minimum_number_of_seconds_to_make_mountain_height_zero minimumNumberOfSecondsToMakeMountainHeightZero =new minimum_number_of_seconds_to_make_mountain_height_zero();

        int height=4;
        int[] time={1,2,3,4};

        System.out.println(minimumNumberOfSecondsToMakeMountainHeightZero.minNumberOfSeconds(height,time));

    }
}
