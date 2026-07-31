// Last updated: 7/31/2026, 6:06:12 PM
1class Solution {
2    public int minimumPushes(String word) {
3
4        //Calculate frequency of each character
5        int[] freq = new int[26];
6
7        for(char ch: word.toCharArray())
8        {
9            freq[ch - 'a']++;
10        }
11
12        Arrays.sort(freq);
13
14        int ans=0;
15        for(int i=25,pos=0; i>=0 && freq[i] > 0; i--,pos++)
16        {
17            ans += freq[i]*(pos/8 + 1);
18        }
19        return ans;
20
21        
22    }
23}