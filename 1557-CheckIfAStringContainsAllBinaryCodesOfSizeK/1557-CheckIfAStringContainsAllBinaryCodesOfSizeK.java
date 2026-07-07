// Last updated: 7/7/2026, 11:00:30 PM
class Solution {
    public boolean hasAllCodes(String s, int k) {
        int need = 1 << k; // 2^k
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i + k <= s.length(); i++) {
            set.add(s.substring(i, i + k));
            if (set.size() == need) return true; // early stop
        }

        return set.size() == need;
    }
}