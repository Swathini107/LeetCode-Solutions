// Last updated: 7/7/2026, 10:58:08 PM
class Solution {

    public int minOperations(String s, int k) {
        int n = s.length();
        int m = 0;

        for (char c : s.toCharArray()) {
            if (c == '0') m++;
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        List<TreeSet<Integer>> sets = new ArrayList<>();
        sets.add(new TreeSet<>());
        sets.add(new TreeSet<>());

        for (int i = 0; i <= n; i++) {
            sets.get(i % 2).add(i);
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(m);
        dist[m] = 0;
        sets.get(m % 2).remove(m);

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == 0) return dist[0];

            int c1 = Math.max(k - n + cur, 0);
            int c2 = Math.min(cur, k);

            int l = cur + k - 2 * c2;
            int r = cur + k - 2 * c1;

            TreeSet<Integer> set = sets.get(l % 2);

            Integer next = set.ceiling(l);

            while (next != null && next <= r) {
                int val = next;
                set.remove(val);
                dist[val] = dist[cur] + 1;
                q.offer(val);
                next = set.ceiling(val);
            }
        }

        return -1;
    }
}