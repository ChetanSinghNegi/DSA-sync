class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<String, Integer> freqHm = new HashMap<>();
        HashMap<Character, Integer> charFreqHm = new HashMap<>();
        for(int i = 0;i<minSize;i++){
            char ch = s.charAt(i);
            charFreqHm.put(ch, charFreqHm.getOrDefault(ch,0)+1);
        }
        if(charFreqHm.size() <= maxLetters){
            freqHm.put(s.substring(0, minSize),1);
        }
        for(int i = minSize;i<s.length();i++){
            char ch = s.charAt(i);
            char prevCh = s.charAt(i-minSize);
            int freq = charFreqHm.get(prevCh)-1;
            if(freq == 0){
                charFreqHm.remove(prevCh);
            }else{
                charFreqHm.put(prevCh, freq);
            }
            charFreqHm.put(ch, charFreqHm.getOrDefault(ch,0)+1);
            if(charFreqHm.size() <= maxLetters){
                String str = s.substring(i-minSize+1, i+1);
                freqHm.put(str, freqHm.getOrDefault(str,0)+1);
            }
        }
        int maxRepeat = 0;
        // System.out.println(freqHm);
        for(String str: freqHm.keySet()){
            maxRepeat = Math.max(maxRepeat, freqHm.get(str));
        }
        return maxRepeat;
    }
}