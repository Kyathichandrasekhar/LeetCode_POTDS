class Solution {
    public boolean dfs(int node, List<List<Integer>> adj,
                       boolean[] vis, boolean[] pathVis) {

        vis[node] = true;
        pathVis[node] = true;

        for (int it : adj.get(node)) {

            if (!vis[it]) {

                if (dfs(it, adj, vis, pathVis)) {
                    return true;
                }

            } else if (pathVis[it]) {

                return true;
            }
        }

        pathVis[node] = false;

        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for (int[] pair : prerequisites) {

            int course = pair[0];
            int prerequisite = pair[1];

            adj.get(prerequisite).add(course);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] pathVis = new boolean[numCourses];

        // Check every component
        for (int i = 0; i < numCourses; i++) {

            if (!vis[i]) {

                if (dfs(i, adj, vis, pathVis)) {
                    return false;  // Cycle exists
                }
            }
        }

        return true;  // No cycle
    }
}