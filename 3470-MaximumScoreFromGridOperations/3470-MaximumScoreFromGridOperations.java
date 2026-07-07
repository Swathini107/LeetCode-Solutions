// Last updated: 7/7/2026, 10:58:50 PM
class Solution {
    public long maximumScore(int[][] grid) {
        int n = grid.length;

        // Prefix sum S[col][row]
        long[][] S = new long[n][n + 1];
        for (int j = 0; j < n; j++) {
            for (int i = 1; i <= n; i++) {
                S[j][i] = S[j][i - 1] + grid[i - 1][j];
            }
        }

        long[][][] dp = new long[n][n + 1][n + 1];

        // Initialize first column
        for (int h = 0; h <= n; h++) {
            dp[0][h][0] = 0;
        }

        for (int i = 1; i < n; i++) {

            // Precompute prefix & suffix max
            long[][] prevMax = new long[n + 1][n + 1];
            long[][] prevSuffixMax = new long[n + 1][n + 1];

            for (int h_prev = 0; h_prev <= n; h_prev++) {

                // prefix max
                prevMax[h_prev][0] = dp[i - 1][h_prev][0];
                for (int k = 1; k <= n; k++) {
                    long val = dp[i - 1][h_prev][k]
                            - Math.max(0, S[i - 1][k] - S[i - 1][h_prev]);

                    prevMax[h_prev][k] = Math.max(prevMax[h_prev][k - 1], val);
                }

                // suffix max
                prevSuffixMax[h_prev][n] = dp[i - 1][h_prev][n];
                for (int k = n - 1; k >= 0; k--) {
                    prevSuffixMax[h_prev][k] = Math.max(prevSuffixMax[h_prev][k + 1],
                            dp[i - 1][h_prev][k]);
                }
            }

            // Transition
            for (int h_curr = 0; h_curr <= n; h_curr++) {
                for (int h_prev = 0; h_prev <= n; h_prev++) {

                    if (h_curr <= h_prev) {
                        dp[i][h_curr][h_prev] = prevSuffixMax[h_prev][0]
                                + S[i][h_prev] - S[i][h_curr];
                    } else {
                        dp[i][h_curr][h_prev] = Math.max(
                                prevSuffixMax[h_prev][h_curr],
                                prevMax[h_prev][h_curr]
                                        + S[i - 1][h_curr] - S[i - 1][h_prev]);
                    }
                }
            }
        }

        // Final answer
        
        long ans = 0;
        for (int h_curr = 0; h_curr <= n; h_curr++) {
            for (int h_prev = 0; h_prev <= n; h_prev++) {
                ans = Math.max(ans, dp[n - 1][h_curr][h_prev]);
            }
        }

        return ans;
    }
}