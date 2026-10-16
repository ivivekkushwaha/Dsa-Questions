import java.util.*;

class Solution {
    private static final long MOD = 1_000_000_007L;

    public int sumCounts(int[] nums) {
        int n = nums.length;

        long[] sum = new long[4 * n];
        long[] sumSq = new long[4 * n];
        long[] lazy = new long[4 * n];

        Map<Integer, Integer> last = new HashMap<>();
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int prev = last.getOrDefault(nums[i], -1);

            update(1, 0, n - 1, prev + 1, i,
                   sum, sumSq, lazy);

            last.put(nums[i], i);
            ans = (ans + sumSq[1]) % MOD;
        }

        return (int) ans;
    }

    private void update(int node, int l, int r,
                        int ql, int qr,
                        long[] sum, long[] sumSq, long[] lazy) {

        if (ql > r || qr < l) return;

        if (ql <= l && r <= qr) {
            long len = r - l + 1L;
            long v = lazy[node] + 1;

            sumSq[node] = (sumSq[node]
                    + 2L * sum[node] + len) % MOD;

            sum[node] = (sum[node] + len) % MOD;
            lazy[node] = v % MOD;
            return;
        }

        push(node, l, r, sum, sumSq, lazy);

        int mid = l + (r - l) / 2;

        update(node * 2, l, mid, ql, qr,
               sum, sumSq, lazy);

        update(node * 2 + 1, mid + 1, r, ql, qr,
               sum, sumSq, lazy);

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
        sumSq[node] = (sumSq[node * 2] + sumSq[node * 2 + 1]) % MOD;
    }

    private void push(int node, int l, int r,
                      long[] sum, long[] sumSq, long[] lazy) {

        if (lazy[node] == 0 || l == r) return;

        int mid = l + (r - l) / 2;
        long v = lazy[node];

        apply(node * 2, l, mid, v, sum, sumSq, lazy);
        apply(node * 2 + 1, mid + 1, r, v, sum, sumSq, lazy);

        lazy[node] = 0;
    }

    private void apply(int node, int l, int r, long v,
                       long[] sum, long[] sumSq, long[] lazy) {

        long len = r - l + 1L;

        sumSq[node] = (sumSq[node]
                + 2L * v % MOD * sum[node] % MOD
                + v * v % MOD * len % MOD) % MOD;

        sum[node] = (sum[node] + v * len) % MOD;
        lazy[node] = (lazy[node] + v) % MOD;
    }
}