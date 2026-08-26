class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int st = 0, maxCnt = 0, currCnt = 0, currCost = 0;
        for(int i = 0; i<s.length(); i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            int cost = Math.abs(ch1-ch2);
            currCost += cost;
            currCnt++;
            while(st < s.length() && currCost > maxCost){
                currCost -= Math.abs(s.charAt(st)-t.charAt(st));
                st++;
                currCnt--;
            }
            maxCnt = Math.max(maxCnt, currCnt);
        }
        return maxCnt;
    }
}