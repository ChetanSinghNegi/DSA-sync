class Solution {
    public boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return true;
        return false;
    }
    public int maxVowels(String s, int k) {
        int currCnt = 0, maxCnt = 0;
        for(int i = 0;i<k;i++){
            char ch = s.charAt(i);
            if(isVowel(ch)==true){
                currCnt++;
            }
        }
        maxCnt = currCnt;
        for(int i = k; i<s.length(); i++){
            char prevCh = s.charAt(i-k);
            char currCh = s.charAt(i);
            if(isVowel(prevCh)==true) currCnt--;
            if(isVowel(currCh) == true) currCnt++;
            maxCnt = Math.max(currCnt, maxCnt);
        }
        return maxCnt;
    }
}