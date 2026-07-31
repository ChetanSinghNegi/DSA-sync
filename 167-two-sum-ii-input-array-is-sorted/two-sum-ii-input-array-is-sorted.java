class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, n = numbers.length, j=n-1;
        while(i<j){
            int currSum = numbers[i] + numbers[j];
            if(currSum == target) break;
            else if( currSum > target ) j--;
            else i++;
        }
        return new int[]{i+1,j+1};
    }
}