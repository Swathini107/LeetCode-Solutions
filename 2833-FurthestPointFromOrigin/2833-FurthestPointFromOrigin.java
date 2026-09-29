// Last updated: 9/29/2026, 11:08:42 AM
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