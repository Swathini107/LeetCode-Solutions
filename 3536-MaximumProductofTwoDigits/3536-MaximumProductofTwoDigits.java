// Last updated: 7/25/2026, 9:03:33 AM
1class Solution {
2    public int maxProduct(int n) {
3
4        int first = 0;
5
6        int second = 0;
7
8        while (n > 0) {
9
10            int digit = n % 10;
11
12            if (digit >= first) {
13                second = first;
14                first = digit;
15            } else if (digit > second) {
16                second = digit;
17            }
18
19            n /= 10;
20        }
21
22        return first * second;
23    }
24}