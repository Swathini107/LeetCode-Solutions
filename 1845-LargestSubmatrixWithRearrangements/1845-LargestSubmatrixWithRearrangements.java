// Last updated: 7/7/2026, 11:00:08 PM
import java.util.*;

class Solution {
    public int largestSubmatrix(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int maxArea = 0;

        int[] height = new int[n];

        for (int i = 0; i < m; i++) {

            // build histogram
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0)
                    height[j] = 0;
                else
                    height[j] += 1;
            }

            // copy and sort (simulate column rearrangement)
            int[] sorted = height.clone();
            Arrays.sort(sorted);

            // check possible areas
            for (int j = n - 1; j >= 0; j--) {
                int width = n - j;
                maxArea = Math.max(maxArea, sorted[j] * width);
            }
        }

        return maxArea;
    }
}