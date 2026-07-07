// Last updated: 7/7/2026, 10:58:28 PM
import java.util.*;

class Solution {
    static class Edge {
        int to;
        int w;

        Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        List<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        int maxWeight = 0;

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];

            if ((u != 0 && u != n - 1 && !online[u]) ||
                (v != 0 && v != n - 1 && !online[v])) {
                continue;
            }

            graph[u].add(new Edge(v, w));
            maxWeight = Math.max(maxWeight, w);
        }

        int ans = -1;
        int lo = 0, hi = maxWeight;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (check(graph, n, k, mid)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }

    private boolean check(List<Edge>[] graph, int n, long k, int minEdge) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<long[]> pq =
                new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));

        dist[0] = 0;
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int u = (int) cur[0];
            long d = cur[1];

            if (d != dist[u]) continue;
            if (u == n - 1) return d <= k;

            for (Edge e : graph[u]) {
                if (e.w < minEdge) continue;

                long nd = d + e.w;
                if (nd < dist[e.to] && nd <= k) {
                    dist[e.to] = nd;
                    pq.offer(new long[]{e.to, nd});
                }
            }
        }

        return false;
    }
}