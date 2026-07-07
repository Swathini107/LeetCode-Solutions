// Last updated: 7/7/2026, 10:59:15 PM
import java.util.*;

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;

        // robot: [pos, health, dir, index]
        int[][] robots = new int[n][4];

        for (int i = 0; i < n; i++) {
            robots[i][0] = positions[i];
            robots[i][1] = healths[i];
            robots[i][2] = directions.charAt(i); // store char as int
            robots[i][3] = i;
        }

        // sort by position
        Arrays.sort(robots, (a, b) -> a[0] - b[0]);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            if (robots[i][2] == 'R') {
                stack.push(i);
            } else {
                // L robot
                while (!stack.isEmpty() && robots[i][1] > 0) {
                    int j = stack.peek();

                    if (robots[j][1] < robots[i][1]) {
                        // R dies
                        stack.pop();
                        robots[i][1]--; 
                        robots[j][1] = 0;
                    } 
                    else if (robots[j][1] > robots[i][1]) {
                        // L dies
                        robots[j][1]--;
                        robots[i][1] = 0;
                        break;
                    } 
                    else {
                        // both die
                        stack.pop();
                        robots[i][1] = 0;
                        robots[j][1] = 0;
                        break;
                    }
                }
            }
        }

        // collect survivors
        List<int[]> survivors = new ArrayList<>();

        for (int[] r : robots) {
            if (r[1] > 0) {
                survivors.add(r);
            }
        }

        // sort back to original order
        survivors.sort((a, b) -> a[3] - b[3]);

        List<Integer> result = new ArrayList<>();
        for (int[] r : survivors) {
            result.add(r[1]);
        }

        return result;
    }
}