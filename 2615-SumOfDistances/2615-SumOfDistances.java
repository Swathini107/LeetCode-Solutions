// Last updated: 9/29/2026, 11:09:09 AM
import java.util.*;

class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];
        
        // Step 1: group indices
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        // Step 2: process each group
        for (List<Integer> list : map.values()) {
            int k = list.size();
            
            long[] prefix = new long[k + 1];
            for (int i = 0; i < k; i++) {
                prefix[i + 1] = prefix[i] + list.get(i);
            }
            
            for (int j = 0; j < k; j++) {
                int idx = list.get(j);
                
                long left = (long) j * idx - prefix[j];
                long right = (prefix[k] - prefix[j + 1]) - (long)(k - j - 1) * idx;
                
                ans[idx] = left + right;
            }
        }
        
        return ans;
    }
}