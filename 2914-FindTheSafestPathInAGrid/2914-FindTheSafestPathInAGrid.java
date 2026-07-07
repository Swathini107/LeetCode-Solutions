// Last updated: 7/7/2026, 10:59:10 PM
class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
  int n=grid.size();
        int[] [] dist=new int[n][n];

        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=-1;
                if(grid.get(i).get(j)==1){
                    q.offer(new int[]{i,j});
                    dist[i][j]=0;
                }
            }
        }
int [] x={1,-1,0,0};
int [] y={0,0,1,-1};
        while(!q.isEmpty()){
          int [] curr=q.poll();
          int r=curr[0];
          int c=curr[1];
for(int k=0;k<4;k++){
    int r1=r+x[k];
    int c1=c+y[k];

if(r1>=0 && r1<n && c1>=0 && c1<n && dist[r1][c1]==-1){
    dist[r1][c1]=dist[r][c]+1;

    q.offer(new int[]{r1,c1});
}
}

        }


       PriorityQueue<int[]> pq =
    new PriorityQueue<>((a,b) -> b[0] - a[0]);

        pq.offer(new int[] {dist[0][0],0,0});

        boolean[][]vis=new boolean[n][n];
        vis[0][0]=true;
        while(!pq.isEmpty()){
 
int [] c2=pq.poll();
int wt=c2[0];
int r=c2[1];
int c=c2[2];

if(r==n-1 && c==n-1){
    return wt;
}
for(int k=0;k<4;k++){
       int r1=r+x[k];
    int c1=c+y[k];


if(r1>=0 && r1<n && c1>=0 && c1<n && vis[r1][c1]==false){
     
int nwt=Math.min(wt,dist[r1][c1]);
pq.offer(new int[]{nwt,r1,c1});
vis[r1][c1]=true;
}
}

        }


        return 0;
      
    }



}