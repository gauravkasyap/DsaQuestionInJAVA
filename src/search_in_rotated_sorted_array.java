import java.util.HashMap;

public class search_in_rotated_sorted_array {
    public int search(int[] nums, int target) {
         int n = nums.length, i=0;
        HashMap<Integer,Integer> map= new HashMap<>();
          while (i<n){
              map.put(nums[i],i);
              i++;
          }
         return map.getOrDefault(target, -1);
    }
    public boolean searche(int[] nums, int target) {
        int n = nums.length, i=0;
        HashMap<Integer,Integer> map= new HashMap<>();
        while (i<n){
            map.put(nums[i],i);
            i++;
        }
        return map.containsKey(target);
    }
    public static void main(String[] args) {
      search_in_rotated_sorted_array searchInRotatedSortedArray = new search_in_rotated_sorted_array();
      int[] num = {4,5,6,7,0,1,2};
      int target = 0;

        System.out.println(searchInRotatedSortedArray.search(num,target));
        System.out.println(searchInRotatedSortedArray.searche(num,target));
    }
}
