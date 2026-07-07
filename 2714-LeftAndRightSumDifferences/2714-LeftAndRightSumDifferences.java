// Last updated: 7/7/2026, 10:59:19 PM
class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum -= nums[i]; // rightSum
            answer[i] = Math.abs(leftSum - totalSum);
            leftSum += nums[i];
        }

        return answer;
    }
}