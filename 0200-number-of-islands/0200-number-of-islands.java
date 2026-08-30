class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length; 
      Queue<Pair> q = new LinkedList<>();
      boolean[][] vis = new boolean[n][m]; 
      int count = 0;
      for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            if(grid[i][j] == '1' && !vis[i][j]) {
                count++;
                vis[i][j] = true;
            q.add(new Pair(i, j));  
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
        if (newrow >= 0 && newrow < n &&
   newcol >= 0 && newcol < m && grid[newrow][newcol] == '1' && !vis[newrow][newcol]) {
         vis[newrow][newcol] = true;
       q.add(new Pair(newrow, newcol));
     }
            }
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