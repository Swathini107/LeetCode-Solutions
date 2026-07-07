// Last updated: 7/7/2026, 10:59:55 PM
class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int n1 = nums1.length, n2 = nums2.length;
        int maxDist = 0;

        while (i < n1 && j < n2) {
            if (nums1[i] <= nums2[j]) {
                maxDist = Math.max(maxDist, j - i);
                j++; // try to expand distance
            } else {
                i++; // need smaller nums1[i]
            }
        }

        return maxDist;
    }
}