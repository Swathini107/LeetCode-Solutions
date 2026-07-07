// Last updated: 7/7/2026, 10:57:58 PM
import java.util.*;

class Solution {

    public int longestBalanced(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int res = 0;

        // STEP 1: single character longest run
        int curA = 0, curB = 0, curC = 0;
        int maxA = 0, maxB = 0, maxC = 0;

        for (int i = 0; i < n; i++) {
            if (c[i] == 'a') {
                curA = (i > 0 && c[i - 1] == 'a') ? curA + 1 : 1;
                maxA = Math.max(maxA, curA);
            } 
            else if (c[i] == 'b') {
                curB = (i > 0 && c[i - 1] == 'b') ? curB + 1 : 1;
                maxB = Math.max(maxB, curB);
            } 
            else {
                curC = (i > 0 && c[i - 1] == 'c') ? curC + 1 : 1;
                maxC = Math.max(maxC, curC);
            }
        }
        res = Math.max(Math.max(maxA, maxB), maxC);

        // STEP 2: exactly two characters equal
        res = Math.max(res, find2(c, 'a', 'b'));
        res = Math.max(res, find2(c, 'a', 'c'));
        res = Math.max(res, find2(c, 'b', 'c'));

        // STEP 3: all three equal
        res = Math.max(res, find3(c));

        return res;
    }

    // ---------- TWO LETTERS ----------
    private int find2(char[] c, char x, char y) {
        int n = c.length;
        int[] first = new int[2 * n + 1];
        Arrays.fill(first, -2);

        int diff = n; // offset
        int clearIdx = -1;
        first[diff] = -1;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            if (c[i] != x && c[i] != y) {
                // forbidden third character resets segment
                clearIdx = i;
                diff = n;
                first[diff] = clearIdx;
            } else {
                if (c[i] == x) diff++;
                else diff--;

                if (first[diff] < clearIdx) {
                    first[diff] = i;
                } else {
                    maxLen = Math.max(maxLen, i - first[diff]);
                }
            }
        }
        return maxLen;
    }

    // ---------- THREE LETTERS ----------
    private int find3(char[] c) {
        long state = Long.MAX_VALUE / 2;
        Map<Long, Integer> first = new HashMap<>();
        first.put(state, -1);
        int maxLen = 0;

        for (int i = 0; i < c.length; i++) {
            if (c[i] == 'a') state += 1_000_001;
            else if (c[i] == 'b') state -= 1_000_000;
            else state -= 1;

            if (first.containsKey(state)) {
                maxLen = Math.max(maxLen, i - first.get(state));
            } else {
                first.put(state, i);
            }
        }
        return maxLen;
    }
}
