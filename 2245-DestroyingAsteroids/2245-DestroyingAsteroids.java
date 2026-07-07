// Last updated: 7/7/2026, 10:59:35 PM
class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);

        long currMass = mass;

        for (int asteroid : asteroids) {
            if (currMass < asteroid) {
                return false;
            }
            currMass += asteroid;
        }

        return true;
    }
}