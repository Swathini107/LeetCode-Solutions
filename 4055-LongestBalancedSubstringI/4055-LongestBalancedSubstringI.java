// Last updated: 7/7/2026, 10:57:59 PM
class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int ans = 1;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            int maxFreq = 0;
            int distinct = 0;

            for (int j = i; j < n; j++) {
                int c = s.charAt(j) - 'a';
                if (freq[c] == 0) distinct++;
                freq[c]++;
                maxFreq = Math.max(maxFreq, freq[c]);

                int len = j - i + 1;
                if (maxFreq * distinct == len) {
                    ans = Math.max(ans, len);
                }
            }
        }
        return ans;
    }
}
