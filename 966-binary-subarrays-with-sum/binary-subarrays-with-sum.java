class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Long, Integer> hmSum = new HashMap<>();
        hmSum.put(0l,1);
        long currSum = 0;
        int cnt = 0;
        for(int num: nums){
            currSum += num;
            if(hmSum.containsKey(currSum - goal) == true) cnt+= hmSum.get(currSum-goal);
            hmSum.put(currSum, hmSum.getOrDefault(currSum,0)+1);
        }
        return cnt;
    }
}