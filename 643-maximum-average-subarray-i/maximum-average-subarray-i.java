class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0, maxAvg = Integer.MIN_VALUE;
        for(int i = 0;i<k;i++){
            sum+=nums[i];
        }
        maxAvg = Math.max(maxAvg, sum/k);
        for(int i = k;i<nums.length;i++){
            sum = (sum - nums[i-k] + nums[i]) ;
            maxAvg = Math.max(maxAvg, sum/k);
        }
        return maxAvg;
    }
}