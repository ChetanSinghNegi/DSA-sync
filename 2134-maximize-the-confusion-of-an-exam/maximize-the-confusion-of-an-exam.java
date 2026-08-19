class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int maxT = getSubstringLen('T', k, answerKey);
        int maxF = getSubstringLen('F', k, answerKey);
        return Math.max(maxT, maxF);
    }
    public int getSubstringLen(char letter, int k, String answerKey){
        int st = 0, maxLen = 0, exceptionCnt = 0;
        for(int i = 0; i < answerKey.length(); i++){
            char currCh = answerKey.charAt(i);
            if(currCh != letter) exceptionCnt++;
            while(exceptionCnt > k){
                char prevCh = answerKey.charAt(st);
                if(prevCh != letter) exceptionCnt--;
                st++;
            }
            maxLen = Math.max(maxLen, i - st+1);
        }
        return maxLen;
    }
}