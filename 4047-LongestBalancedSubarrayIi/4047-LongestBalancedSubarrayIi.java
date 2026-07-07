// Last updated: 7/7/2026, 10:58:01 PM
import java.util.Arrays;

class Solution {
    private int[] tree;
    private static final int INF = 1000000;
    private static final int MIN_OFF = 0;
    private static final int MAX_OFF = 1;
    private static final int LAZY_OFF = 2;

    private void pushDown(int node) {
        int lazy = tree[node * 3 + LAZY_OFF];
        if (lazy != 0) {
            int left = node << 1;
            int right = left | 1;
            
            tree[left * 3 + MIN_OFF] += lazy;
            tree[left * 3 + MAX_OFF] += lazy;
            tree[left * 3 + LAZY_OFF] += lazy;
            
            tree[right * 3 + MIN_OFF] += lazy;
            tree[right * 3 + MAX_OFF] += lazy;
            tree[right * 3 + LAZY_OFF] += lazy;
            
            tree[node * 3 + LAZY_OFF] = 0;
        }
    }

    private void updateRange(int node, int start, int end, int l, int r, int val) {
        if (l <= start && end <= r) {
            tree[node * 3 + MIN_OFF] += val;
            tree[node * 3 + MAX_OFF] += val;
            tree[node * 3 + LAZY_OFF] += val;
            return;
        }
        pushDown(node);
        int mid = (start + end) >> 1;
        int left = node << 1;
        int right = left | 1;
        if (l <= mid) updateRange(left, start, mid, l, r, val);
        if (r > mid) updateRange(right, mid + 1, end, l, r, val);
        
        tree[node * 3 + MIN_OFF] = Math.min(tree[left * 3 + MIN_OFF], tree[right * 3 + MIN_OFF]);
        tree[node * 3 + MAX_OFF] = Math.max(tree[left * 3 + MAX_OFF], tree[right * 3 + MAX_OFF]);
    }

    private int findFirst(int node, int start, int end) {
        if (tree[node * 3 + MIN_OFF] > 0 || tree[node * 3 + MAX_OFF] < 0) return -1;
        if (start == end) return start;
        pushDown(node);
        int mid = (start + end) >> 1;
        int res = findFirst(node << 1, start, mid);
        if (res == -1) res = findFirst((node << 1) | 1, mid + 1, end);
        return res;
    }

    public int longestBalanced(int[] nums) {
        int n = nums.length;
        tree = new int[4 * n * 3];
        for (int i = 0; i < 4 * n; i++) {
            tree[i * 3 + MIN_OFF] = INF;
            tree[i * 3 + MAX_OFF] = INF;
        }
        
        int[] last = new int[100001];
        Arrays.fill(last, -1);

        int maxLen = 0;
        for (int r = 0; r < n; r++) {
            int x = nums[r];
            int delta = (x % 2 == 0) ? 1 : -1;
            
            // Activate index r and update range in one go
            updateRange(1, 0, n - 1, r, r, -INF);
            updateRange(1, 0, n - 1, last[x] + 1, r, delta);
            last[x] = r;

            int firstIdx = findFirst(1, 0, n - 1);
            if (firstIdx != -1) {
                maxLen = Math.max(maxLen, r - firstIdx + 1);
            }
        }
        return maxLen;
    }
}