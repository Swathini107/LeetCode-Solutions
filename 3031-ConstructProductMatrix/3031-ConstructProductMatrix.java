// Last updated: 7/7/2026, 10:59:05 PM
class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int mod = 12345;
        int n = grid.length;
        int m = grid[0].length;
        int size = n * m;

        long[] prefix = new long[size];
        long[] suffix = new long[size];
        int[] arr = new int[size];

        // Flatten matrix
        int idx = 0;
        for (int[] row : grid) {
            for (int val : row) {
                arr[idx++] = val % mod;
            }
        }

        // Prefix product
        prefix[0] = 1;
        for (int i = 1; i < size; i++) {
            prefix[i] = (prefix[i - 1] * arr[i - 1]) % mod;
        }

        // Suffix product
        suffix[size - 1] = 1;
        for (int i = size - 2; i >= 0; i--) {
            suffix[i] = (suffix[i + 1] * arr[i + 1]) % mod;
        }

        // Build result
        int[][] result = new int[n][m];
        idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = (int)((prefix[idx] * suffix[idx]) % mod);
                idx++;
            }
        }

        return result;
    }
}