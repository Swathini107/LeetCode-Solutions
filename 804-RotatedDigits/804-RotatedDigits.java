// Last updated: 7/7/2026, 11:01:08 PM
class Solution {
    public int rotatedDigits(int n) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (isGood(i)) {
                count++;
            }
        }

        return count;
    }

    private boolean isGood(int num) {
        boolean changed = false;

        while (num > 0) {
            int digit = num % 10;

            // invalid digit
            if (digit == 3 || digit == 4 || digit == 7) {
                return false;
            }

            // causes change
            if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                changed = true;
            }

            num /= 10;
        }

        return changed;
    }
}