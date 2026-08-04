class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, r = 0, n = arr.length, diff = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int currDiff = Math.abs(x - arr[i]);
            if( currDiff < diff ){
                l = i; r = i;
                diff = currDiff;
            }
        }
        for(int i = 1; i < k; i++){
            if(l - 1 >= 0){
                if(r + 1 < n){
                    int leftDiff = x - arr[l-1];
                    int rightDiff = arr[r+1] - x;
                    if(leftDiff <= rightDiff){
                        l--;
                    }else r++;
                }else{
                    l--;
                }
            }else{
                r++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = l;i<=r;i++){
            ans.add(arr[i]);
        }
        return ans;
    }
}