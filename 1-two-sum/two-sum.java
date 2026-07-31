class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> freq = new HashMap<>(); // num, freq
        for(int i = 0;i<n;i++){
            int num = nums[i];
            int updatedFreq = freq.getOrDefault(num, 0)+1;
            freq.put(num, updatedFreq);
        }
        for(int i = 0;i<n;i++){
            int n1 = nums[i];
            int diff = target - n1;
            if(freq.containsKey(diff) == true){
                if((diff == n1 && freq.get(diff) > 1) || diff != n1){
                    for(int j = i+1;j<n;j++){
                        if( nums[j] == diff) return new int[]{i,j};
                    }
                }
            }
        }
        return new int[2];
    }
}