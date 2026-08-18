class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return countAtMostK(nums,k)-countAtMostK(nums,k-1);
    }

    public static int countAtMostK(int[] nums, int k) {
		int oddCount=0;
        int ansCount=0;
		int left=0;
        int right=0;
		while(right<nums.length){
		    int currRight=nums[right];
            if(currRight%2==1) oddCount++;
            // checking atmost condition  
            while(oddCount>k){
                int currLeft=nums[left];
                if(currLeft%2!=0) oddCount--;
                left++;
            }
            ansCount+=right-left+1;
            right++;
		}
		
		return ansCount;
	}
}