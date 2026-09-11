class Solution {
    public int numEnclaves(int[][] grid) {
        int count  = 0;
        int n = grid.length;
        int m = grid[0].length;
      Queue<Pair> q = new LinkedList<>();
    boolean[][] vis = new boolean[n][m]; 
      for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            if(grid[0][j] == 1) {
            vis[0][j] = true; 
            q.add(new Pair(0, j));
          }
             if(grid[n-1][j] == 1) {
            vis[n-1][j] = true; 
            q.add(new Pair(n-1, j));
          }
             if(grid[i][0] == 1) {
            vis[i][0] = true; 
            q.add(new Pair(i, 0));
          }
             if(grid[i][m-1] == 1) {
            vis[i][m-1] = true; 
            q.add(new Pair(i, m-1));
          }
        }
      }  
      while(!q.isEmpty()) {
     Pair p = q.poll();
        int row = p.row;
        int col = p.col;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1}; 
        for(int k = 0; k < 4; k++) {
        int newrow = row + dr[k];
        int newcol = col + dc[k];  
   if(newrow >= 0 && newrow < n && newcol >= 0 && newcol < m && grid[newrow][newcol] == 1 && !vis[newrow][newcol]) {
     vis[newrow][newcol] = true;
    q.add(new Pair(newrow, newcol));
        } 
        }
      }
            for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            if(grid[i][j] == 1 && !vis[i][j]) {
            count++;
}
      }
  }
  return count;
    }
}

class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}