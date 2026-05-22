public class robot_return_to_origin {
    public boolean judgeCircle(String moves) {
       int d=0,u=0,l=0,r=0;
       for (char c:moves.toCharArray()){
           if (c=='U') u++;
           if (c=='D') d++;
           if (c=='L') l++;
           if (c=='R') r++;
       }
        return d==u && l==r;
    }
    public static void main(String[] args) {
        robot_return_to_origin robotReturnToOrigin = new robot_return_to_origin();
         String moves ="RL";
        System.out.println(robotReturnToOrigin.judgeCircle(moves));
    }
}
