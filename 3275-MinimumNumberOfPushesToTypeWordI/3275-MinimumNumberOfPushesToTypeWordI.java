// Last updated: 7/31/2026, 6:07:08 PM
class Solution {
    public int minimumPushes(String word) {
        int ans=0;
        for(int i=0;i<word.length();i++){
            ans += (i/8)+1;
        }
        return ans;

    }
}