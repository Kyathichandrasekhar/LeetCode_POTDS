class Solution {
    public void dfs(char[][] board, int i, int j, int n, int m, boolean[][] visited) {
            int[] Drow = {-1, 0, 1, 0};
            int[] Dcol = {0, 1, 0, -1};

            visited[i][j] = true;

            for (int k = 0; k < 4; k++) {
                int nrow = i + Drow[k];
                int ncol = j + Dcol[k];

                if (nrow >= 0 && nrow < n &&
                    ncol >= 0 && ncol < m &&
                    board[nrow][ncol] == 'O' &&
                    !visited[nrow][ncol]) {

                    dfs(board, nrow, ncol, n, m, visited);
                }
            }
        }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] visited = new boolean[n][m];

        for(int i =0;i<n;i++){
            for(int j = 0;j<m;j++){
                if((i==0 || j ==0 || i == n-1 || j == m-1) && visited[i][j] != true && board[i][j] == 'O'){
                    dfs(board,i,j,n,m,visited);
                }
            }
        }
        for(int i =0;i<n;i++){
            for(int j= 0;j<m;j++){
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}