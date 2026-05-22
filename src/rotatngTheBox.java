import java.util.Arrays;

public class rotatngTheBox {
    public char[][] rotatingBox(char[][] box){
        int n = box.length; int m = box[0].length;
        char[][] rotatedBox = new char[m][n];
         for (int i=n-1; i>=0; i--){
             int p=0;
             for (int j=m-1; j>=0; j--){
                 if (box[i][j] == '.'){
                    char tem=box[i][j];
                    box[i][j] = box[i][p];
                    box[i][p] =tem;
                    p++;
                 } else {
                     rotatedBox[j][i]=box[i][j];
                 }
             }
         }
        return rotatedBox;
    }
    public static void main(String[] args) {
        rotatngTheBox rotatngTheBox = new rotatngTheBox();

        char[][] box = {{'#','.','*','.'},{'#','#','*','.'}};

        System.out.println(Arrays.deepToString(rotatngTheBox.rotatingBox(box)));
    }
}
