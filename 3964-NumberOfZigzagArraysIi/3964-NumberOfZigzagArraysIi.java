// Last updated: 7/7/2026, 10:58:19 PM
class Solution {
    static final long MOD = 1_000_000_007L;

    class Matrix {
        long[][] a;

        Matrix(int n) {
            a = new long[n][n];
        }
    }

    private Matrix multiply(Matrix A, Matrix B, int n) {
        Matrix C = new Matrix(n);

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (A.a[i][k] == 0) continue;

                for (int j = 0; j < n; j++) {
                    C.a[i][j] =
                        (C.a[i][j] + A.a[i][k] * B.a[k][j]) % MOD;
                }
            }
        }

        return C;
    }

    private Matrix power(Matrix base, long exp, int n) {
        Matrix res = new Matrix(n);

        for (int i = 0; i < n; i++) {
            res.a[i][i] = 1;
        }

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = multiply(res, base, n);
            }

            base = multiply(base, base, n);
            exp >>= 1;
        }

        return res;
    }

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        Matrix U = new Matrix(m);
        Matrix D = new Matrix(m);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                U.a[i][j] = 1;
            }

            for (int j = i + 1; j < m; j++) {
                D.a[i][j] = 1;
            }
        }

        Matrix UD = multiply(U, D, m);

        long steps = n - 1;

        Matrix ans = power(UD, steps / 2, m);

        if ((steps & 1) == 1) {
            ans = multiply(ans, U, m);
        }

        long total = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                total = (total + ans.a[i][j]) % MOD;
            }
        }

        return (int) ((total * 2) % MOD);
    }
}