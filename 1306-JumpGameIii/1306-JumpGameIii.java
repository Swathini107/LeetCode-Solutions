// Last updated: 9/29/2026, 11:13:23 AM
class Solution {
    public boolean canReach(int[] arr, int start) {

        int n = arr.length;

        boolean[] vis = new boolean[n];

        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        vis[start] = true;

        while (!q.isEmpty()) {

            int i = q.poll();

            if (arr[i] == 0) {
                return true;
            }

            int left = i - arr[i];
            int right = i + arr[i];

            if (left >= 0 && !vis[left]) {
                vis[left] = true;
                q.offer(left);
            }

            if (right < n && !vis[right]) {
                vis[right] = true;
                q.offer(right);
            }
        }

        return false;
    }
}