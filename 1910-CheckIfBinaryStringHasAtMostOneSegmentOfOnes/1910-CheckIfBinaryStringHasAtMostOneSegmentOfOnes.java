// Last updated: 7/7/2026, 11:00:04 PM
class Solution {
    public boolean checkOnesSegment(String s) {
        boolean zeroFound = false;

        for (char c : s.toCharArray()) {
            if (c == '0') {
                zeroFound = true;
            } 
            else if (zeroFound) {
                return false;
            }
        }

        return true;
    }
}