class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int st = Math.max(0, k - nums2.length);
        int ed = Math.min(k, nums1.length);
        int[] maxAns = new int[k];
        for(int i = st;i<= ed; i++){
            int[] a = getSubsequence(i, nums1);
            int[] b = getSubsequence(k-i, nums2);
            int[] mergedAB = mergeABFunc(a,b);
            if(isGreater(mergedAB, 0, maxAns, 0) == true){
                maxAns = mergedAB;
            }
        }
        return maxAns;
    }
    public int[] getSubsequence(int sz, int[] nums){
        int[] ans = new int[sz];
        int topIdx = -1, maxRemoveCnt = nums.length - sz;
        for(int num: nums){
            while(topIdx >= 0 && ans[topIdx] < num && maxRemoveCnt > 0){
                topIdx--; maxRemoveCnt--;
            }
            if(topIdx + 1 < sz){
                ans[++topIdx] = num;
            }else maxRemoveCnt--;
        }
        return ans;
    }
    public int[] mergeABFunc(int[] a, int[] b){

        int[] ans = new int[a.length + b.length];
        int i = 0, j = 0, idx = 0;
        while (i < a.length || j < b.length) {
            if (isGreater(a, i, b, j)) {
                ans[idx++] = a[i++];
            } else {
                ans[idx++] = b[j++];
            }
        }
        return ans;
    }
    private boolean isGreater(int[] a, int i, int[] b, int j){
        while(i< a.length && j < b.length && a[i] == b[j]){
            i++; j++;
        }
        return j == b.length || (i < a.length && a[i] > b[j]);
    }
}