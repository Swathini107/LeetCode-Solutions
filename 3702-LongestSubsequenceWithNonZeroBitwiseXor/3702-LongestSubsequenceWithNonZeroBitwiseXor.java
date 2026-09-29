// Last updated: 9/29/2026, 11:04:52 AM
class Solution {
    public int longestSubsequence(int[] A) {
        int tot = 0, n = A.length;
        boolean nonZero = false;

        for (int x : A) {
            nonZero |= x > 0;
            tot ^= x;
        }

        if (!nonZero) return 0;
        return tot == 0 ? n - 1 : n;
    }
}