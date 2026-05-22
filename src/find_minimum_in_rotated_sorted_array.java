import java.lang.reflect.Array;
import java.util.Arrays;

public class find_minimum_in_rotated_sorted_array {
    public int findMin(int[] nums) {
        Arrays.sort(nums);

        return nums[0];
    }
    public static void main(String[] args) {

    }
}
