// Last updated: 7/7/2026, 10:58:09 PM
class Solution {
    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;

        int[][] arr = new int[n][2]; // [position, distance]
        for (int i = 0; i < n; i++) {
            arr[i][0] = robots[i];
            arr[i][1] = distance[i];
        }

        java.util.Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        java.util.Arrays.sort(walls);

        int[] left = new int[n];
        int[] right = new int[n];
        int[] overlap = new int[n]; // overlap[i] = overlap between robot i-1 and i

        // walls destroyed if robot i shoots left / right
        for (int i = 0; i < n; i++) {
            long pos = arr[i][0];
            long d = arr[i][1];

            long l1 = (i == 0) ? (pos - d) : Math.max(pos - d, (long) arr[i - 1][0] + 1);
            long r1 = pos;
            left[i] = countWalls(walls, l1, r1);

            long l2 = pos;
            long r2 = (i == n - 1) ? (pos + d) : Math.min(pos + d, (long) arr[i + 1][0] - 1);
            right[i] = countWalls(walls, l2, r2);
        }

        // overlap between robot i-1 shooting right and robot i shooting left
        for (int i = 1; i < n; i++) {
            long l = Math.max((long) arr[i - 1][0] + 1, (long) arr[i][0] - arr[i][1]);
            long r = Math.min((long) arr[i][0] - 1, (long) arr[i - 1][0] + arr[i - 1][1]);
            overlap[i] = countWalls(walls, l, r);
        }

        // DP:
        // dpL = best answer so far if current robot shoots left
        // dpR = best answer so far if current robot shoots right
        int dpL = left[0];
        int dpR = right[0];

        for (int i = 1; i < n; i++) {
            int newL = Math.max(dpL + left[i], dpR + left[i] - overlap[i]);
            int newR = Math.max(dpL + right[i], dpR + right[i]);

            dpL = newL;
            dpR = newR;
        }

        return Math.max(dpL, dpR);
    }

    private int countWalls(int[] walls, long l, long r) {
        if (l > r) return 0;
        int left = lowerBound(walls, l);
        int right = upperBound(walls, r);
        return right - left;
    }

    private int lowerBound(int[] arr, long target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    private int upperBound(int[] arr, long target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] <= target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}