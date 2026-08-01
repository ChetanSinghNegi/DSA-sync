class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length, st = 0, ed = n-1, i = n-1;
        int[] ans = new int[n];
        while(st <= ed){
            int num1 = Math.abs(nums[st]);
            int num2 = Math.abs(nums[ed]);
            if(num1 >= num2){
                ans[i] = num1 * num1;
                st++;
            }else{
                ans[i] = num2 * num2;
                ed--;
            }
            i--;
        }
        return ans;
    }
}