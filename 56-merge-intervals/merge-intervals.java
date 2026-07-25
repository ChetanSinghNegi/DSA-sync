class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0] != b[0]) return a[0]-b[0];
            return a[1]-b[1];
        });
        List<int[]> ls = new ArrayList<>();
        ls.add(intervals[0]);
        for(int i = 1;i<intervals.length;i++){
            int[] interval= intervals[i];
            int[] prev = ls.get(ls.size()-1);
            if(interval[0] <= prev[1]){
                prev[1] = Math.max(prev[1], interval[1]);
            }else{
                ls.add(interval);
            }
        }
        int[][] ans = new int[ls.size()][];
        for(int i = 0;i<ans.length;i++){
            ans[i] = ls.get(i);
        }
        return ans;
    }
}