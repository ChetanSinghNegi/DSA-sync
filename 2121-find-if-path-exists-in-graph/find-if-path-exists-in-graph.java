class Solution {
    private class Graph{
        ArrayList<Integer>[] adjList;

        Graph(int vertices){
            adjList = new ArrayList[vertices];
            for(int i = 0; i<vertices; i++){
                adjList[i] = new ArrayList<>();
            }
        }
        public void addEdge(int src, int des){
            adjList[src].add(des);
            adjList[des].add(src);
        }

        public boolean dfs(int src, int des, boolean[] vis){
            if(src == des) return true;
            if(vis[src] == true) return false;
            vis[src] = true;
            for(int vertice: adjList[src]){
                boolean isFound = dfs(vertice, des, vis);
                if(isFound) return true;
            }
            return false;
        }
        public boolean bfs(int src, int des, boolean[] vis){
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(src);
            while(queue.size()>0){
                int top = queue.remove();
                if(top == des) return true;
                if(vis[top] == true) continue;
                vis[top] = true;
                for(int vertice: adjList[top]){
                    if(vis[vertice] == false) queue.add(vertice);
                }
            }
            return false;
        }
    }


    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Graph graph = new Graph(n);
        for(int[] edge: edges){
            graph.addEdge(edge[0],edge[1]);
        }
        boolean[] vis = new boolean[n];
        boolean isFound = graph.dfs(source, destination, vis);
        // boolean isFound = graph.bfs(source, destination, vis);
        return isFound;
    }
}