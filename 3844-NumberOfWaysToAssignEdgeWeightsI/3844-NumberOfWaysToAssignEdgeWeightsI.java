// Last updated: 7/7/2026, 10:58:35 PM
import java.util.*;

class Solution {

    static final long MOD = 1_000_000_007L;

    public int assignEdgeWeights(int[][] edges) {

        int n = edges.length + 1;

        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n + 1];

        q.offer(1);
        vis[1] = true;

        int depth = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            depth++;

            for (int i = 0; i < size; i++) {
                int node = q.poll();

                for (int next : graph[node]) {
                    if (!vis[next]) {
                        vis[next] = true;
                        q.offer(next);
                    }
                }
            }
        }

        return (int) modPow(2, depth - 1);
    }

    private long modPow(long base, long exp) {
        long ans = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                ans = (ans * base) % MOD;
            }

            base = (base * base) % MOD;
            exp >>= 1;
        }

        return ans;
    }
}