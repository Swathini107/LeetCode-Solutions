// Last updated: 7/7/2026, 10:57:56 PM
class Solution {
    public int totalWaviness(int num1, int num2) {
        int total = 0;

        for (int num = num1; num <= num2; num++) {
            char[] digits = String.valueOf(num).toCharArray();

            for (int i = 1; i < digits.length - 1; i++) {
                int prev = digits[i - 1] - '0';
                int curr = digits[i] - '0';
                int next = digits[i + 1] - '0';

                if ((curr > prev && curr > next) ||
                    (curr < prev && curr < next)) {
                    total++;
                }
            }
        }

        return total;
    }
}