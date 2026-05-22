import java.util.HashSet;
import java.util.Set;

public class find_unique_binary_string {
    public String findDifferentBinaryString(String[] nums) {

        int n = nums.length;
        int size = (int)Math.pow(2, n);

        int[] nu = new int[size];

        for(String num : nums){
            int val = Integer.parseInt(num, 2);
            nu[val]++;
        }

        for(int i = 0; i < size; i++){
            if(nu[i] == 0){
                String ans = Integer.toBinaryString(i);
                return "0".repeat(n - ans.length()) + ans;
            }
        }

        return "0".repeat(n);
    }


    public static void main(String[] args) {
        find_unique_binary_string findUniqueBinaryString =new find_unique_binary_string();

        String[] strings = {"111","011","001"};
        System.out.println(findUniqueBinaryString.findDifferentBinaryString(strings));

    }
}
