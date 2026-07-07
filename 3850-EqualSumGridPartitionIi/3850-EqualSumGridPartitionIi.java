// Last updated: 7/7/2026, 10:58:32 PM
import java.util.*;

class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        long total = 0;
        for (int[] row : grid)
            for (int val : row)
                total += val;

        // ---------- Horizontal ----------
        Map<Integer, Integer> bottom = new HashMap<>();
        for (int[] row : grid)
            for (int v : row)
                bottom.put(v, bottom.getOrDefault(v, 0) + 1);

        Map<Integer, Integer> top = new HashMap<>();
        long topSum = 0;

        for (int i = 0; i < m - 1; i++) {
            for (int val : grid[i]) {
                topSum += val;

                top.put(val, top.getOrDefault(val, 0) + 1);

                bottom.put(val, bottom.get(val) - 1);
                if (bottom.get(val) == 0) bottom.remove(val);
            }

            long bottomSum = total - topSum;

            if (topSum == bottomSum) return true;

            long diff = Math.abs(topSum - bottomSum);

            if (topSum > bottomSum) {
                if (valid(top, grid, 0, i, 0, n - 1, diff)) return true;
            } else {
                if (valid(bottom, grid, i + 1, m - 1, 0, n - 1, diff)) return true;
            }
        }

        // ---------- Vertical ----------
        Map<Integer, Integer> right = new HashMap<>();
        for (int[] row : grid)
            for (int v : row)
                right.put(v, right.getOrDefault(v, 0) + 1);

        Map<Integer, Integer> left = new HashMap<>();
        long leftSum = 0;

        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < m; i++) {
                int val = grid[i][j];
                leftSum += val;

                left.put(val, left.getOrDefault(val, 0) + 1);

                right.put(val, right.get(val) - 1);
                if (right.get(val) == 0) right.remove(val);
            }

            long rightSum = total - leftSum;

            if (leftSum == rightSum) return true;

            long diff = Math.abs(leftSum - rightSum);

            if (leftSum > rightSum) {
                if (valid(left, grid, 0, m - 1, 0, j, diff)) return true;
            } else {
                if (valid(right, grid, 0, m - 1, j + 1, n - 1, diff)) return true;
            }
        }

        return false;
    }

    // ✅ Final Correct Connectivity Check
    private boolean valid(Map<Integer, Integer> map, int[][] grid,
                          int r1, int r2, int c1, int c2, long diff) {

        if (!map.containsKey((int) diff)) return false;

        int rows = r2 - r1 + 1;
        int cols = c2 - c1 + 1;

        // Single row → only ends
        if (rows == 1) {
            return grid[r1][c1] == diff || grid[r1][c2] == diff;
        }

        // Single column → only ends
        if (cols == 1) {
            return grid[r1][c1] == diff || grid[r2][c1] == diff;
        }

        // ✅ Boundary cells check (top & bottom rows)
        for (int j = c1; j <= c2; j++) {
            if (grid[r1][j] == diff || grid[r2][j] == diff) return true;
        }

        // ✅ Boundary cells check (left & right columns)
        for (int i = r1; i <= r2; i++) {
            if (grid[i][c1] == diff || grid[i][c2] == diff) return true;
        }

        // Interior cells allowed only if ≥ 3x3
        if (rows > 2 && cols > 2) return true;

        return false;
    }
}