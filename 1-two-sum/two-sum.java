class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] nums2 = nums.clone();
        Arrays.sort(nums2);
        int i = 0, n = nums.length, j = n-1;
        while(i<j){
            int sum = nums2[i] + nums2[j];
            if(sum == target) break;
            else if(sum < target) i++;
            else j--;
        } 
        int n1 = nums2[i], n2 = nums2[j];
        for(int k = 0;k<n;k++){
            if(nums[k] == n1) {
                i = k;
                break;
            }
        }
        for(int k = n-1;k>=0;k--){
            if(nums[k] == n2) {
                j=k;break;
            }
        }

        return new int[]{i,j};
    }
}