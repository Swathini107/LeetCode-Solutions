// Last updated: 7/7/2026, 11:01:17 PM
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child=0;
        int cookies=0;
        while( child < g.length && cookies < s.length){
            if(g[child]<=s[cookies]){
                child++;
            }
            cookies++;
        }
        return child++;
    }
}