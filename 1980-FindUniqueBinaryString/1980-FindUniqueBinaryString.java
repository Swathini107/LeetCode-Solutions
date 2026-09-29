// Last updated: 9/29/2026, 11:10:30 AM
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char c = nums[i].charAt(i);
            result.append(c == '0' ? '1' : '0');
        }

        return result.toString();
    }
}