public class maximum_product_subarray {
    public int maxProduct(int[] nums) {
        int maxPro= nums[0];
        for (int i =0; i<nums.length;i++){
            int prod= 1;
            for (int j =i; j<nums.length; j++){
                prod *= nums[j];
                maxPro = Math.max(prod,maxPro);
            }
        }
        return maxPro;
    }
    public static void main(String[] args) {
        maximum_product_subarray maximumProductSubarray = new maximum_product_subarray();
        int[] arr= {2,3,-2,4};

        System.out.println(maximumProductSubarray.maxProduct(arr));
    }
}
