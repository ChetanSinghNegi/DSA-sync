class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ls = new ArrayList<>();
        boolean isAdded = false;
        int i = 0, n = intervals.length;

        if(intervals.length == 0) {
            int[][] ans = new int[1][];
            ans[0] = newInterval;
            return ans;
        }

        if(intervals[0][0] <= newInterval[0]) {
            i = 1;
            ls.add(new int[]{intervals[0][0], intervals[0][1]});
        }else{
            isAdded = true;
            ls.add(new int[]{newInterval[0], newInterval[1]});
        }

        while(i < n){
            int[] interval = intervals[i];
            int[] prev = ls.get(ls.size()-1);
            if(isAdded){
                if(prev[1] >= interval[0]){
                    prev[1] = Math.max(prev[1],interval[1]);
                }else{
                    ls.add(interval);
                }
                i++;
            }else{
                if(interval[0] <= newInterval[0]){
                    if(interval[0] <= prev[1]){
                        prev[1] = Math.max(interval[1],prev[1]);
                    }else{
                        ls.add(interval);
                    }
                    i++;
                }else{
                    if(newInterval[0] <= prev[1]){
                        prev[1] = Math.max(newInterval[1],prev[1]);
                    }else{
                        ls.add(new int[]{newInterval[0],newInterval[1]});
                    }
                    isAdded = true;
                }
            }
        }
        int lsLen = ls.size();
        if(!isAdded){
            if(ls.size() != 0 && newInterval[0] <= ls.get(lsLen-1)[1]){
                ls.get(lsLen - 1)[1] = Math.max(newInterval[1],ls.get(lsLen - 1)[1]);
            }else{
                ls.add(new int[]{newInterval[0],newInterval[1]});
                lsLen++;
            }
        }
        int[][] ans = new int[lsLen][];
        for(int j = 0;j<lsLen;j++){
            ans[j] = ls.get(j);
        }
        return ans;
    }
}