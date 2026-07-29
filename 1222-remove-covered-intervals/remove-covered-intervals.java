class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0] != b[0]) return a[0]-b[0];
            return b[1]-a[1];
        });
        int prev = intervals[0][1], count = 1;
        for(int i = 1;i<intervals.length;i++){
            int[] curr = intervals[i];
            if(curr[0] <= prev && curr[1] <= prev ){
                continue;
            }else{
                prev = curr[1];
                count++;
            }
        }
        return count;
    }
}