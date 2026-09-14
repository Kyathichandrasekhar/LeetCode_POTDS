class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];

        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;

        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i, j});
                    visited[i][j] = 1;
                }

                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        //To check all 4 directions we make the row and col details
        int dirow[] ={-1,0,+1,0};
        int dicol[] ={0,+1,0,-1};

        //traversal
        int time = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int j =0;j<size;j++){
                int[] cell = q.poll();

                int row = cell[0];
                int col = cell[1];

                for(int i =0;i<4;i++){
                    int nrow = row + dirow[i];
                    int ncol = col + dicol[i];

                    if(nrow >=0 && ncol>=0 && nrow<n && ncol<m && visited[nrow][ncol]==0 && grid[nrow][ncol]==1){
                        q.add(new int[]{nrow, ncol});
                        visited[nrow][ncol]=1;
                        fresh--;
                    }
                }
            }

            if(!q.isEmpty()){
                time++;
            }
        }

        if(fresh>0){
            return -1;
        }

        return time;
    }
}