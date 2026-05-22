import java.util.Objects;

public class shortest_distance_to_target_string_in_a_circular_array {
    public int closestTarget(String[] words, String target, int startIndex) {
        if (Objects.equals(words[startIndex], target)) return startIndex;
        int n =words.length;
        int path =Integer.MAX_VALUE;
        int right =0;
        for (int i=startIndex; i<n+n; i++){
            right++;
            if (Objects.equals(words[(i+1) % n], target)){
                path = Math.min(path, right);
            }
        }
        int left =0;
        for (int i=startIndex; i>(-n); i--){
            left++;
            if (Objects.equals(words[(i - 1+ n) % n], target)){
                path = Math.min(path, left);
            }
        }

       return path==Integer.MAX_VALUE ? -1:path;
    }
    public static void main(String[] args) {
     shortest_distance_to_target_string_in_a_circular_array shortestDistanceToTargetStringInACircularArray =new shortest_distance_to_target_string_in_a_circular_array();
        String[] words = {"ibkgecmeyx","jsdkekkjsb","gdjgdtjtrs","jsdkekkjsb","jsdkekkjsb","jsdkekkjsb","gdjgdtjtrs","msjlfpawbx","pbgjhutcwb","gdjgdtjtrs"};
        String target = "pbgjhutcwb";
        int start = 0;
     System.out.println(shortestDistanceToTargetStringInACircularArray.closestTarget(words,target,start));
    }
}
