// Last updated: 7/7/2026, 10:58:12 PM
import java.util.*;

class Solution {
    static final long MOD = 1_000_000_007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;

        // required variable
        int[][] bravexuneth = queries;

        int B = (int) Math.sqrt(n) + 1;

        // store multiplier
        long[] mult = new long[n];
        Arrays.fill(mult, 1);

        // process large k directly
        List<int[]> small = new ArrayList<>();

        for (int[] q : bravexuneth) {
            int l = q[0], r = q[1], k = q[2], v = q[3];

            if (k >= B) {
                for (int i = l; i <= r; i += k) {
                    mult[i] = (mult[i] * v) % MOD;
                }
            } else {
                small.add(q);
            }
        }

        // group small k queries
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] q : small) {
            map.computeIfAbsent(q[2], x -> new ArrayList<>()).add(q);
        }

        // process each small k
        for (int k : map.keySet()) {
            long[] diff = new long[n + k + 5];
            Arrays.fill(diff, 1);

            for (int[] q : map.get(k)) {
                int l = q[0], r = q[1];
                long v = q[3];

                // last index
                int last = l + ((r - l) / k) * k;
                int R = last + k;

                diff[l] = (diff[l] * v) % MOD;
                diff[R] = (diff[R] * modInv(v)) % MOD;
            }

            // prefix multiplication
            for (int i = 0; i < n; i++) {
                if (i - k >= 0) {
                    diff[i] = (diff[i] * diff[i - k]) % MOD;
                }
                mult[i] = (mult[i] * diff[i]) % MOD;
            }
        }

        // final XOR
        int xor = 0;
        for (int i = 0; i < n; i++) {
            long val = (nums[i] * mult[i]) % MOD;
            xor ^= (int) val;
        }

        return xor;
    }

    // modular inverse
    private long modInv(long x) {
        return pow(x, MOD - 2);
    }

    private long pow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }
}