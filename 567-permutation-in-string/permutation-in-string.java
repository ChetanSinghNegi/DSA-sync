class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        HashMap<Character, Integer> hm1 = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();
        int n1 = s1.length();
        int n2 = s2.length();
        for(int i = 0;i<n1;i++){
            char ch = s1.charAt(i);
            hm1.put(ch,hm1.getOrDefault(ch,0)+1);
        }
        for(int i = 0;i<n1;i++){
            char ch = s2.charAt(i);
            hm2.put(ch,hm2.getOrDefault(ch,0)+1);
        }
        if(hm1.equals(hm2)) return true;
        for(int i = n1;i<n2;i++){
            char ch1 = s2.charAt(i-n1);
            if(hm2.get(ch1)==1) hm2.remove(ch1);
            else hm2.put(ch1, hm2.get(ch1)-1);
            char ch2 = s2.charAt(i);
            hm2.put(ch2,hm2.getOrDefault(ch2,0)+1);
            if(hm1.equals(hm2)) return true;
        }
        return false;
    }
}