class Solution {
    class Graph{
        ArrayList<Integer>[] adjList;
        Graph(int n){
            adjList = new ArrayList[n];
            for(int i = 0; i < n; i++){
                adjList[i] = new ArrayList<>();
            }
        }
        public void addEdge(int src, int dest){
            adjList[src].add(dest);
            adjList[dest].add(src);
        }
    }
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        Graph graph = new Graph(n);
        for(int i = 0; i < edges.length; i++){
            int[] edge = edges[i];
            graph.addEdge(edge[0], edge[1]);
        }
        int[] dis = new int[n];
        Arrays.fill(dis, -1);
        Queue<Integer> queue = new ArrayDeque<>();
        dis[0] = 0;
        queue.add(0);
        while(queue.size() > 0){
            int current = queue.remove();
            for(int neighbour: graph.adjList[current]){
                if(dis[neighbour] == -1){
                     dis[neighbour] = dis[current]+1;
                     queue.add(neighbour);
                }
            }
        }
        int answer = 0;
        for(int i= 1; i < n; i++){
            int roundTrip = 2 * dis[i];
            int lastSend = ((roundTrip - 1)/patience[i]) * patience[i];
            int lastReply = lastSend + roundTrip;
            int idleTime = lastReply + 1;
            answer = Math.max(answer, idleTime);
        }
        return answer;
    }
}