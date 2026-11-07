class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        // First and last column
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O')
                dfs(i, 0, board);

            if (board[i][col - 1] == 'O')
                dfs(i, col - 1, board);
        }

        // First and last row
        for (int j = 0; j < col; j++) {
            if (board[0][j] == 'O')
                dfs(0, j, board);

            if (board[row - 1][j] == 'O')
                dfs(row - 1, j, board);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(int rn, int cn, char[][] board) {
        if (rn < 0 || cn < 0 || rn >= board.length || cn >= board[0].length || board[rn][cn] == 'X') {
            return;
        }
        board[rn][cn] = '#';
        int[] row = { -1, 1, 0, 0 };
        int[] col = { 0, 0, -1, 1 };
        for (int i = 0; i < 4; i++) {
            int nr = rn + row[i];
            int nc = cn + col[i];
            if (nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length && board[nr][nc] == 'O') {
                dfs(nr, nc, board);
            }
        }
    }
}