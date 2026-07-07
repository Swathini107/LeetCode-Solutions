// Last updated: 7/7/2026, 10:59:51 PM
class Solution {

    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;

        for (int i = 0; i < 4; i++) {
            if (isEqual(mat, target)) return true;
            mat = rotate(mat);
        }
        return false;
    }

    // Check if two matrices are equal
    private boolean isEqual(int[][] a, int[][] b) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] != b[i][j]) return false;
            }
        }
        return true;
    }

    // Rotate matrix 90° clockwise
    private int[][] rotate(int[][] mat) {
        int n = mat.length;
        int[][] res = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[j][n - 1 - i] = mat[i][j];
            }
        }
        return res;
    }
}