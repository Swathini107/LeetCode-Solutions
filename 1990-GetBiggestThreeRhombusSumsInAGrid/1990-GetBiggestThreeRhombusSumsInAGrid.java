// Last updated: 7/7/2026, 10:59:53 PM
import java.util.*;

class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                set.add(grid[r][c]); // radius 0 rhombus

                for (int k = 1; ; k++) {

                    if (r-k < 0 || r+k >= m || c-k < 0 || c+k >= n)
                        break;

                    int sum = 0;

                    int x = r-k, y = c;

                    for (int i = 0; i < k; i++) sum += grid[x+i][y+i];
                    for (int i = 0; i < k; i++) sum += grid[x+k+i][y+k-i];
                    for (int i = 0; i < k; i++) sum += grid[x+2*k-i][y-i];
                    for (int i = 0; i < k; i++) sum += grid[x+k-i][y-k+i];

                    set.add(sum);
                }
            }
        }

        int size = Math.min(3, set.size());
        int[] ans = new int[size];

        int i = 0;
        for (int val : set) {
            ans[i++] = val;
            if (i == size) break;
        }

        return ans;
    }
}