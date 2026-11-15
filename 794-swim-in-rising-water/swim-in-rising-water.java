class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dist = new int[n][m];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[2], b[2])
        );

        dist[0][0] = grid[0][0];
        pq.offer(new int[]{0, 0, grid[0][0]});

        int[] row = {-1, 1, 0, 0};
        int[] col = {0, 0, -1, 1};

        while (!pq.isEmpty()) {

            int[] node = pq.poll();

            int rn = node[0];
            int cn = node[1];
            int wt = node[2];

            if (rn == n - 1 && cn == m - 1) {
                return wt;
            }

            if (wt > dist[rn][cn]) continue;

            for (int i = 0; i < 4; i++) {

                int nr = rn + row[i];
                int nc = cn + col[i];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m) {

                    int diff = grid[nr][nc];

                    int newEffort = Math.max(wt, diff);

                    if (newEffort < dist[nr][nc]) {

                        dist[nr][nc] = newEffort;

                        pq.offer(new int[]{nr, nc, newEffort});
                    }
                }
            }
        }

        return 0;
    }
}