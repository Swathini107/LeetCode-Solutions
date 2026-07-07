// Last updated: 7/7/2026, 11:00:35 PM
import java.util.*;

class Solution {

    // Directions: up, down, left, right
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    
    // Allowed directions for each street type
    int[][] typeDirs = {
        {},                 // 0 (unused)
        {2, 3},             // 1: left, right
        {0, 1},             // 2: up, down
        {2, 1},             // 3: left, down
        {3, 1},             // 4: right, down
        {2, 0},             // 5: left, up
        {3, 0}              // 6: right, up
    };

    // Check if next cell connects back
    private boolean isConnected(int fromDir, int toType) {
        int opposite = fromDir ^ 1; // 0↔1, 2↔3
        for (int d : typeDirs[toType]) {
            if (d == opposite) return true;
        }
        return false;
    }

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        vis[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            if (r == m - 1 && c == n - 1) return true;

            int type = grid[r][c];

            for (int d : typeDirs[type]) {
                int nr = r + dirs[d][0];
                int nc = c + dirs[d][1];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
                if (vis[nr][nc]) continue;

                if (isConnected(d, grid[nr][nc])) {
                    vis[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return false;
    }
}