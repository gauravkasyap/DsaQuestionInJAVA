import java.util.*;

public class minimum_distance_between_three_equal_elements_ii {
//    public int minimumDistance(int[] nums) {
//        int minDis=Integer.MAX_VALUE;
//        for (int i=0; i<nums.length; i++){
//            int[] tuple =new int[3];
//            int p=nums[i],j=i, k=0;
//            while (j<nums.length ){
//                if (p==nums[j] && k<3){
//                    tuple[k] = j;
//                    k++;
//                }
//                j++;
//            }
//            if (k==3) {
//                Arrays.sort(tuple);
//                int x = 2 * (tuple[2] - tuple[0]);
//                minDis = Math.min(minDis, x);
//            }
//        }
//        return minDis==Integer.MAX_VALUE ? -1: minDis;
//    }

    //*****************************optimize *********************

    public int minimumDistance(int[] nums) {

        int minDis=Integer.MAX_VALUE;
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int k=0; k<nums.length; k++){
            map.putIfAbsent(nums[k], new ArrayList<>());
            map.get(nums[k]).add(k);

            if (map.get(nums[k]).size()>=3) {
                List<Integer> tuple = map.get(nums[k]);
                int size = tuple.size();
                int i= tuple.get(size-3);
                minDis = Math.min(minDis,2*(k-i));
            }
        }
        return minDis==Integer.MAX_VALUE ? -1: minDis;
    }
    public static void main(String[] args) {
      minimum_distance_between_three_equal_elements_ii minimumDistanceBetweenThreeEqualElementsIi =new minimum_distance_between_three_equal_elements_ii();
      int[] nums={5,3,5,5,5};
        System.out.println(minimumDistanceBetweenThreeEqualElementsIi.minimumDistance(nums));
    }
}
