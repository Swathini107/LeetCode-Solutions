// Last updated: 7/7/2026, 10:58:39 PM
import java.util.*;

class Solution {

    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;

        // Step 1: map to 1D
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            int x = points[i][0], y = points[i][1];
            if (x == 0) arr[i] = y;
            else if (y == side) arr[i] = side + x;
            else if (x == side) arr[i] = 3L * side - y;
            else arr[i] = 4L * side - x;
        }

        Arrays.sort(arr);

        // duplicate for circular handling
        long[] ext = new long[2 * n];
        for (int i = 0; i < n; i++) {
            ext[i] = arr[i];
            ext[i + n] = arr[i] + 4L * side;
        }

        int low = 1, high = side, ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (can(ext, n, k, mid, side)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean can(long[] ext, int n, int k, int d, int side) {
        int total = 2 * n;

        for (int start = 0; start < n; start++) {
            int count = 1;
            long last = ext[start];
            int idx = start;

            while (count < k) {
                long target = last + d;
                int next = lowerBound(ext, idx + 1, total, target);
                if (next == total) break;

                last = ext[next];
                idx = next;
                count++;
            }

            if (count == k) {
                long first = ext[start];
                // circular condition
                if (last - first <= 4L * side - d) {
                    return true;
                }
            }
        }

        return false;
    }

    private int lowerBound(long[] arr, int l, int r, long target) {
        int res = r;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] >= target) {
                res = mid;
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}