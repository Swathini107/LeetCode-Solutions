// Last updated: 7/7/2026, 10:57:52 PM
import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        // store indices
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(i);
        }

        int ans = Integer.MAX_VALUE;

        // check each value
        for (List<Integer> list : map.values()) {
            if (list.size() < 3) continue;

            for (int i = 0; i + 2 < list.size(); i++) {
                int first = list.get(i);
                int third = list.get(i + 2);

                int dist = 2 * (third - first);
                ans = Math.min(ans, dist);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}