// Last updated: 7/7/2026, 10:58:16 PM
import java.util.*;

class Solution {

    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        int ans = Integer.MAX_VALUE;

        RideInfo water = build(waterStartTime, waterDuration);
        RideInfo land = build(landStartTime, landDuration);

        // Land -> Water
        for (int i = 0; i < landStartTime.length; i++) {
            int finishLand = landStartTime[i] + landDuration[i];
            ans = Math.min(ans, query(water, finishLand));
        }

        // Water -> Land
        for (int i = 0; i < waterStartTime.length; i++) {
            int finishWater = waterStartTime[i] + waterDuration[i];
            ans = Math.min(ans, query(land, finishWater));
        }

        return ans;
    }

    static class RideInfo {
        int[] start;
        int[] prefMinDur;
        int[] suffMinFinish;
    }

    private RideInfo build(int[] startTime, int[] duration) {
        int n = startTime.length;

        int[][] rides = new int[n][2];
        for (int i = 0; i < n; i++) {
            rides[i][0] = startTime[i];
            rides[i][1] = duration[i];
        }

        Arrays.sort(rides, (a, b) -> Integer.compare(a[0], b[0]));

        RideInfo info = new RideInfo();
        info.start = new int[n];
        info.prefMinDur = new int[n];
        info.suffMinFinish = new int[n + 1];

        for (int i = 0; i < n; i++) {
            info.start[i] = rides[i][0];
        }

        info.prefMinDur[0] = rides[0][1];
        for (int i = 1; i < n; i++) {
            info.prefMinDur[i] = Math.min(info.prefMinDur[i - 1], rides[i][1]);
        }

        info.suffMinFinish[n] = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            int val = rides[i][0] + rides[i][1];
            info.suffMinFinish[i] =
                    Math.min(val, info.suffMinFinish[i + 1]);
        }

        return info;
    }

    private int query(RideInfo info, int t) {
        int n = info.start.length;

        int l = 0, r = n - 1, pos = -1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (info.start[mid] <= t) {
                pos = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        int ans = Integer.MAX_VALUE;

        if (pos >= 0) {
            ans = Math.min(ans, t + info.prefMinDur[pos]);
        }

        ans = Math.min(ans, info.suffMinFinish[pos + 1]);

        return ans;
    }
}