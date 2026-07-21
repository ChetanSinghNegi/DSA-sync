class Pair {
    char ch;
    int freq;

    Pair(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}

class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[128];
        for (char ch : s.toCharArray()) {
            freq[ch]++;
        }
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < 128; i++) {
            if (freq[i] > 0) {
                list.add(new Pair((char) i, freq[i]));
            }
        }
        list.sort((a, b) -> b.freq - a.freq);
        StringBuilder sb = new StringBuilder();
        for (Pair p : list) {
            while (p.freq-- > 0) {
                sb.append(p.ch);
            }
        }
        return sb.toString();
    }
}