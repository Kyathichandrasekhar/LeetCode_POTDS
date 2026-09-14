class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];

        Queue<int[]> q = new LinkedList<>();

        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(i==0 || j == 0 || i == n-1 || j == m-1){
                    if(grid[i][j]==1){
                        q.add(new int[]{i, j});
                        visited[i][j] = 1;
                    }
                }
            } 
        }

        //To check all 4 directions we make the row and col details
        int dirow[] ={-1,0,+1,0};
        int dicol[] ={0,+1,0,-1};

        //traversal
        while(!q.isEmpty()){
            int[] cell = q.poll();

            int row = cell[0];
            int col = cell[1];

            for(int i =0;i<4;i++){
                int nrow = row + dirow[i];
                int ncol = col + dicol[i];

                if(nrow >=0 && ncol>=0 && nrow<n && ncol<m && visited[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    q.add(new int[]{nrow, ncol});
                    visited[nrow][ncol]=1;
                }
            }
        }

        int count = 0;
        for(int i =0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(visited[i][j]==0 && grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
}