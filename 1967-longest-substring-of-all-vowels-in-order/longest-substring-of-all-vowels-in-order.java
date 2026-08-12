class Solution {
    public int longestBeautifulSubstring(String word) {
        HashSet<Character> hs = new HashSet<>();
        int maxCnt = 0, cnt = 0, i = 0, n = word.length();
        while(i < n){
            hs.add(word.charAt(i));
            cnt++;
            i++;
            while(i < n && i - 1 >= 0 && word.charAt(i) >= word.charAt(i-1) ){
                char currCh = word.charAt(i);
                if(hs.contains(currCh) == false) hs.add(currCh);
                i++;
                cnt++;
            }
            if(hs.size() == 5) maxCnt = Math.max(maxCnt, cnt);
            cnt = 0;
            hs = new HashSet<>();
        }
        return maxCnt;
    }
}