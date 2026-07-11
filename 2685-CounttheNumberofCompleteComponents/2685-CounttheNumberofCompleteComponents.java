// Last updated: 7/11/2026, 9:08:11 AM
1import java.util.*;
2
3class Solution {
4
5    public int countCompleteComponents(int n, int[][] edges) {
6
7        List<Integer>[] graph = new ArrayList[n];
8
9        for (int i = 0; i < n; i++)
10            graph[i] = new ArrayList<>();
11
12        for (int[] e : edges) {
13            graph[e[0]].add(e[1]);
14            graph[e[1]].add(e[0]);
15        }
16
17        boolean[] visited = new boolean[n];
18
19        int answer = 0;
20
21        for (int i = 0; i < n; i++) {
22
23            if (!visited[i]) {
24
25                int[] res = dfs(i, graph, visited);
26
27                int nodes = res[0];
28                int edgeCount = res[1] / 2;
29
30                if (edgeCount == nodes * (nodes - 1) / 2)
31                    answer++;
32            }
33        }
34
35        return answer;
36    }
37
38    private int[] dfs(int node, List<Integer>[] graph, boolean[] visited) {
39
40        visited[node] = true;
41
42        int nodes = 1;
43        int degreeSum = graph[node].size();
44
45        for (int next : graph[node]) {
46            if (!visited[next]) {
47                int[] res = dfs(next, graph, visited);
48                nodes += res[0];
49                degreeSum += res[1];
50            }
51        }
52
53        return new int[]{nodes, degreeSum};
54    }
55}