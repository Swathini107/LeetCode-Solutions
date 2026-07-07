// Last updated: 7/7/2026, 11:00:29 PM
class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] trailing = new int[n];

        // Step 1: Count trailing zeros
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0 && grid[i][j] == 0; j--) {
                count++;
            }
            trailing[i] = count;
        }

        int swaps = 0;

        // Step 2: Greedy placement
        for (int i = 0; i < n; i++) {
            int needed = n - i - 1;
            int j = i;

            while (j < n && trailing[j] < needed) {
                j++;
            }

            if (j == n) return -1;

            // Bring row j up to i
            while (j > i) {
                int temp = trailing[j];
                trailing[j] = trailing[j - 1];
                trailing[j - 1] = temp;
                swaps++;
                j--;
            }
        }

        return swaps;
    }
}