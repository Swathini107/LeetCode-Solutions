// Last updated: 7/7/2026, 10:58:47 PM
class Solution {

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        long left = 0;
        long right = (long)1e18;
        long ans = right;

        while (left <= right) {

            long mid = (left + right) / 2;

            if (can(mid, mountainHeight, workerTimes)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private boolean can(long time, int height, int[] workers) {

        long total = 0;

        for (int w : workers) {

            long val = (2 * time) / w;

            long x = (long)((Math.sqrt(1 + 4.0 * val) - 1) / 2);

            total += x;

            if (total >= height) return true;
        }

        return total >= height;
    }
}