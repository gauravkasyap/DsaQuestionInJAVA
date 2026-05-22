public class complement_of_base_10_integer {
    public int bitwiseComplement(int n) {
        if(n==0) return 1;
    int value=0;
    StringBuilder str = new StringBuilder();
    while (n>0){
        String p = String.valueOf(n%2);
        if (p.equals("1"))str.append("0");
        if (p.equals("0")) str.append("1");
        n=n/2;
    }
    for (int i=0; i<str.length();i++){
       if (str.charAt(i)=='1')value += (int) Math.pow(2,i);
    }
    return value;
    }
    public static void main(String[] args) {
      complement_of_base_10_integer complementOfBase10Integer = new complement_of_base_10_integer();
      int n =0;
        System.out.println(complementOfBase10Integer.bitwiseComplement(n));
    }
}
