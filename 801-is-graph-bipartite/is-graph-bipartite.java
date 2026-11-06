class Solution {
    boolean res = true;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int colours[] = new int[n];
        Arrays.fill(colours, -1);
        for(int i=0; i<n; i++){
            if(colours[i]==-1){
                dfs(graph, 0, i, colours);
            }
        }
        return res;
    }
    public void dfs(int[][] graph, int c, int node, int colours[] ) {
        colours[node] = c;
        for(int i=0; i<graph[node].length; i++){
            int neigh = graph[node][i];
            if(colours[neigh]!=-1 && colours[neigh]==c){
                res = false;
                return;
            }
            if(colours[neigh]==-1){
                dfs(graph, 1-c, neigh, colours);
            }
        }
        return;
    }

}