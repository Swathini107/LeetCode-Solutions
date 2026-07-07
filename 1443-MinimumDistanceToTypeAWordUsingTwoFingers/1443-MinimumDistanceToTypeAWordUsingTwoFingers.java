// Last updated: 7/7/2026, 11:00:47 PM
import java.util.*;

class Solution {
    
    private int dist(int a, int b) {
        if (a == -1) return 0;
        return Math.abs(a / 6 - b / 6) + Math.abs(a % 6 - b % 6);
    }
    
    public int minimumDistance(String word) {
        int n = word.length();
        
        int[][] dp = new int[n][27];
        
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
        
        // First character → no cost, other finger is "free"
        dp[0][26] = 0;
        
        for (int i = 1; i < n; i++) {
            int curr = word.charAt(i) - 'A';
            int prev = word.charAt(i - 1) - 'A';
            
            for (int j = 0; j <= 26; j++) {
                if (dp[i - 1][j] == Integer.MAX_VALUE) continue;
                
                // Option 1: same finger
                dp[i][j] = Math.min(
                    dp[i][j],
                    dp[i - 1][j] + dist(prev, curr)
                );
                
                // Option 2: other finger
                dp[i][prev] = Math.min(
                    dp[i][prev],
                    dp[i - 1][j] + dist(j == 26 ? -1 : j, curr)
                );
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j <= 26; j++) {
            ans = Math.min(ans, dp[n - 1][j]);
        }
        
        return ans;
    }
}