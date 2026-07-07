// Last updated: 7/7/2026, 10:58:25 PM
class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                sb.append(c);
            } 
            else if (c == '*') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } 
            else if (c == '#') {
                String curr = sb.toString();
                sb.append(curr);
            } 
            else if (c == '%') {
                sb.reverse();
            }
        }

        return sb.toString();
    }
}