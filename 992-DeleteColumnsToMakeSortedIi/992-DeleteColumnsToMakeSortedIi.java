// Last updated: 7/7/2026, 11:01:00 PM
class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length, m = strs[0].length();
        boolean[] sorted = new boolean[n - 1];
        int deletions = 0;

        for (int col = 0; col < m; col++) {
            boolean delete = false;

            for (int i = 0; i < n - 1; i++) {
                if (!sorted[i] && strs[i].charAt(col) > strs[i + 1].charAt(col)) {
                    delete = true;
                    break;
                }
            }

            if (delete) {
                deletions++;
            } else {
                for (int i = 0; i < n - 1; i++) {
                    if (strs[i].charAt(col) < strs[i + 1].charAt(col)) {
                        sorted[i] = true;
                    }
                }
            }
        }

        return deletions;
    }
}