class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        int st = 0, currSum = 0, maxSum = 0;
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            while(hs.contains(num) == true){
                int prev = nums[st];
                hs.remove(prev);
                st++;
                currSum = currSum - prev;
            }
            hs.add(num);
            currSum += num;
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}