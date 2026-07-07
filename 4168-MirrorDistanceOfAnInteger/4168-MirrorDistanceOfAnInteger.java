// Last updated: 7/7/2026, 10:57:44 PM
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