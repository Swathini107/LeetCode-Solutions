// Last updated: 7/7/2026, 10:59:39 PM
class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int ans = 0;

        // Case 1: fix left end
        for (int j = n - 1; j >= 0; j--) {
            if (colors[j] != colors[0]) {
                ans = Math.max(ans, j);
                break;
            }
        }

        // Case 2: fix right end
        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[n - 1]) {
                ans = Math.max(ans, n - 1 - i);
                break;
            }
        }

        return ans;
    }
}