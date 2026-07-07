// Last updated: 7/7/2026, 10:58:41 PM
class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        List<Integer> ans = new ArrayList<>();
        
        for (int idx : queries) {
            int val = nums[idx];
            List<Integer> list = map.get(val);
            
            if (list.size() == 1) {
                ans.add(-1);
                continue;
            }
            
            int pos = Collections.binarySearch(list, idx);
            int m = list.size();
            
            int prev = list.get((pos - 1 + m) % m);
            int next = list.get((pos + 1) % m);
            
            int d1 = Math.abs(idx - prev);
            d1 = Math.min(d1, n - d1);
            
            int d2 = Math.abs(idx - next);
            d2 = Math.min(d2, n - d2);
            
            ans.add(Math.min(d1, d2));
        }
        
        return ans;
    }
}