// Last updated: 7/12/2026, 12:54:52 PM
import java.util.*;

class Solution {

    public int countCompleteComponents(int n, int[][] edges) {

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        boolean[] visited = new boolean[n];

        int answer = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                int[] res = dfs(i, graph, visited);

                int nodes = res[0];
                int edgeCount = res[1] / 2;

                if (edgeCount == nodes * (nodes - 1) / 2)
                    answer++;
            }
        }

        return answer;
    }

    private int[] dfs(int node, List<Integer>[] graph, boolean[] visited) {

        visited[node] = true;

        int nodes = 1;
        int degreeSum = graph[node].size();

        for (int next : graph[node]) {
            if (!visited[next]) {
                int[] res = dfs(next, graph, visited);
                nodes += res[0];
                degreeSum += res[1];
            }
        }

        return new int[]{nodes, degreeSum};
    }
}