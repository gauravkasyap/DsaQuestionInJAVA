import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

public class get_biggest_three_rhombus_sums_in_a_grid {
    public int[] getBiggestThree(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                addToSet(set, grid[i][j]); // k = 0 case

                for (int k = 1; i - k >= 0 && i + k < m && j - k >= 0 && j + k < n; k++) {

                    int sum = 0;

                    for (int l = 0; l < k; l++) {
                        sum += grid[i - k + l][j + l];     // top → right
                        sum += grid[i + l][j + k - l];     // right → bottom
                        sum += grid[i + k - l][j - l];     // bottom → left
                        sum += grid[i - l][j - k + l];     // left → top
                    }

                    addToSet(set, sum);
                }
            }
        }

        return buildAnswer(set);
    }

    private int[] buildAnswer(TreeSet<Integer> st) {
        int[] res = new int[st.size()];
        int idx = 0;

        Iterator<Integer> it = st.descendingIterator();
        while (it.hasNext())
            res[idx++] = it.next();

        return res;
    }

    private void addToSet(TreeSet<Integer> st, int val) {
        st.add(val);
        if (st.size() > 3) st.pollFirst();
    }
    public static void main(String[] args) {
        get_biggest_three_rhombus_sums_in_a_grid getBiggestThreeRhombusSumsInAGrid = new get_biggest_three_rhombus_sums_in_a_grid();

        int[][] num={{7,7,7}};

        System.out.println(Arrays.toString(getBiggestThreeRhombusSumsInAGrid.getBiggestThree(num)));

    }
}
