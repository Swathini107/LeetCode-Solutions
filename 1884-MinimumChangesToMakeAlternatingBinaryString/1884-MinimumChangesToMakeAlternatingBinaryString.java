// Last updated: 7/7/2026, 11:00:05 PM
class Solution {
    public int minOperations(String s) {
        int mismatchStart0 = 0;
        int mismatchStart1 = 0;

        for (int i = 0; i < s.length(); i++) {
            char expected0 = (i % 2 == 0) ? '0' : '1';
            char expected1 = (i % 2 == 0) ? '1' : '0';

            if (s.charAt(i) != expected0) mismatchStart0++;
            if (s.charAt(i) != expected1) mismatchStart1++;
        }

        return Math.min(mismatchStart0, mismatchStart1);
    }
}