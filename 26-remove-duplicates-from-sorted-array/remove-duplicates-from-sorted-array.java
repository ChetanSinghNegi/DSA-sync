class Solution {
    public int removeDuplicates(int[] nums) {
        int idx1 = 1, prev = nums[0], count = 1; 
        for(int idx2 = 1;idx2<nums.length;idx2++){
            int curr = nums[idx2];
            if(curr != prev){
                prev = curr;
                nums[idx2] = nums[idx1];
                nums[idx1] = curr;
                idx1++;
                count++;
            }
        }
        return count;
    }
}