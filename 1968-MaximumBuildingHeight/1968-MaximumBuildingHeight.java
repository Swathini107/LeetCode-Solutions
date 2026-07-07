// Last updated: 7/7/2026, 10:59:59 PM
class Solution {
    public int maxBuilding(int n, int[][] restrictions) {

        if (restrictions.length == 0)
            return n - 1;

        int m = restrictions.length;

        int[][] r = new int[m + 1][2];

        r[0][0] = 1;
        r[0][1] = 0;

        for (int i = 0; i < m; i++) {
            r[i + 1] = restrictions[i];
        }

        Arrays.sort(r, (a, b) -> a[0] - b[0]);

        m++;

        // Left -> Right
        for (int i = 1; i < m; i++) {
            int d = r[i][0] - r[i - 1][0];
            r[i][1] = Math.min(r[i][1],
                    r[i - 1][1] + d);
        }

        // Right -> Left
        for (int i = m - 2; i >= 0; i--) {
            int d = r[i + 1][0] - r[i][0];
            r[i][1] = Math.min(r[i][1],
                    r[i + 1][1] + d);
        }

        int ans = 0;

        for (int i = 1; i < m; i++) {
            int x1 = r[i - 1][0];
            int h1 = r[i - 1][1];

            int x2 = r[i][0];
            int h2 = r[i][1];

            int d = x2 - x1;

            int peak = (h1 + h2 + d) / 2;
            ans = Math.max(ans, peak);
        }

        int lastPos = r[m - 1][0];
        int lastHeight = r[m - 1][1];

        ans = Math.max(
                ans,
                lastHeight + (n - lastPos)
        );

        return ans;
    }
}