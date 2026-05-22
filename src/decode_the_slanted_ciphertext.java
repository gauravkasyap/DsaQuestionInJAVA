public class decode_the_slanted_ciphertext {
//    public String decodeCiphertext(String encodedText, int rows) {
//     StringBuilder decode = new StringBuilder();
//     int n =encodedText.length();
//     int colm = n / rows;
//     char[][] dp= new char[rows][colm];
//     int p=0;
//         for (int i =0;i<rows;i++){
//             for (int j =0; j<colm; j++){
//                 dp[i][j] = encodedText.charAt(p);
//                 p++;
//             }
//         }
//             for (int j=0; j<colm; j++){
//                 int i=0;
//                     int k=j;
//                     while (i<rows && k<colm){
//                         decode.append(dp[i][k]);
//                         i++;
//                         k++;
//                     }
//             }
//
//        return decode.toString();
//    }


    /////////////*************** second approach***********************
        public String decodeCiphertext(String s, int rows) {
            if (s.isEmpty()) return s;

            int n = s.length();
            int cols = (n + rows - 1) / rows;

            StringBuilder res = new StringBuilder();

            for (int start = 0; start < cols; start++) {
                int r = 0, c = start;
                while (r < rows && c < cols) {
                    res.append(s.charAt(r * cols + c));
                    r++; c++;
                }
            }

            int i = res.length();
            while (i > 0 && res.charAt(i - 1) == ' ') i--;
            return res.substring(0, i);
        }

    public static void main(String[] args) {
        decode_the_slanted_ciphertext decodeTheSlantedCiphertext = new decode_the_slanted_ciphertext();
       String s ="coding";
       int row =1;
        System.out.println(decodeTheSlantedCiphertext.decodeCiphertext(s,row));

    }
}
