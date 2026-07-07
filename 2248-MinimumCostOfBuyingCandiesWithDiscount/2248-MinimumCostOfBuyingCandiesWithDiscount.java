// Last updated: 7/7/2026, 10:59:33 PM
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