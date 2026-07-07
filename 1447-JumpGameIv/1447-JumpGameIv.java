// Last updated: 7/7/2026, 11:00:43 PM
class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;

        if (n == 1) return 0;

        Map<Integer, List<Integer>> map = new HashMap<>();

        // Store indices for each value
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.offer(0);
        visited[0] = true;

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int idx = q.poll();

                if (idx == n - 1) {
                    return steps;
                }

                // Jump to idx - 1
                if (idx - 1 >= 0 && !visited[idx - 1]) {
                    visited[idx - 1] = true;
                    q.offer(idx - 1);
                }

                // Jump to idx + 1
                if (idx + 1 < n && !visited[idx + 1]) {
                    visited[idx + 1] = true;
                    q.offer(idx + 1);
                }

                // Jump to same value indices
                if (map.containsKey(arr[idx])) {
                    for (int next : map.get(arr[idx])) {
                        if (!visited[next]) {
                            visited[next] = true;
                            q.offer(next);
                        }
                    }

                    // IMPORTANT: clear to avoid TLE
                    map.remove(arr[idx]);
                }
            }

            steps++;
        }

        return -1;
    }
}