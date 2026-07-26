class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0] != b[0]) return a[0]-b[0];
            return a[1]-b[1];
        });
        // for(int[] interval:intervals){
        //     System.out.print(interval[0]+"-"+interval[1]+ "   ");
        // }
        int prev = intervals[0][1],count = 0;
        for(int i = 1; i < intervals.length; i++){
            int[] curr = intervals[i];
            if(prev > curr[0]) {
                count++;
                prev = Math.min(prev, curr[1]);
            }
            else prev = curr[1];
        }
        return count;
    }
}