public class minimum_number_of_flips_to_make_the_binary_string_alternating {
    public int minFlips(String s) {
    int n =s.length();
    s=s+s;
     String s1="", s2="";
     for (int i=0;i<2*n;i++){
          s1 += (i%2==0 ? '0':'1');
          s2 +=(i%2==0 ? '1': '0');
     }

   int ans = Integer.MAX_VALUE;
     int flip1=0;
     int flip2=0;
     int i=0;
     int j=0;

     while (j<2*n){
         if (s.charAt(j)!=s1.charAt(j)) flip1++;

         if (s.charAt(j)!=s2.charAt(j)) flip2++;

         if (j-i+1>n){
             if (s.charAt(i)!=s1.charAt(i)) flip1--;
             if (s.charAt(i)!=s2.charAt(i)) flip2--;
             i++;
         }
         if (j-i+1==n) ans = Math.min(ans,Math.min(flip2,flip1));
         j++;
     }

     return ans;
    }
    // modified solution
    public int minFlipMod(String s){
        int ans =Integer.MAX_VALUE;
        int flip1=0;
        int flip2=0;
        int j =0,i=0;
        while (j<2*s.length()){
            char charS1 = (j%2==0 ? '0':'1');
            char charS2 = (j%2==0? '1':'0');
            if (s.charAt(j%s.length())!=charS1) flip1++;
            if (s.charAt(j%s.length())!=charS2) flip2++;

            if (j-i+1>s.length()){
                charS1 = (i%2==0 ? '0':'1');
                charS2 = (i%2==0? '1':'0');
                if (s.charAt(i%s.length())!=charS1) flip1--;
                if (s.charAt(i%s.length())!=charS2) flip2--;
                i++;
            }
            if (j-i+1==s.length()) ans = Math.min(ans,Math.min(flip2,flip1));
            j++;
        }
       return ans;
    }
    public static void main(String[] args) {
        minimum_number_of_flips_to_make_the_binary_string_alternating minimumNumberOfFlipsToMakeTheBinaryStringAlternating = new minimum_number_of_flips_to_make_the_binary_string_alternating();

        String s="01001001101";
        System.out.println(minimumNumberOfFlipsToMakeTheBinaryStringAlternating.minFlips(s));
        System.out.println(minimumNumberOfFlipsToMakeTheBinaryStringAlternating.minFlipMod(s));

    }
}
