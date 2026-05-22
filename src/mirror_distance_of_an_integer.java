public class mirror_distance_of_an_integer {
    public int mirrorDistance(int n) {
        int p = n;
        int rev =0;
        while(p>0){
            rev = rev*10+(p%10);
            p =p/10;
        }
        return Math.abs(rev -n);
    }
    public static void main(String[] args) {
     mirror_distance_of_an_integer mirrorDistanceOfAnInteger =new mirror_distance_of_an_integer();
     int n =7;
        System.out.println(mirrorDistanceOfAnInteger.mirrorDistance(n));
    }
}
