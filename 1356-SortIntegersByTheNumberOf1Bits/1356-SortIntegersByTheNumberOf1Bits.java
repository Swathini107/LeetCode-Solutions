// Last updated: 9/29/2026, 11:13:12 AM
class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] nums = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) nums[i] = arr[i];

        Arrays.sort(nums, (a, b) -> {
            int bitsA = Integer.bitCount(a);
            int bitsB = Integer.bitCount(b);
            if (bitsA == bitsB) return a - b; // tie → normal ascending
            return bitsA - bitsB;
        });

        for (int i = 0; i < arr.length; i++) arr[i] = nums[i];
        return arr;
    }
}
