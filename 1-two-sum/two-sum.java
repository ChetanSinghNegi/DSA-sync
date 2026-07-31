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
        // HashMap<Integer, Integer> hm = new HashMap<>(); // <num, freq>
        // for(int i = 0;i<nums.length;i++){
        //     hm.put(nums[i], hm.getOrDefault(nums[i],0)+1);
        // }
        // for(int i = 0;i<nums.length;i++){
        //     int num = nums[i];
        //     int diff = target - num;
        //     int freq = hm.getOrDefault(diff, 0);
        //     if(freq != 0){
        //         if(num == diff && freq > 1) return 
        //     }
        // }
    }
}