class Solution {
    public int countGoodSubstrings(String s) {
        int maxSz = 3, count = 0;
        if(s.length() < maxSz) return count;
        HashMap<Character, Integer> freq = new HashMap<>();
        for(int i = 0;i< maxSz; i++){
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(ch,0) + 1);
        }
        if(freq.size() == maxSz) count++;
        for(int i = maxSz; i<s.length();i++){
            char prevChar = s.charAt(i-maxSz);
            char currChar = s.charAt(i);
            int prevFreq = freq.get(prevChar)- 1;
            if(prevFreq == 0) freq.remove(prevChar);
            else freq.put(prevChar, prevFreq);
            freq.put(currChar, freq.getOrDefault(currChar, 0)+1);
            if(freq.size() == maxSz) count++;
        }
        return count;
    }
}