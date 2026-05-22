public class rotate_function {
    // ************************to slow***************
    public int maxRotateFunction(int[] nums) {
       int n =nums.length;
       int maxFun =Integer.MIN_VALUE;
       for (int i=0; i<n; i++){
           int fun =0;
           int j =i,k=0;
           while (j<n+i){
               fun += (k)*nums[j%n];
               j++;
               k++;
           }
        maxFun = Math.max(fun,maxFun);
       }
       return maxFun;
    }
    public static void main(String[] args) {
        rotate_function rotateFunction = new rotate_function();

        int[] num = {400};
        System.out.println( rotateFunction.maxRotateFunction(num));
    }
}
