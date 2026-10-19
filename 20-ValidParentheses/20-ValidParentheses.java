// Last updated: 10/19/2026, 6:54:17 PM
class Solution {
    public boolean isValid(String str) {
        if (str.length() % 2 == 1)
            return false;

        char[] S = str.toCharArray();
        int j = 0;

        for (char c : S)
            if ((c & 3) != 1)
                S[j++] = c;
            else if (j == 0 || ((c - S[--j] + 1) >> 1) != 1)
                return false;        

        return j == 0;
    }
}