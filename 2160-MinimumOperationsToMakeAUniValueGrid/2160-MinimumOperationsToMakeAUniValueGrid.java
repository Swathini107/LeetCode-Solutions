// Last updated: 7/7/2026, 10:59:43 PM
import java.util.*;

class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length;
        int size = m * n;
        
        int[] arr = new int[size];
        int idx = 0;
        
        // Step 1: Flatten grid
        for (int[] row : grid) {
            for (int val : row) {
                arr[idx++] = val;
            }
        }
        
        // Step 2: Check feasibility
        int mod = arr[0] % x;
        for (int val : arr) {
            if (val % x != mod) return -1;
        }
        
        // Step 3: Sort and find median
        Arrays.sort(arr);
        int median = arr[size / 2];
        
        // Step 4: Calculate operations
        int ops = 0;
        for (int val : arr) {
            ops += Math.abs(val - median) / x;
        }
        
        return ops;
    }
}