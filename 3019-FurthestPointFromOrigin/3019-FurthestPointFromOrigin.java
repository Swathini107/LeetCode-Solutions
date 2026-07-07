// Last updated: 7/7/2026, 10:59:06 PM
class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int L = 0, R = 0, B = 0;

        for (char c : moves.toCharArray()) {
            if (c == 'L') L++;
            else if (c == 'R') R++;
            else B++;
        }

        return Math.abs(R - L) + B;
    }
}