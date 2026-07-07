// Last updated: 7/7/2026, 11:00:55 PM
class Solution {

    public int[] pathsWithMaxScore(List<String> board) {

        int n = board.size();
        int MOD = 1_000_000_007;

        int[][] score = new int[n][n];
        int[][] ways = new int[n][n];

        for (int[] row : score)
            Arrays.fill(row, -1);

        score[n - 1][n - 1] = 0;
        ways[n - 1][n - 1] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if (board.get(i).charAt(j) == 'X')
                    continue;

                if (i == n - 1 && j == n - 1)
                    continue;

                int best = -1;
                int cnt = 0;

                int[][] dir = {{1,0},{0,1},{1,1}};

                for (int[] d : dir) {

                    int x = i + d[0];
                    int y = j + d[1];

                    if (x >= n || y >= n)
                        continue;

                    if (score[x][y] == -1)
                        continue;

                    if (score[x][y] > best) {
                        best = score[x][y];
                        cnt = ways[x][y];
                    } else if (score[x][y] == best) {
                        cnt = (cnt + ways[x][y]) % MOD;
                    }
                }

                if (best == -1)
                    continue;

                char c = board.get(i).charAt(j);

                if (c != 'S' && c != 'E')
                    best += c - '0';

                score[i][j] = best;
                ways[i][j] = cnt;
            }
        }

        if (ways[0][0] == 0)
            return new int[]{0, 0};

        return new int[]{score[0][0], ways[0][0]};
    }
}