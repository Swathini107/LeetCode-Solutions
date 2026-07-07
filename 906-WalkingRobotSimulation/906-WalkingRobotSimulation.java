// Last updated: 7/7/2026, 11:01:02 PM
import java.util.*;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Long> set = new HashSet<>();

        // Store obstacles
        for (int[] o : obstacles) {
            long key = encode(o[0], o[1]);
            set.add(key);
        }

        int x = 0, y = 0;
        int dir = 0; // 0=N, 1=E, 2=S, 3=W

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int maxDist = 0;

        for (int cmd : commands) {
            if (cmd == -1) {
                dir = (dir + 1) % 4; // turn right
            } else if (cmd == -2) {
                dir = (dir + 3) % 4; // turn left
            } else {
                for (int i = 0; i < cmd; i++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if (set.contains(encode(nx, ny))) break;

                    x = nx;
                    y = ny;

                    maxDist = Math.max(maxDist, x * x + y * y);
                }
            }
        }

        return maxDist;
    }

    private long encode(int x, int y) {
        return ((long)x << 32) | (y & 0xffffffffL);
    }
}