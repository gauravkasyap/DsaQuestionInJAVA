import java.util.HashMap;
import java.util.Map;

public class minimum_absolute_distance_between_mirror_pairs {
//    public int minMirrorPairDistance(int[] nums) {
//        int minimum=Integer.MAX_VALUE;
//
//       boolean[] check = new boolean[nums.length];
//       for (int i =0; i<nums.length; i++){
//           int rev = reversNum(nums[i]);
//          for (int j=i+1;j<nums.length; j++){
//              if (nums[j]==rev && i!=j && !check[j]){
//                  minimum = Math.min(minimum,Math.abs(i-j));
//                  check[j] =true;
//                  break;
//              }
//          }
//       }
//       return minimum == Integer.MAX_VALUE ? -1:minimum;
//    }
//    public int reversNum(int num){
//        int n=0,rev = 0;
//        while (0<num){
//            n= num%10;
//            rev = rev*10+n;
//           num = num/10;
//        }
//
//        return rev;
//    }

    //********************************* optimize ********************

    public int minMirrorPairDistance(int[] nums) {
        int res = 100000, i = 0;
        HashMap<Integer, Integer> seen = new HashMap<>();

        for (int n : nums) {
            int r;
            if (seen.containsKey(n)) res = Math.min(res, i - seen.get(n));

            for (r = 0; n > 0; n /= 10) r = r * 10 + (n % 10);

            seen.put(r, i++);
        }

        return res == 100000 ? -1 : res;
    }
    public static void main(String[] args) {
         minimum_absolute_distance_between_mirror_pairs minimumAbsoluteDistanceBetweenMirrorPairs = new minimum_absolute_distance_between_mirror_pairs();
         int[] num = {120,21};
        System.out.println(minimumAbsoluteDistanceBetweenMirrorPairs.minMirrorPairDistance(num));
    }
}
