class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int[] psa = new int[n];
        int[] ssa = new int[n];
        psa[0] = nums[0]; ssa[n-1] = 0;
        for(int i = 1;i<n;i++){
            int edIdx = n-i-1;
            psa[i] = psa[i-1]+nums[i];
            ssa[edIdx] = ssa[edIdx+1]+nums[edIdx+1];
        }
        int count = 0;
        for(int i = 0;i<n-1;i++){
            int diff = psa[i] - ssa[i];
            if(diff %2 == 0)count++;
        }
        return count;
    }
}