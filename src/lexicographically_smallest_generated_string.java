import java.util.Arrays;

public class lexicographically_smallest_generated_string {
    public String generateString(String str1, String str2) {
        int n=str1.length(), m=str2.length();
        int N = n+m-1;
        char[] chars = new char[N];
        boolean[] check = new boolean[N];

        Arrays.fill(chars, '$');

        for (int i=0; i<n; i++){
            if (str1.charAt(i)=='T') {
                 int idx = i;
                 for (int j=0; j<m; j++){
                     if (chars[idx]!='$' && chars[idx]!=str2.charAt(j)){
                         return "";
                     }
                     chars[idx]= str2.charAt(j);
                     idx++;
                 }
            }
        }

        for (int i=0; i<N;i++){
            if (chars[i]=='$') {
                chars[i]='a';
                check[i]=true;
            }
        }

        for (int i=0; i<n; i++){
            if (str1.charAt(i)=='F'){
               if (isSame(chars,str2,i,m)){
                   boolean change =false;

                   for (int j =i+m-1; j>=i; j--){
                   if (check[j]){
                       chars[j] ='b';
                       check[j] =false;
                       change = true;
                       break;
                   }
                   }
                   if (!change) return "";
               }
            }
        }

      return new String(chars);
    }

    private boolean isSame(char[] word, String str2, int i, int m) {
        for (int j = 0; j < m; j++) {
            if (word[i] != str2.charAt(j)) return false;
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        lexicographically_smallest_generated_string lexicographicallySmallestGeneratedString = new lexicographically_smallest_generated_string();

        String str1="TFTF";
        String str2="ab";

        System.out.println(lexicographicallySmallestGeneratedString.generateString(str1,str2));
    }
}
