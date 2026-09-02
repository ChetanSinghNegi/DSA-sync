class Solution {
    private class Graph{
        int vertices;
        ArrayList<Integer>[] adjList;

        Graph(int vertices){
            this.vertices = vertices;
            adjList = new ArrayList[vertices];
            for(int i = 0; i<vertices; i++){
                adjList[i] = new ArrayList<>();
            }
        }
        public void addEdge(int src, int des){
            adjList[src].add(des);
            adjList[des].add(src);
        }
    }

    public boolean helper(int src, int des, Graph graph, HashSet<Integer> vis){
        for(Integer vertice: graph.adjList[src]){
            if(vis.contains(vertice)) continue;
            if(vertice == des) return true;
            vis.add(vertice);
            boolean isFound = helper(vertice, des, graph, vis);
            if(isFound) return true;
        }
        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(edges.length == 0) return true;
        Graph graph = new Graph(n);
        for(int[] edge: edges){
            graph.addEdge(edge[0],edge[1]);
        }
        HashSet<Integer> vis = new HashSet<>();
        boolean isFound = helper(source, destination, graph, vis);
        return isFound;
    }
}