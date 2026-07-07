// Last updated: 7/7/2026, 10:58:34 PM
class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long total = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                total += grid[i][j];
            }
        }

        if(total % 2 != 0) return false;

        long target = total / 2;

        long rowSum = 0;
        for(int i = 0; i < m - 1; i++){
            for(int j = 0; j < n; j++){
                rowSum += grid[i][j];
            }
            if(rowSum == target) return true;
        }

        long colSum = 0;
        for(int j = 0; j < n - 1; j++){
            for(int i = 0; i < m; i++){
                colSum += grid[i][j];
            }
            if(colSum == target) return true;
        }

        return false;
    }
}