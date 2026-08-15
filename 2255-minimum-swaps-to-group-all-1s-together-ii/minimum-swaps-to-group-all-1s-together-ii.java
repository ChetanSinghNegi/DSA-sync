class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int windowSize = 0;
        for(int ele:nums){
            if(ele == 1) windowSize++;
        }
        if(windowSize == 0 || windowSize == n) return 0;
        int curr1 = 0;
        for(int i = 0;i<windowSize;i++){
            if(nums[i] == 1) curr1++;
        }
        int max1 = curr1;
        for(int i = windowSize; i < n+windowSize - 1;i++){
            int prevEle = nums[i - windowSize];
            if(prevEle == 1) curr1--;
            int currEle = nums[i % n];
            if(currEle == 1) curr1++;
            if(curr1 > max1) max1 = curr1;
        }
        return windowSize-max1;
    }
}