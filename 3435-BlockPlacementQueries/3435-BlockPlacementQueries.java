// Last updated: 7/7/2026, 10:58:51 PM
class Solution {
    static class Fenwick {
        int n;
        int[] bit;

        Fenwick(int n) {
            this.n = n;
            bit = new int[n + 2];
        }

        void update(int idx, int val) {
            while (idx <= n) {
                bit[idx] = Math.max(bit[idx], val);
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int res = 0;
            while (idx > 0) {
                res = Math.max(res, bit[idx]);
                idx -= idx & -idx;
            }
            return res;
        }
    }

    public List<Boolean> getResults(int[][] queries) {
        int mx = 0;
        for (int[] q : queries) {
            mx = Math.max(mx, q[1]);
        }

        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);
        obstacles.add(mx + 1);

        List<Boolean> ans = new ArrayList<>();
        List<int[]> type2 = new ArrayList<>();

        for (int[] q : queries) {
            if (q[0] == 1) {
                obstacles.add(q[1]);
            }
        }

        Fenwick bit = new Fenwick(mx + 2);

        Integer prev = null;
        for (int x : obstacles) {
            if (prev != null) {
                bit.update(x, x - prev);
            }
            prev = x;
        }

        for (int i = queries.length - 1; i >= 0; i--) {
            int[] q = queries[i];

            if (q[0] == 2) {
                int x = q[1];
                int sz = q[2];

                Integer p = obstacles.floor(x);

                int best = bit.query(p);
                best = Math.max(best, x - p);

                ans.add(best >= sz);
            } else {
                int x = q[1];

                Integer left = obstacles.lower(x);
                Integer right = obstacles.higher(x);

                obstacles.remove(x);

                bit.update(right, right - left);
            }
        }

        Collections.reverse(ans);
        return ans;
    }
}