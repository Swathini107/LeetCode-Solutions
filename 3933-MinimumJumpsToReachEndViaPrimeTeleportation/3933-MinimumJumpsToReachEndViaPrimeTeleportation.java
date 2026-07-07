// Last updated: 7/7/2026, 10:58:27 PM
class Solution {

    static final int MAX = 1_000_000;
    static boolean[] composite = new boolean[MAX + 1];

    static {

        composite[0] = composite[1] = true;

        for (int i = 2; i * i <= MAX; i++) {

            if (!composite[i]) {

                for (int j = i * i; j <= MAX; j += i) {
                    composite[j] = true;
                }
            }
        }
    }

    public int minJumps(int[] nums) {

        int n = nums.length;

        if (n == 1) return 0;

        int mx = 0;

        for (int x : nums) {
            mx = Math.max(mx, x);
        }

        // linked-list style storage
        int[] head = new int[mx + 1];
        Arrays.fill(head, -1);

        int[] next = new int[n];

        for (int i = 0; i < n; i++) {

            next[i] = head[nums[i]];
            head[nums[i]] = i;
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();

        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        dist[0] = 0;
        q.offer(0);

        boolean[] usedPrime = new boolean[mx + 1];

        while (!q.isEmpty()) {

            int i = q.poll();

            int d = dist[i];

            if (i == n - 1) {
                return d;
            }

            // left
            if (i > 0 && dist[i - 1] == -1) {
                dist[i - 1] = d + 1;
                q.offer(i - 1);
            }

            // right
            if (i + 1 < n && dist[i + 1] == -1) {
                dist[i + 1] = d + 1;
                q.offer(i + 1);
            }

            int val = nums[i];

            // teleport only if prime
            if (!composite[val] && !usedPrime[val]) {

                usedPrime[val] = true;

                // all multiples of val
                for (int mul = val; mul <= mx; mul += val) {

                    for (int j = head[mul]; j != -1; j = next[j]) {

                        if (dist[j] == -1) {

                            dist[j] = d + 1;
                            q.offer(j);
                        }
                    }

                    // critical optimization
                    head[mul] = -1;
                }
            }
        }

        return -1;
    }
}