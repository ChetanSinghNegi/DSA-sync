class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp, -1);
        helper(0, dp, cost);
        // for(int i: dp){
        //     System.out.print(i+"  ");
        // }
        return Math.min(dp[0], dp[1]);
    }
    public int helper(int idx, int[] dp, int[] cost){
        if(idx >= cost.length) return 0;
        if(dp[idx] != -1) return dp[idx];
        int currCost = cost[idx];
        int nextStep = helper(idx+1, dp, cost);
        int nextToNextStep = helper(idx+2, dp, cost);
        currCost = currCost + Math.min(nextStep, nextToNextStep);
        dp[idx] = currCost;
        return currCost;
    }
}