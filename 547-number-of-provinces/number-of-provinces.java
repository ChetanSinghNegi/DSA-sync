class Solution {
    class Graph{
        ArrayList<Integer>[] adjList;
        Graph(int n){
            adjList = new ArrayList[n];
            for(int i = 0; i<n;i++){
                adjList[i] = new ArrayList<>();
            }
        }
        public void addEdge(int src, int dest){
            adjList[src].add(dest);
        }
        public void dfs(int src, boolean[] vis){
            if(vis[src] == true) return;
            vis[src] = true;
            for(int vertice: adjList[src]){
                if(vis[vertice] != true) dfs(vertice, vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int cnt = 0, n = isConnected.length;
        Graph graph = new Graph(n);
        for(int i = 0; i < n; i++){
            int[] connection = isConnected[i];
            for(int j = 0; j < n; j++){
                if(i != j && connection[j] == 1) graph.addEdge(i,j);
            }
        }
        boolean vis[] = new boolean[n];
        for(int i = 0; i < n; i++){
            if(vis[i] == false){
                cnt++;
                graph.dfs(i, vis);
            }
        }
        return cnt;
    }
}