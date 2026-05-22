import java.util.Arrays;
import java.util.HashMap;

public class find_the_prefix_common_array_of_two_arrays {
    public int[] findCommon(int[] A,int[] B){
        int[] C = new int[A.length];
        HashMap<Integer,Integer> key = new HashMap<>();
        for (int i=0;i< A.length;i++ ){
            key.put(B[i],i);
            int j=0, c=0;
            while (j<=i){
                if (key.containsKey(A[j]))c++;
                j++;
            }
            C[i] =c;
        }
        return C;
    }
    public static void main(String[] args) {
        find_the_prefix_common_array_of_two_arrays findThePrefixCommonArrayOfTwoArrays = new find_the_prefix_common_array_of_two_arrays();
        int[] A = {2,3,1}, B= {3,1,2};
        System.out.println(Arrays.toString(findThePrefixCommonArrayOfTwoArrays.findCommon(A, B)));
    }
}
