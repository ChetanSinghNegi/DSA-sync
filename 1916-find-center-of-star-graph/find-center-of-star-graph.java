class Solution {
    public int findCenter(int[][] edges) {
        int n1 = edges[0][0];
        int n2 = edges[0][1];
        int n3 = edges[1][0];
        int n4 = edges[1][1];
        int center = n1 == n3 ? n1 : n1 == n4 ? n1 : n2;
        return center;
    }
}