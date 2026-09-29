// Last updated: 9/29/2026, 11:11:54 AM
class Solution {
    public int minimumDeletions(String s) {
       int bCount = 0;
        int ans = 0;

        for (char c : s.toCharArray()) {
            if (c == 'b') {
                bCount++;
            } else { // c == 'a'
                ans = Math.min(ans + 1, bCount);
            }
        }
        return ans;
    }
}