class Solution {
    public int longestOnes(int[] nums, int k) {
        int cnt0 = 0, stIdx = 0, idx = 0, max1 = 0;
        while(idx < nums.length){
            int curr = nums[idx];
            if(curr == 0) cnt0++;
            while(cnt0 > k){
                if(nums[stIdx] == 0) cnt0--;
                stIdx++;
            }
            max1 = Math.max(max1, idx - stIdx + 1);
            idx++;
        }
        return max1;
    }
}