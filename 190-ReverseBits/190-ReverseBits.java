// Last updated: 7/7/2026, 11:01:24 PM
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) | (n & 1);
            n >>>= 1; // unsigned shift
        }
        return res;
    }
}
