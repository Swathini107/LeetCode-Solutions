// Last updated: 8/24/2026, 11:02:56 AM
class Solution {
    static final int MAX = 100000;
    static final boolean[] dp = new boolean[MAX + 1];

    static {
        for (int i = 0; i <= MAX; i++) {
            if (dp[i]) continue;

            for (int j = 1; j * j <= MAX - i; j++)
                dp[i + j * j] = true;
        }
    }

    public boolean winnerSquareGame(int n) { return dp[n]; }
}