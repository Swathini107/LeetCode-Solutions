// Last updated: 7/7/2026, 10:58:11 PM
class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;

        // stack stores {maxValue, left, right}
        Deque<int[]> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            int left = i;
            int right = i;
            int mx = nums[i];

            // Merge while current value can connect
            while (!stack.isEmpty() && nums[i] < stack.peek()[0]) {

                int[] top = stack.pop();

                left = top[1];
                mx = Math.max(mx, top[0]);
            }

            stack.push(new int[]{mx, left, right});
        }

        int[] ans = new int[n];

        // Assign answers per component
        while (!stack.isEmpty()) {
            int[] comp = stack.pop();

            int mx = comp[0];
            int l = comp[1];
            int r = comp[2];

            for (int i = l; i <= r; i++) {
                ans[i] = mx;
            }
        }

        return ans;
    }
}