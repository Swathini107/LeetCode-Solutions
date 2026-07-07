// Last updated: 7/7/2026, 11:01:04 PM
class Solution {
    public int binaryGap(int n) {
        int last = -1;   // position of last 1
        int maxGap = 0;
        int pos = 0;

        while (n > 0) {
            if ((n & 1) == 1) {   // if current bit is 1
                if (last != -1) {
                    maxGap = Math.max(maxGap, pos - last);
                }
                last = pos;
            }
            pos++;
            n >>= 1; // right shift
        }

        return maxGap;
    }
}