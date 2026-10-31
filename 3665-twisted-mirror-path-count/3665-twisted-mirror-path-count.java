class Solution {
    int MOD = 1000000007;
    int[][] grid;
    int[][] dp;
    int[][][] memo;
    int m, n;

    // dir: 0 = Right, 1 = Down
    int getNext(int i, int j, int dir) {

        if(i < 0 || j < 0 || i >= m || j >= n)
            return -1;

        // Destination reached
        if(i == m-1 && j == n-1)
            return i * n + j;

        // Empty cell
        if(grid[i][j] == 0)
            return i * n + j;

        // Already calculated
        if(memo[i][j][dir] != -2)
            return memo[i][j][dir];

        int ans;

        if(dir == 0) {
            // Entered mirror from left
            ans = getNext(i+1, j, 1);
        } else {
            // Entered mirror from above
            ans = getNext(i, j+1, 0);
        }

        return memo[i][j][dir] = ans;
    }

    int dfs(int i, int j) {

        if(i == m-1 && j == n-1)
            return 1;

        if(dp[i][j] != -1)
            return dp[i][j];

        // Try moving right
        int right = getNext(i, j+1, 0);
        int a = 0;

        if(right != -1) {
            a = dfs(right / n, right % n);
        }

        // Try moving down
        int down = getNext(i+1, j, 1);
        int b = 0;

        if(down != -1) {
            b = dfs(down / n, down % n);
        }

        return dp[i][j] = (int)(((long)a + b) % MOD);
    }

    public int uniquePaths(int[][] grid) {

        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        dp = new int[m][n];
        memo = new int[m][n][2];

        for(int[] row : dp)
            Arrays.fill(row, -1);

        for(int[][] row : memo)
            for(int[] cell : row)
                Arrays.fill(cell, -2);

        return dfs(0, 0);
    }
}
