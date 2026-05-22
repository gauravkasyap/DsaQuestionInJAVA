public class two_furthest_houses_with_different_colors {
    public int maxDistance(int[] colors) {
        int maxDis =0;
         for (int i =0; i<colors.length; i++){
             for (int j=i+1; j<colors.length; j++) {
                 if (colors[i] != colors[j]) {
                     maxDis = Math.max(maxDis, Math.abs(i - j));
                 }
             }
         }
         return maxDis;
    }
    public static void main(String[] args) {
       two_furthest_houses_with_different_colors twoFurthestHousesWithDifferentColors = new two_furthest_houses_with_different_colors();
       int[] colors = {4,4,4,11,4,4,11,4,4,4,4,4};

        System.out.println(twoFurthestHousesWithDifferentColors.maxDistance(colors));
    }
}
