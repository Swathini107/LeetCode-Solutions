// Last updated: 7/7/2026, 11:00:14 PM
class Solution {
    public int concatenatedBinary(int n) {
        long mod = 1_000_000_007;
        long result = 0;
        int bitLength = 0;

        for (int i = 1; i <= n; i++) {

            // If i is power of 2, increase bit length
            if ((i & (i - 1)) == 0) {
                bitLength++;
            }

            // Shift result and add i
            result = ((result << bitLength) % mod + i) % mod;
        }

        return (int) result;
    }
}