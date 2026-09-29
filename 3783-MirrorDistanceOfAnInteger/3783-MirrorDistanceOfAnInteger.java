// Last updated: 9/29/2026, 11:03:58 AM
class Solution {

    private int reverse(int n) {
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + (n % 10);
            n /= 10;
        }
        return rev;
    }

    public int mirrorDistance(int n) {
        int rev = reverse(n);
        return Math.abs(n - rev);
    }
}