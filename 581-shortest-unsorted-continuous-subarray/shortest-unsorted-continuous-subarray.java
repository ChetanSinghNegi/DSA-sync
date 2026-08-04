class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length, left = -1, right = -1;
        int minSeen = Integer.MAX_VALUE, maxSeen = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            maxSeen = Math.max(nums[i], maxSeen);
            if(nums[i] < maxSeen){  //means it should be increasing(from left to right) but we seen a rebel element
                right = i;
            }
        }
        if(right == -1) return 0;
        for(int i = n-1; i >= 0; i--){
            minSeen = Math.min(nums[i], minSeen);
            if(nums[i] > minSeen){  //means it should be decreasing(from right to left) but we seen a rebel element
                left = i;
            }
        }
        return right - left + 1;
    }
}