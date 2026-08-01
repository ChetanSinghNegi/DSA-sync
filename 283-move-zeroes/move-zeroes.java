class Solution {
    public void moveZeroes(int[] nums) {
        int st0 = 0;
        for(int i = 0;i<nums.length;i++){
            int ele1 = nums[i];
            if(nums[i] != 0){
                nums[i] = nums[st0];
                nums[st0] = ele1;
                st0++;
            }
        }
    }
}