// Last updated: 9/29/2026, 11:04:09 AM
class Solution {
    public long sumAndMultiply(int n) {
        long x = 0;
        int sum = 0;

        if (n == 0) return 0;

        String s = String.valueOf(n);

        for (char c : s.toCharArray()) {
            if (c != '0') {
                int digit = c - '0';
                x = x * 10 + digit;
                sum += digit;
            }
        }

        return x * sum;
    }
}