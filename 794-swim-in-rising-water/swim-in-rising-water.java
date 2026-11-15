class Solution {
    public int swimInWater(int[][] grid) {
        int l = 0, h=Integer.MIN_VALUE; 
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]>h)h = grid[i][j];
            }
        }
        int curr = h;
        while(l<=h){
            int mid = l+(h - l)/2;
            if(bfs(grid, mid)){
                curr = mid;
                h = mid-1;
            }else{
                l = mid+1;
            }
            
        }
        return curr;
    }
    public boolean bfs(int[][] grid, int money) {
        if(money<grid[0][0])return false;
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        int vis[][] = new int[n][m];
        
        q.add(new int[]{0, 0});

        int[] row = {-1, 1, 0, 0};
        int[] col = {0, 0, -1, 1};

        while (!q.isEmpty()) {

            int[] node = q.poll();

            int rn = node[0];
            int cn = node[1];

            if (rn == n - 1 && cn == m - 1) {
                return true;
            }

            

            for (int i = 0; i < 4; i++) {

                int nr = rn + row[i];
                int nc = cn + col[i];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m && money>=grid[nr][nc] && vis[nr][nc]!= 1) {


                    q.add(new int[]{nr, nc});
                    vis[nr][nc] = 1;
                    
                }
            }
        }

        return false;
    }
}