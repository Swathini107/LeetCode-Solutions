// Last updated: 7/7/2026, 11:01:27 PM
class Solution {
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {

                // Minimum in right half
                left = mid + 1;

            } else if (nums[mid] < nums[right]) {

                // Minimum in left half including mid
                right = mid;

            } else {

                // Duplicate case
                right--;
            }
        }

        return nums[left];
    }
}