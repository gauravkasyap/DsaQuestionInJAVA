import java.util.HashSet;
import java.util.Set;

public class walking_robot_simulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();

        for (int[] obc:obstacles){
            String key= String.valueOf(obc[0])+"_"+String.valueOf(obc[1]);
            set.add(key);
        }

         int x=0, y=0;
        int distance = 0;
        int[] dir= {0,1};
        for (int i=0; i<commands.length; i++){
            if (commands[i]==-2){
                dir = new int[]{-dir[1], dir[0]};
            } else if (commands[i]==-1) {
                dir = new int[]{dir[1],-dir[0]};
            }else {
                for (int j=0; j<commands[i]; j++){
                    int newX=x+dir[0];
                    int newY = y+dir[1];

                    String newKey= String.valueOf(newX)+"_"+String.valueOf(newY);
                    if (set.contains(newKey)){
                        break;
                    }
                    x=newX;
                    y=newY;
                }
            }
            distance= Math.max(distance,x*x+y*y);
        }
        return distance;
    }
    public static void main(String[] args) {
        walking_robot_simulation walkingRobotSimulation = new walking_robot_simulation();

        int[] commands={6,-1,-1,6};
        int[][] obstacles={{0,0}};
        System.out.println(walkingRobotSimulation.robotSim(commands,obstacles));
    }
}
