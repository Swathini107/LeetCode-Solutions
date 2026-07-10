// Last updated: 7/10/2026, 9:15:40 AM
1import java.util.*;
2
3class Solution {
4    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
5
6        int[][] arr = new int[n][2];
7        for (int i = 0; i < n; i++) {
8            arr[i][0] = nums[i];
9            arr[i][1] = i;
10        }
11
12        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
13
14        int[] pos = new int[n];
15        for (int i = 0; i < n; i++) {
16            pos[arr[i][1]] = i;
17        }
18
19        int[] far = new int[n];
20        int r = 0;
21        for (int l = 0; l < n; l++) {
22            while (r + 1 < n && arr[r + 1][0] - arr[l][0] <= maxDiff) {
23                r++;
24            }
25            far[l] = r;
26        }
27
28        int LOG = 17;
29        while ((1 << LOG) <= n) LOG++;
30
31        int[][] up = new int[LOG][n];
32
33        for (int i = 0; i < n; i++) {
34            up[0][i] = far[i];
35        }
36
37        for (int k = 1; k < LOG; k++) {
38            for (int i = 0; i < n; i++) {
39                up[k][i] = up[k - 1][up[k - 1][i]];
40            }
41        }
42
43        int[] ans = new int[queries.length];
44
45        for (int qi = 0; qi < queries.length; qi++) {
46
47            int u = pos[queries[qi][0]];
48            int v = pos[queries[qi][1]];
49
50            if (u > v) {
51                int t = u;
52                u = v;
53                v = t;
54            }
55
56            if (u == v) {
57                ans[qi] = 0;
58                continue;
59            }
60
61            if (far[u] == u) {
62                ans[qi] = -1;
63                continue;
64            }
65
66            int cur = u;
67            int steps = 0;
68
69            for (int k = LOG - 1; k >= 0; k--) {
70                if (up[k][cur] < v) {
71                    cur = up[k][cur];
72                    steps += 1 << k;
73                }
74            }
75
76            cur = far[cur];
77            steps++;
78
79            if (cur >= v)
80                ans[qi] = steps;
81            else
82                ans[qi] = -1;
83        }
84
85        return ans;
86    }
87}