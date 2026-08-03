class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(i > 0 && nums[i] == nums[i-1] ) continue;
            threeSum(i+1, nums[i], (long)target, nums, ls);
        }
        return ls;
    }
    
    public List<List<Integer>> threeSum(int prevSt, int ele1, long target, int[] nums, List<List<Integer>> ls) {
        int n = nums.length;
        long targetThree = target - ele1;
        for(int i = prevSt;i<nums.length;i++){
            if(i > prevSt && nums[i] == nums[i-1] ) continue;
            long targetTwo = targetThree - nums[i];
            int st = i+1, ed = n-1;
            while(st < ed){
                long currSum = nums[st]+nums[ed];
                if(currSum == targetTwo){
                    List<Integer> currLs = new ArrayList<>();
                    currLs.add(ele1); currLs.add(nums[st]); currLs.add(nums[ed]); currLs.add(nums[i]);
                    ls.add(currLs);
                    st++;
                    ed--;

                    // skip duplicates for left and right
                    while (st < ed && nums[st] == nums[st - 1]) st++;
                    while (st < ed && nums[ed] == nums[ed + 1]) ed--;
                }else if(currSum < targetTwo){
                    st++;
                }else ed--;
            }   
        }
        return ls;
    }
}