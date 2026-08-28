class Solution {
    public int numSub(String s) {
        int st = -1, cnt = 0, mod = 1000000007;
        for(int ed = 0; ed < s.length(); ed++){
            char currCh = s.charAt(ed);
            if(currCh == '0') st = ed;
            else{
                cnt = (cnt + ed - st) % mod;
            }
        }
        return cnt;
    }
}