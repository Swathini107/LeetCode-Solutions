// Last updated: 7/7/2026, 10:58:04 PM
import java.util.*;

class Solution {

    class Node {
        long val;
        int l, r;

        Node(long val, int l, int r) {
            this.val = val;
            this.l = l;
            this.r = r;
        }
    }

    class SegmentTree {
        long[] maxTree;
        long[] minTree;
        int n;

        SegmentTree(int[] nums) {
            n = nums.length;
            maxTree = new long[4 * n];
            minTree = new long[4 * n];
            build(1, 0, n - 1, nums);
        }

        void build(int node, int start, int end, int[] nums) {
            if (start == end) {
                maxTree[node] = nums[start];
                minTree[node] = nums[start];
                return;
            }

            int mid = (start + end) / 2;

            build(node * 2, start, mid, nums);
            build(node * 2 + 1, mid + 1, end, nums);

            maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2 + 1]);
            minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
        }

        long queryMax(int node, int start, int end, int l, int r) {
            if (r < start || end < l)
                return Long.MIN_VALUE;

            if (l <= start && end <= r)
                return maxTree[node];

            int mid = (start + end) / 2;

            return Math.max(
                    queryMax(node * 2, start, mid, l, r),
                    queryMax(node * 2 + 1, mid + 1, end, l, r));
        }

        long queryMin(int node, int start, int end, int l, int r) {
            if (r < start || end < l)
                return Long.MAX_VALUE;

            if (l <= start && end <= r)
                return minTree[node];

            int mid = (start + end) / 2;

            return Math.min(
                    queryMin(node * 2, start, mid, l, r),
                    queryMin(node * 2 + 1, mid + 1, end, l, r));
        }

        long getValue(int l, int r) {
            long mx = queryMax(1, 0, n - 1, l, r);
            long mn = queryMin(1, 0, n - 1, l, r);
            return mx - mn;
        }
    }

    public long maxTotalValue(int[] nums, int k) {

        int n = nums.length;

        SegmentTree st = new SegmentTree(nums);

        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a, b) -> Long.compare(b.val, a.val));

        for (int l = 0; l < n; l++) {
            pq.offer(new Node(st.getValue(l, n - 1), l, n - 1));
        }

        long ans = 0;

        while (k-- > 0) {
            Node cur = pq.poll();

            ans += cur.val;

            if (cur.r > cur.l) {
                pq.offer(new Node(
                        st.getValue(cur.l, cur.r - 1),
                        cur.l,
                        cur.r - 1));
            }
        }

        return ans;
    }
}