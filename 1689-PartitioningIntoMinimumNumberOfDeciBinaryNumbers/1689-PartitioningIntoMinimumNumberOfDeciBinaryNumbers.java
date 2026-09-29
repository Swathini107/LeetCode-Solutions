// Last updated: 9/29/2026, 11:11:39 AM
class Solution {
    public int minPartitions(String n) {
        int maxDigit = 0;

        for (char c : n.toCharArray()) {
            maxDigit = Math.max(maxDigit, c - '0');
            
            // Early stop if 9 found
            if (maxDigit == 9) return 9;
        }

        return maxDigit;
    }
}