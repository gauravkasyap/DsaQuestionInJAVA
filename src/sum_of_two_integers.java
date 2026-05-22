public class sum_of_two_integers {
    public int sum(int a, int b){

//       int xor = a^b;
//       int carry = a&b;
//        carry<<=1;
//       xor = carry^xor;
//        return xor ;

        //**************different way but it works on only -320 t0 320 nums
//        long sum = (long) Math.log10(Math.pow(10,a)*Math.pow(10,b));
//        return (int) sum;

//***************modified solution of upper***************

        while (b != 0) {
            int sum = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }
    public static void main(String[] args) {
     sum_of_two_integers sumOfTwoIntegers = new sum_of_two_integers();
     int a = 5, b = -877;
     System.out.println(sumOfTwoIntegers.sum(a,b));
    }
}
