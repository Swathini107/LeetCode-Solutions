// Last updated: 7/7/2026, 11:01:12 PM
class Solution {
    public int countBinarySubstrings(String s) {
        int prev = 0, cur = 1, ans = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cur++;
            } else {
                ans += Math.min(prev, cur);
                prev = cur;
                cur = 1;
            }
        }

        return ans + Math.min(prev, cur);
    }
}
