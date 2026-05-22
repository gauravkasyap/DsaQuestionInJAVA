public class minimum_common_value {
    public int getCommon(int[] nums1, int[] nums2) {
     int min = Integer.MAX_VALUE, right=0,left=0;

     while (right<nums2.length && left<nums1.length){
         if (nums1[left]<nums2[right]) left++;
         else if (nums1[left]>nums2[right]) {
             right++;
         }else {
             if (min>nums1[left]) min =nums1[left];
             left++;
             right++;
         }
     }

     return min==Integer.MAX_VALUE ? -1: min;
    }

    public static void main(String[] args) {
         minimum_common_value minimumCommonValue= new minimum_common_value();
         int[] num1 = {1,2,3,6};
         int[] num2 = {0,3,4,5};

        System.out.println(minimumCommonValue.getCommon(num1,num2));
    }
}
