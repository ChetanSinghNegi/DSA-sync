class Solution {
    public int[] sortedSquares(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        int n = nums.length, st = 0, ed = n - 1;
        int[] ans = new int[n];
        while(st <= ed){
            int num1 = Math.abs(nums[st]);
            int num2 = Math.abs(nums[ed]);
            if(num1 >= num2){
                ls.add(num1*num1);
                st++;
            }else{
                ls.add(num2*num2);
                ed--;
            }
        }
        for(int i = 0;i<n;i++){
            ans[i] = ls.get(n-i-1);
        }
        return ans;
    }
}