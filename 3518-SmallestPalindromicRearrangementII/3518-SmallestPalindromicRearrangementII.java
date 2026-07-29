// Last updated: 7/29/2026, 9:27:58 AM
1class Solution {
2    public String smallestPalindrome(String s, int k) {
3        int n = s.length();
4        int halfLen = n / 2;
5
6        // Step 1: Count frequencies of characters in the first half
7        int[] freq = new int[26];
8        for (int i = 0; i < halfLen; i++) {
9            freq[s.charAt(i) - 'a']++;
10        }
11
12        // Determine middle character for odd lengths
13        char midChar = '\0';
14        if (n % 2 != 0) {
15            midChar = s.charAt(halfLen);
16        }
17
18        // Step 2: Check total possible palindromic permutations
19        long totalPermutations = countPermutations(freq, halfLen, k);
20        if (k > totalPermutations) {
21            return "";
22        }
23
24        // Step 3: Construct the first half lexicographically
25        StringBuilder firstHalf = new StringBuilder();
26        int remainingLength = halfLen;
27
28        for (int i = 0; i < halfLen; i++) {
29            for (int c = 0; c < 26; c++) {
30                if (freq[c] > 0) {
31                    // Try placing character c at position i
32                    freq[c]--;
33                    long count = countPermutations(freq, remainingLength - 1, k);
34
35                    if (k <= count) {
36                        firstHalf.append((char) ('a' + c));
37                        remainingLength--;
38                        break;
39                    } else {
40                        k -= count;
41                        freq[c]++; // Backtrack and try next character
42                    }
43                }
44            }
45        }
46
47        // Step 4: Construct the full palindrome
48        StringBuilder result = new StringBuilder(firstHalf);
49        if (n % 2 != 0) {
50            result.append(midChar);
51        }
52        result.append(new StringBuilder(firstHalf).reverse());
53
54        return result.toString();
55    }
56    private long countPermutations(int[] freq, int total, long maxCap) {
57        if (total == 0) return 1;
58
59        long ans = 1;
60        int currentTotal = 0;
61
62        for (int count : freq) {
63            if (count == 0) continue;
64            for (int j = 1; j <= count; j++) {
65                currentTotal++;
66                ans = ans * currentTotal / j;
67                if (ans > maxCap) {
68                    return maxCap + 1; // Cap value to prevent overflow
69                }
70            }
71        }
72
73        return ans;
74    }
75}