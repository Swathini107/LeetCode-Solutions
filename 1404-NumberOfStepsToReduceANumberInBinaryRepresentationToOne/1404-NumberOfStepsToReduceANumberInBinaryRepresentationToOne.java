// Last updated: 9/29/2026, 11:12:42 AM
class Solution {
    public int numSteps(String s) {
        int steps = 0;
        int carry = 0;

        // Traverse from right to left (ignore first bit)
        for (int i = s.length() - 1; i > 0; i--) {
            int bit = s.charAt(i) - '0';
            if (bit + carry == 1) {
                // odd → add 1 + divide
                steps += 2;
                carry = 1;
            } else {
                // even → divide only
                steps += 1;
            }
        }

        // If carry remains at MSB
        return steps + carry;
    }
}