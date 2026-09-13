class Solution {
    void dfs(int u, ArrayList<ArrayList<Integer>> adjLs, boolean[] visited) {
        visited[u] = true;

        for(int v : adjLs.get(u)) {
            if(!visited[v]) {
                dfs(v, adjLs, visited);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {

        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<>();
        int V = isConnected.length;

        for(int i = 0; i < V; i++) {
            adjLs.add(new ArrayList<>());
        }
        
        for(int i = 0; i < V; i++) {
            for(int j = 0; j < V; j++) {
                if(isConnected[i][j] == 1 && i < j) {
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }

        int count = 0;
        boolean[] visited = new boolean[V];

        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                count++;
                dfs(i, adjLs, visited);
            }
        }

        return count;
    }
}