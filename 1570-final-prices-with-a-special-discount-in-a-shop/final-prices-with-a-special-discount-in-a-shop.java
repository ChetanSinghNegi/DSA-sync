class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        ans[n-1] = 0;
        Stack<Integer> st = new Stack<>();
        st.push(prices[n-1]);
        for(int i = n-2;i>=0;i--){
            int curr = prices[i];
            while(st.size() > 0 && st.peek() > curr) st.pop();
            ans[i] = st.size() == 0 ? 0 : st.peek();
            st.push(curr);
        }
        for(int i = 0;i<n;i++){
            ans[i] = prices[i] - ans[i];
        }
        return ans;
    }
}