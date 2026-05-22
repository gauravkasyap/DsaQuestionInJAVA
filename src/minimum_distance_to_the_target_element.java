public class minimum_distance_to_the_target_element {
    public int getMinDistance(int[] nums, int target, int start) {
      int x =Integer.MAX_VALUE;
      for (int i=0; i<nums.length;i++){
          if (nums[i]==target){
              x=Math.min(x,Math.abs(i-start));
          }
      }
      return x;
    }
    public static void main(String[] args) {
            minimum_distance_to_the_target_element minimumDistanceToTheTargetElement = new minimum_distance_to_the_target_element();
            int target = 1,start=0;
            int[] num ={1,1,1,1,1,1,1,1,1,1};
        System.out.println(minimumDistanceToTheTargetElement.getMinDistance(num,target,start));
    }
}
