class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        double currSum = 0;
        int count = 0;
        for(int i = 0;i<k;i++){
            currSum += arr[i];
        }
        if(currSum/k >= threshold) count++;
        for(int i = k;i<arr.length;i++){
            currSum = currSum - arr[i-k] + arr[i];
            if(currSum/k >= threshold) count++;
        }
        return count;
    }
}