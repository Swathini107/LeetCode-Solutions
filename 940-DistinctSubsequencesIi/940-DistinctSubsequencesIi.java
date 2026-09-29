// Last updated: 9/29/2026, 11:14:12 AM
class Solution {
    public int distinctSubseqII(String s) {
        final long MOD = 1000000007L;
        
        long dp = 1;
        long[] last = new long[26];
        
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            
            long oldDp = dp;
            
            dp = (2 * dp - last[index] + MOD) % MOD;
            
            last[index] = oldDp;
        }
        
        return (int)((dp - 1 + MOD) % MOD);
    }
}