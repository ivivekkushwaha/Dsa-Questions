class Solution {
    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        // Last row
        Arrays.fill(dp[m - 1], 1);

        // Last column
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = 1;
        }

        // Fill from bottom-right to top-left
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }

        return dp[0][0];
    }

    // public int up(int i, int j, int dp[][]) {
    //     int row = dp.length, col = dp[0].length;
    //     if(i==row || j==col)return 0;
    //     if(i==row-1 && j==col-1)return 1;
    //     if(dp[i][j]!=-1)return dp[i][j];
    //     if(i<row-1 && j<col-1){
    //         int right = up(i+1, j, dp);
    //         int down = up(i, j+1, dp);
    //         return dp[i][j] = right+down;
    //     }else if(i==row-1){
    //         int down = up(i, j+1, dp);
    //         return dp[i][j] = down;
    //     }
    //     int right = up(i+1, j, dp);
    //     return dp[i][j] = right;
    // }
}