import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;

public class walking_robot_simulation_ii {
    int w, h;
    int x = 0, y = 0;
    String dir = "East";

    public walking_robot_simulation_ii(int width, int height) {
        this.w = width - 1;
        this.h = height - 1;
    }

    public void step(int num) {
        int perimeter = 2 * (w + h);
        num %= perimeter;

        // special case: full cycle
        if (num == 0 && (x != 0 || y != 0)) {
            num = perimeter;
        }

        while (num > 0) {
            if (dir.equals("East")) {
                if (x < w) {
                    x++;
                } else {
                    dir = "North";
                    continue;
                }
            }
            else if (dir.equals("North")) {
                if (y < h) {
                    y++;
                } else {
                    dir = "West";
                    continue;
                }
            }
            else if (dir.equals("West")) {
                if (x > 0) {
                    x--;
                } else {
                    dir = "South";
                    continue;
                }
            }
            else { // South
                if (y > 0) {
                    y--;
                } else {
                    dir = "East";
                    continue;
                }
            }
            num--;
        }
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        return dir;
    }

    // ****************************** same same but different *********
    class Robot {
        int x, y, width, height;
        String dir;

        public Robot(int width, int height) {
            this.x = 0; this.y = 0;
            this.dir = "East" ;
            this.width = width; this.height = height;
        }

        public void step(int num) {
            int perim = 2 * (width - 1) + 2 * (height - 1);
            num %= perim;
            if (num == 0) num = perim;

            while (num > 0) {
                int nx = x, ny = y;
                if (dir.equals("East")) {
                    int maxX = Math.min(x + num, width - 1);
                    int rem  = num - (maxX - x) ;
                    num = rem;
                    if (rem == 0) x = maxX;
                    else{ x = maxX; dir = "North"; }
                } else if (dir.equals("West")) {
                    int minX = Math.max(x - num, 0);
                    int rem  = num - (x - minX) ;
                    num = rem;
                    if (rem == 0) x = minX;
                    else { x = minX; dir = "South"; }
                } else if (dir.equals("North")) {
                    int maxY = Math.min(y + num, height - 1);
                    int rem  = num - (maxY - y) ;
                    num = rem;
                    if (rem == 0) y = maxY;
                    else { y = maxY; dir = "West"; }
                } else if (dir.equals("South")) {
                    int minY = Math.max(y - num, 0);
                    int rem  = num - (y - minY) ;
                    num = rem;
                    if (rem == 0) y = minY;
                    else { y = minY; dir = "East"; }
                }
            }
        }

        public int[] getPos() { return new int[]{x, y}; }
        public String getDir() { return dir; }
    }

  public static void main(String[] args) {
      walking_robot_simulation_ii obj = new walking_robot_simulation_ii(3, 3);
//      int[] pos1 = obj.getPos();
//      System.out.println(pos1[0] + ", " + pos1[1]);
//      System.out.println(obj.getDir());

      obj.step(2);
      obj.step(4);
//      obj.step(1);

      int[] pos2 = obj.getPos();
      System.out.println(pos2[0] + ", " + pos2[1]);
      System.out.println(obj.getDir());
//
//      obj.step(1);
//      obj.step(4);
//      obj.step(2);
//
//      int[] pos2 = obj.getPos();
//      System.out.println(pos2[0] + ", " + pos2[1]);
//      System.out.println(obj.getDir());
  }
}


