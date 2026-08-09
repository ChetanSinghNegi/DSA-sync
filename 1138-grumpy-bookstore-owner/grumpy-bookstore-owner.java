class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sum = 0, currSum = 0, maxSum = 0, n = customers.length;
        for(int i = 0; i< n;i++){
            if(grumpy[i] == 0){
                sum += customers[i];
                customers[i] = 0;
            }
        }
        for(int i = 0;i<minutes;i++){
            currSum += customers[i];
        }
        maxSum = currSum;
        for(int i = minutes; i < n;i++){
            currSum = currSum - customers[i-minutes];
            currSum = currSum + customers[i]; 
            maxSum = Math.max(currSum, maxSum);
        }
        return sum + maxSum;
    }
}