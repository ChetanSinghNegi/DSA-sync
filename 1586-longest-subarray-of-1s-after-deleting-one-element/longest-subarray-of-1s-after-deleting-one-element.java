class Solution {
    public int longestSubarray(int[] nums) {
        int st = 0, cnt0 = 0, idx = 0, max1 = 0;
        while(idx < nums.length){
            int curr = nums[idx];
            if(curr == 0) cnt0++;
            while(cnt0 >= 2){
                if(nums[st] == 0) cnt0--;
                st++;
            }
            int curr1 = idx - st;
            max1 = Math.max(max1, curr1);
            idx++;
        }
        return max1;
    }
}