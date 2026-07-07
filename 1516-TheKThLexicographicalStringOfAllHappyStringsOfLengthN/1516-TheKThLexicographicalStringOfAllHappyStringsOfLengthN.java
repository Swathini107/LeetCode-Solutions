// Last updated: 7/7/2026, 11:00:33 PM
class Solution {

    public String getHappyString(int n, int k) {
        java.util.List<String> list = new java.util.ArrayList<>();
        backtrack("", n, list);

        if (k > list.size()) return "";
        return list.get(k - 1);
    }

    private void backtrack(String current, int n, java.util.List<String> list) {

        if (current.length() == n) {
            list.add(current);
            return;
        }

        char[] chars = {'a','b','c'};

        for (char c : chars) {
            if (current.length() == 0 || current.charAt(current.length()-1) != c) {
                backtrack(current + c, n, list);
            }
        }
    }
}