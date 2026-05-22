import java.util.Arrays;
import java.util.Stack;

public class largest_rectangle_in_histogram {
//    public int largestRectangleArea(int[] heights) {
//        int rect=Integer.MIN_VALUE;
//        if (heights.length==1) return heights[0];
//
//        for (int i=0; i<heights.length; i++){
//            int sum=0;
//            for (int j=i; j<heights.length; j++){
//                if (heights[j]>=heights[i])sum +=heights[j] -(heights[j]-heights[i]);
//                else break;
//            }
//            if ( i>0 && heights[i-1]>=heights[i]){
//                for (int k =i-1 ; k>=0; k--){
//                    if (heights[k]>=heights[i])sum +=heights[k] -(heights[k]-heights[i]);
//                    else break;
//                }
//            }
//            rect = Math.max(rect,sum);
//        }
//        return rect;
//    }
    //*****************optimize code************************
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int currHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
    public static void main(String[] args) {
      largest_rectangle_in_histogram largestRectangleInHistogram = new largest_rectangle_in_histogram();

      int[] rect={2,1,5,6,2,3};

        System.out.println(largestRectangleInHistogram.largestRectangleArea(rect));
    }
}
