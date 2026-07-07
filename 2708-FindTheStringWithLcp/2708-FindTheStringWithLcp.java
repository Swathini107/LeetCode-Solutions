// Last updated: 7/7/2026, 10:59:20 PM
class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;

        // Step 1: basic validation
        for (int i = 0; i < n; i++) {
            if (lcp[i][i] != n - i) return "";
            for (int j = 0; j < n; j++) {
                if (lcp[i][j] != lcp[j][i]) return "";
            }
        }

        // Step 2: DSU
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (lcp[i][j] > 0) {
                    union(parent, i, j);
                }
            }
        }

        // Step 3: assign characters
        char[] word = new char[n];
        char ch = 'a';

        int[] map = new int[n];
        Arrays.fill(map, -1);

        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            if (map[root] == -1) {
                if (ch > 'z') return "";
                map[root] = ch++;
            }
            word[i] = (char) map[root];
        }

        // Step 4: validate by recomputing LCP
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (word[i] == word[j]) {
                    dp[i][j] = 1;
                    if (i + 1 < n && j + 1 < n) {
                        dp[i][j] += dp[i + 1][j + 1];
                    }
                }
            }
        }

        // Compare with given LCP
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] != lcp[i][j]) return "";
            }
        }

        return new String(word);
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x)
            parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    private void union(int[] parent, int a, int b) {
        int pa = find(parent, a);
        int pb = find(parent, b);
        if (pa != pb) parent[pa] = pb;
    }
}