// Last updated: 7/7/2026, 10:58:30 PM
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int maxStability(int n, int[][] edges, int k) {
        int len = edges.length;
        int par[] =new int[n];
        for(int i=0;i<n;i++) par[i] = i;

        List<int[]> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int minMust = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int mustCnt = 0;
        for(int e[] : edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            int m = e[3];
            min = Math.min(min,w);
            max = Math.max(max, w);

            if(m == 1){
                int p1 = find(par, u);
                int p2 = find(par, v);

                if(p1 == p2) return -1;

                par[p1] = p2;
                minMust = Math.min(minMust, w);
                mustCnt++;
            }else{
                list.add(e);
            }
        }

        if(mustCnt == n-1) return minMust;
        Collections.sort(list, (a,b) -> b[2] - a[2]);
        int start = min;
        int end = minMust == Integer.MAX_VALUE ? 2 * max: minMust;
        int ans = -1;
        int req = n - 1 - mustCnt;
        while(start <= end){
            int mid = (start + end)/2;

            if(check(list, mid, req, par.clone(), k)){
                start = mid + 1;
                ans = mid;
            }else{
                end = mid - 1;
            }

        }

        return ans;
    }

    private boolean check(List<int[]> list, int value, int req, int par[], int k){
        for(int e[] : list){
            int u = e[0];
            int v = e[1];
            int w = e[2];

            if(w *2 < value){
                return false;
            }

            int p1 = find(par, u);
            int p2 = find(par, v);

            if(p1 == p2)  continue;
            
            if(w < value){
                if(k > 0){
                    k--;
                }
                
                else{
                    return false;
                }
            }
            
            req--;
            par[p1] =p2;
            
            if(req ==0 ) return true;
        }

        return false;
    }

    private int find(int par[], int p){
        if(par[p] == p) return p;

        return par[p] = find(par, par[p]);
    }
}