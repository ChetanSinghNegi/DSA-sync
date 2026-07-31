class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int st = 0;
        for(int i = 1;i<n;i++){
            int ele = nums[i];
            int uniqueEle = nums[st];
            if(ele!=uniqueEle){
                nums[st+1] = ele;
                st++;
            }
        }
        return st+1;
    }
}