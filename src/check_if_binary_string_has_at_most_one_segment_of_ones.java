public class check_if_binary_string_has_at_most_one_segment_of_ones {
    public boolean checkOnesSegment(String s) {
        if (s.charAt(0)=='0') return false;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='1') continue;
            if (s.charAt(i)=='0'){
                int j=i;
                while ( j<s.length()){
                    if (s.charAt(j)=='1')return false;
                    j++;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        check_if_binary_string_has_at_most_one_segment_of_ones checkIfBinaryStringHasAtMostOneSegmentOfOnes=new check_if_binary_string_has_at_most_one_segment_of_ones();
        String s = "1";
        System.out.println(checkIfBinaryStringHasAtMostOneSegmentOfOnes.checkOnesSegment(s));
    }
}
