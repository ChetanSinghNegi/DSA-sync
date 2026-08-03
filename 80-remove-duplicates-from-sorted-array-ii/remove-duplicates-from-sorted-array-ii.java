class Solution {
    public int removeDuplicates(int[] nums) {
        int idx = 0, i = 0, n = nums.length;
        while(i < n){
            int curr = nums[i++];
            nums[idx++] = curr;
            boolean isDuplicate = false;
            while( i < n && nums[i] == curr){
                i++;
                isDuplicate = true;
            }
            if(isDuplicate == true) {
                nums[idx++] = curr;
            }
        }
        return idx;
    }
}