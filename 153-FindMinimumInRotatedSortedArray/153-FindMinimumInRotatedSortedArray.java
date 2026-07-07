// Last updated: 7/7/2026, 11:01:28 PM
class Solution {
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            // Minimum is in right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            // Minimum is in left half including mid
            else {
                right = mid;
            }
        }

        return nums[left];
    }
}