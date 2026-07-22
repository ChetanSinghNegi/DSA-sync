class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->{
            if(a[1] != b[1]) return a[1]-b[1];
            return a[0]-b[0];
        });
        int prevEnd = pairs[0][1], count = 1;
        for(int i = 1;i<pairs.length;i++){
            int[] curr = pairs[i];
            if(curr[0] > prevEnd){
                count++;
                prevEnd = curr[1];
            }
        };
        return count;
    }
}