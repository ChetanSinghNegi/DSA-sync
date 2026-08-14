class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        long maxSum = 0, currSum = 0;
        for(int i = 0;i<k;i++){
            int num = nums[i];
            currSum += num;
            freq.put(num, freq.getOrDefault(num,0)+1);
        }
        if(freq.size() == k) maxSum = currSum;
        for(int i = k;i<nums.length;i++){
            int prevFreq = freq.get(nums[i-k])-1;
            if(prevFreq == 0) freq.remove(nums[i-k]);
            else freq.put(nums[i-k],prevFreq);
            int curr = freq.getOrDefault(nums[i],0)+1;
            freq.put(nums[i], curr);
            currSum = currSum - nums[i-k] + nums[i];
            if(freq.size() == k) maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}