class Solution {
    public void solve(char[][] board) {
     int n = board.length;
     int m = board[0].length;   
    Queue<Pair> q = new LinkedList<>();
    boolean[][] vis = new boolean[n][m];
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            if(board[0][j] == 'O') {
            vis[0][j] = true; 
            q.add(new Pair(0, j));
          }
             if(board[n-1][j] == 'O') {
            vis[n-1][j] = true; 
            q.add(new Pair(n-1, j));
          }
             if(board[i][0] == 'O') {
            vis[i][0] = true; 
            q.add(new Pair(i, 0));
          }
             if(board[i][m-1] == 'O') {
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
     if(newrow >= 0 && newrow < n && newcol >= 0 && newcol < m && !vis[newrow][newcol] && board[newrow][newcol] == 'O') {
     vis[newrow][newcol] = true;
     q.add(new Pair(newrow, newcol));
     }
     } 
     }
      for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            if(board[i][j] == 'O' && !vis[i][j]) {
    board[i][j] = 'X';
}
        }
      }
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