// Last updated: 9/29/2026, 11:09:54 AM
import java.util.Arrays;

class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        
        int sum = 0;
        
        for (int i = cost.length - 1, c = 1; i >= 0; i--, c++) {
            if (c % 3 != 0)
                sum += cost[i];
        }
        
        return sum;
    }
}