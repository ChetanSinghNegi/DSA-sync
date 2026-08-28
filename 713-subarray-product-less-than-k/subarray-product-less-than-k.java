class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int cnt = 0, st = 0;
        long currMul = 1;
        for(int ed = 0; ed < nums.length; ed++){
            currMul *= nums[ed];
            while(st <= ed && currMul >= k){
                currMul /= nums[st];
                st++;
            }
            if(st <= ed) cnt += ed - st + 1;
        }
        return cnt;
    }
}