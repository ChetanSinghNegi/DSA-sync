class Solution {
    public int longestBeautifulSubstring(String word) {
        int maxCnt = 0, cnt = 0, i = 0, n = word.length(), uniqueVowel = 0;
        while(i < n){
            cnt++; i++; uniqueVowel++; 
            while(i < n && i - 1 >= 0 && word.charAt(i) >= word.charAt(i-1) ){
                char currCh = word.charAt(i);
                if(currCh != word.charAt(i-1)) uniqueVowel++;
                i++;
                cnt++;
            }
            if(uniqueVowel == 5) maxCnt = Math.max(maxCnt, cnt);
            cnt = 0; uniqueVowel = 0;
        }
        return maxCnt;
    }
}