class Solution {
    public int minStartValue(int[] nums) {
        int sum = 0, minValue = Integer.MAX_VALUE;
        for(int num:nums){
            sum += num;
            minValue = Math.min(minValue, sum);
        } 
        if(minValue <= 0){
            return -1 * minValue + 1;
        }
        return 1;
    }
}