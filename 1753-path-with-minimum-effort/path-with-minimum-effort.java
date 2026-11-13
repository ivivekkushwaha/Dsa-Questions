
class Solution {
    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[2], b[2])
        );

        dist[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});

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

                    int diff = Math.abs(
                        heights[nr][nc] - heights[rn][cn]
                    );

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


//     public void dfs(int rn, int cn, int[][] heights, int wt, boolean[][] visited) {

//         if (rn == heights.length - 1 && cn == heights[0].length - 1) {
//             ans = Math.min(ans, wt);
//             return;
//         }

//         visited[rn][cn] = true;

// int[] row = {-1, 1, 0, 0};
// int[] col = {0, 0, -1, 1};

// for (int i = 0; i < 4; i++) {
//     int nr = rn + row[i];
//     int nc = cn + col[i];

//     if (nr >= 0 && nc >= 0 &&
//         nr < heights.length && nc < heights[0].length &&
//         !visited[nr][nc]) {

//         int newWt = Math.max(
//             wt,
//             Math.abs(heights[rn][cn] - heights[nr][nc])
//         );

//         dfs(nr, nc, heights, newWt, visited);
//     }
// }

//         visited[rn][cn] = false; // Backtracking
//     }
