class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        HashSet<Integer> hs = new HashSet<>();
        for(List<Integer> edge: edges){
            hs.add(edge.get(1));
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(hs.contains(i) == false) ans.add(i);
        }
        return ans;
    }
}