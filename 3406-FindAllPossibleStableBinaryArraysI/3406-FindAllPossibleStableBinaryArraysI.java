// Last updated: 7/7/2026, 10:58:55 PM
class Solution {

    static final int MOD = 1_000_000_007;

    public int numberOfStableArrays(int zero, int one, int limit) {
        Integer[][][] memo = new Integer[zero + 1][one + 1][2];
        return (dfs(zero, one, 0, limit, memo) + dfs(zero, one, 1, limit, memo)) % MOD;
    }

    private int dfs(int z, int o, int last, int limit, Integer[][][] memo) {

        if (z == 0 && o == 0) return 1;

        if (memo[z][o][last] != null) return memo[z][o][last];

        long res = 0;

        if (last == 0) { // last placed was 0
            for (int i = 1; i <= limit && z - i >= 0; i++) {
                res = (res + dfs(z - i, o, 1, limit, memo)) % MOD;
            }
        } else { // last placed was 1
            for (int i = 1; i <= limit && o - i >= 0; i++) {
                res = (res + dfs(z, o - i, 0, limit, memo)) % MOD;
            }
        }

        memo[z][o][last] = (int) res;
        return memo[z][o][last];
    }
}