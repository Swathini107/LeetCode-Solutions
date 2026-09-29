// Last updated: 9/29/2026, 11:07:49 AM
class Solution {
    public int numberOfSpecialChars(String word) {

        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];

        for (char ch : word.toCharArray()) {

            if (Character.isLowerCase(ch)) {
                lower[ch - 'a'] = true;
            } else {
                upper[ch - 'A'] = true;
            }
        }

        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (lower[i] && upper[i]) {
                count++;
            }
        }

        return count;
    }
}