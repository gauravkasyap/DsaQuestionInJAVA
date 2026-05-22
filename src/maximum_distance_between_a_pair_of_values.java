public class maximum_distance_between_a_pair_of_values {
    public int maxDistance(int[] nums1, int[] nums2) {
       int maxDis = 0;int j=0;int i=0;
       while ( i<nums1.length && j<nums2.length){
           if (i<=j && nums1[i]<=nums2[j]){
               maxDis = Math.max(maxDis,j-i);
              j++;
           } else if ( nums1[i]>nums2[j]) {
               j++; i++;
           } else if ( i>j) {
               j++;
           }
       }

       return maxDis;
    }
    public static void main(String[] args) {
       maximum_distance_between_a_pair_of_values maximumDistanceBetweenAPairOfValues = new maximum_distance_between_a_pair_of_values();
       int[] num1 = {9819,9508,7398,7347,6337,5756,5493,5446,5123,3215,1597,774,368,313};
       int[] num2 = {9933,9813,9770,9697,9514,9490,9441,9439,8939,8754,8665,8560};

        System.out.println(maximumDistanceBetweenAPairOfValues.maxDistance(num1,num2));
    }
}
