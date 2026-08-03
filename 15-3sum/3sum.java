class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            int target = -1 * nums[i];
            // skip duplicate fixed elements
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int st = i+1, ed = n-1;
            while(st < ed){
                int currSum = nums[st]+nums[ed];
                if(currSum == target){
                    List<Integer> currLs = new ArrayList<>();
                    currLs.add(nums[st]); currLs.add(nums[ed]); currLs.add(nums[i]);
                    ls.add(currLs);
                    st++;
                    ed--;

                    // skip duplicates for left and right
                    while (st < ed && nums[st] == nums[st - 1]) st++;
                    while (st < ed && nums[ed] == nums[ed + 1]) ed--;
                }else if(currSum < target){
                    st++;
                }else ed--;
            }   
        }
        return ls;
    }
}