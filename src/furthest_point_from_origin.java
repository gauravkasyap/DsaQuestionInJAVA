public class furthest_point_from_origin {
    public int furthestDistanceFromOrigin(String moves) {
        int l = 0, r = 0, blanks = 0;

        for (char c : moves.toCharArray()) {
            if (c == 'L') l++;
            else if (c == 'R') r++;
            else blanks++;
        }
        return Math.abs(l - r) + blanks;
    }
    public static void main(String[] args) {
        furthest_point_from_origin furthestPointFromOrigin = new furthest_point_from_origin();

        String moves = "L_RL__R";

        System.out.println(furthestPointFromOrigin.furthestDistanceFromOrigin(moves));
    }
}
