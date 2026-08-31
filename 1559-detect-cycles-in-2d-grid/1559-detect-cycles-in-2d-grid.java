class Solution {
    public boolean containsCycle(char[][] grid) {
          int n = grid.length;
          int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j =0; j < m; j++) {
           if(!vis[i][j]) {
          q.add(new Pair(i, j, -1, -1));
          vis[i][j] = true;
          // ye dono for loop disconnted components ko check krne ke lie jo ki different char ho skte hai that may turn into a diff cycle


        // yha we want ki phele ek node process ho and uska pura bfs ho and agr cycle hai to detect ho thats why if ke andr while loop hai
         while(!q.isEmpty()) {
        Pair p = q.poll();
        int row = p.row;
        int col = p.col;
        int parentRow = p.parentRow;
        int parentCol = p.parentCol;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        for(int k = 0; k < 4; k++) {
        int newrow = row + dr[k];
        int newcol = col + dc[k];
        if(newrow >= 0 && newrow < n && newcol >= 0 && newcol < m) {
         if(grid[row][col] == grid[newrow][newcol] && !vis[newrow][newcol]) {
             vis[newrow][newcol] = true;
           q.add(new Pair(newrow, newcol, row, col));
            }
           else if(vis[newrow][newcol] &&
   grid[row][col] == grid[newrow][newcol] &&
   (newrow != parentRow || newcol != parentCol)) {
                return true;
            }
        }
        }
        }
           }
            }
        }
        return false;
    }
}
class Pair {
    int row;
    int col;
    int parentRow;
    int parentCol;

    Pair(int row, int col, int parentRow, int parentCol) {
        this.row = row;
        this.col = col;
        this.parentRow = parentRow;
        this.parentCol = parentCol;
    }
}