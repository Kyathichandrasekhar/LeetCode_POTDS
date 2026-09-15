class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] visited = new int[n][m];
        int[][] ans = new int[n][m];

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i, j, 0});
                    visited[i][j] = 1;
                }
            }
        }

        int dirow[] = {-1, 0, +1, 0};
        int dicol[] = {0, +1, 0, -1};

        while(!q.isEmpty()){
            int[] cell = q.poll();

            int row = cell[0];
            int col = cell[1];
            int steps = cell[2];

            ans[row][col] = steps;

            for(int i = 0; i < 4; i++){
                int nrow = row + dirow[i];
                int ncol = col + dicol[i];

                if(nrow >= 0 && ncol >= 0 &&
                   nrow < n && ncol < m &&
                   visited[nrow][ncol] == 0){

                    q.add(new int[]{nrow, ncol, steps + 1});
                    visited[nrow][ncol] = 1;
                }
            }
        }

        return ans;
    }
}