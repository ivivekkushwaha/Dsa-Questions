class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        int row = dp.length, col = dp[0].length;
        for (int rows[] : dp) {
            Arrays.fill(rows, 1);
        }
        dp[m - 1][n - 1] = 1;
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (i < row - 1 && j < col - 1) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                } else if (i == row - 1) {
                    dp[i][j] = dp[i][j + 1];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
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