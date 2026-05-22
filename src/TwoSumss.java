import java.util.Arrays;
import java.util.HashMap;

public class TwoSumss {
    public int[] twoSums(int[] num, int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<num.length; i++){
            int n = target-num[i];
            if (map.containsKey(n)){
                return new int[]{i, map.get(n)};
            }else {
                map.put(num[i], i);
            }
        }

        return new int[]{0, 0};
    }
    public static void main(String[] args) {
          TwoSumss twoSumss = new TwoSumss();

          int[] num = {4,5,3,8,7,9};
          int target =8;
        System.out.println(Arrays.toString(twoSumss.twoSums(num, target)));
    }
}
