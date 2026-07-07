// Last updated: 7/7/2026, 10:58:24 PM
class Solution {
    public char processStr(String s, long k) {
        long len = 0;

        // Forward: compute final length
        for (char c : s.toCharArray()) {
            if (c == '*') {
                len = Math.max(0, len - 1);
            } else if (c == '#') {
                len *= 2;
            } else if (c == '%') {
                // no change
            } else {
                len++;
            }
        }

        if (k >= len) {
            return '.';
        }

        // Backward: trace kth character
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c == '*') {
                len++;
            }
            else if (c == '#') {
                len /= 2;

                if (k >= len) {
                    k -= len;
                }
            }
            else if (c == '%') {
                k = len - 1 - k;
            }
            else {
                len--;

                if (k == len) {
                    return c;
                }
            }
        }

        return '.';
    }
}