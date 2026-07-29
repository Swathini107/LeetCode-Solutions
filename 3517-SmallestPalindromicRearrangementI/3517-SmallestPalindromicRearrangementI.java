// Last updated: 7/29/2026, 9:26:36 AM
1class Solution {
2    public String smallestPalindrome(String s) {
3        int[] freq = new int[26];
4
5        for (char c : s.toCharArray()) {
6            freq[c - 'a']++;
7        }
8
9        int n = s.length();
10        char[] ans = new char[n];
11
12        int left = 0, right = n - 1;
13
14        for (int i = 0; i < 26; i++) {
15            while (freq[i] >= 2) {
16                ans[left++] = (char) ('a' + i);
17                ans[right--] = (char) ('a' + i);
18                freq[i] -= 2;
19            }
20
21            if (freq[i] == 1) {
22                ans[n / 2] = (char) ('a' + i);
23            }
24        }
25
26        return new String(ans);
27    }
28}