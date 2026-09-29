// Last updated: 9/29/2026, 11:06:07 AM
class Solution {
    public int maxProduct(int n) {

        int first = 0;

        int second = 0;

        while (n > 0) {

            int digit = n % 10;

            if (digit >= first) {
                second = first;
                first = digit;
            } else if (digit > second) {
                second = digit;
            }

            n /= 10;
        }

        return first * second;
    }
}