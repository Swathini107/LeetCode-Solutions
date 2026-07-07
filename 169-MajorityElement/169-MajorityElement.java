// Last updated: 7/7/2026, 11:01:25 PM
import java.util.*;
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}