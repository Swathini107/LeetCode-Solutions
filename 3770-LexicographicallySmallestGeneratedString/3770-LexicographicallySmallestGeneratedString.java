// Last updated: 7/7/2026, 10:58:40 PM
class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int len = n + m - 1;

        char[] word = new char[len];
        boolean[] fixed = new boolean[len];

        // Step 1: initialize
        for (int i = 0; i < len; i++) {
            word[i] = '?';
        }

        // Step 2: apply 'T'
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    int idx = i + j;
                    if (word[idx] != '?' && word[idx] != str2.charAt(j)) {
                        return "";
                    }
                    word[idx] = str2.charAt(j);
                    fixed[idx] = true;
                }
            }
        }

        // Step 3: fill remaining with 'a'
        for (int i = 0; i < len; i++) {
            if (word[i] == '?') {
                word[i] = 'a';
            }
        }

        // Step 4: handle 'F'
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {

                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (word[i + j] != str2.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    boolean changed = false;

                    // change rightmost non-fixed
                    for (int j = m - 1; j >= 0; j--) {
                        int idx = i + j;

                        if (!fixed[idx]) {
                            word[idx] = 'b';  // guaranteed different
                            changed = true;
                            break;
                        }
                    }

                    if (!changed) return "";
                }
            }
        }

        return new String(word);
    }
}