// Last updated: 7/7/2026, 11:00:13 PM
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