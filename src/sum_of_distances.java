import java.util.*;

public class sum_of_distances {
    public long[] distance(int[] nums) {
     long[] dis = new long[nums.length];
        Map<Integer, Long> countMap = new HashMap<>();
        Map<Integer, Long> sumMap = new HashMap<>();

        // LEFT TO RIGHT
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];

            if (countMap.containsKey(val)) {
                long count = countMap.get(val);
                long sum = sumMap.get(val);

                dis[i] += (count * i - sum);
            }

            countMap.put(val, countMap.getOrDefault(val, 0L) + 1);
            sumMap.put(val, sumMap.getOrDefault(val, 0L) + i);
        }

        countMap.clear();
        sumMap.clear();

        for (int i = nums.length - 1; i >= 0; i--) {
            int val = nums[i];

            if (countMap.containsKey(val)) {
                long count = countMap.get(val);
                long sum = sumMap.get(val);

               dis[i] += (sum - count * i);
            }

            countMap.put(val, countMap.getOrDefault(val, 0L) + 1);
            sumMap.put(val, sumMap.getOrDefault(val, 0L) + i);
        }


//     for (int i=0; i<nums.length; i++){
//         for (int j=0; j<nums.length;j++){
//             if (i!=j && nums[i]==nums[j]){
//                 dis[i] += Math.abs(i-j);
//             }
//         }
//     }

     return dis ;
    }
    public static void main(String[] args) {
        sum_of_distances sum = new sum_of_distances();

        int[] num = {1, 3, 1, 1, 2};
        System.out.println(Arrays.toString(sum.distance(num)));
    }
}
