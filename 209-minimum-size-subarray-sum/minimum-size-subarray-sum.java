class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int currSum = 0, minCnt = Integer.MAX_VALUE, stIdx = 0;
        for(int i = 0; i < nums.length; i++){
            currSum += nums[i];
            while(currSum >= target){
                minCnt = Math.min(minCnt, i - stIdx + 1);
                currSum -= nums[stIdx];
                stIdx++;
            }
        }
        return minCnt == Integer.MAX_VALUE ? 0 : minCnt;
    }
}