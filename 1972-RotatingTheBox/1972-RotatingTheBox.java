// Last updated: 7/7/2026, 10:59:58 PM
class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;

        // Step 1: Apply gravity (move stones right)
        for (int i = 0; i < m; i++) {
            int empty = n - 1;

            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '*') {
                    empty = j - 1; // reset after obstacle
                } else if (box[i][j] == '#') {
                    // move stone to 'empty'
                    box[i][j] = '.';
                    box[i][empty] = '#';
                    empty--;
                }
            }
        }

        // Step 2: Rotate 90° clockwise
        char[][] res = new char[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][m - 1 - i] = box[i][j];
            }
        }

        return res;
    }
}