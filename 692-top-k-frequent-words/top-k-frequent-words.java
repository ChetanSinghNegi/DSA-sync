class Solution {
    class Pair{
        String word;
        int freq;
        Pair(String word, int freq){
            this.word = word;
            this.freq = freq;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        int n = words.length;
        HashMap<String, Integer> hm = new HashMap<>(); //<String, Index>
        List<Pair> pairs = new ArrayList<>();
        for(int i = 0;i<n;i++){
            String word = words[i];
            if(hm.containsKey(word)){
                int idx = hm.get(word);
                pairs.get(idx).freq++;
            }else{
                Pair pair = new Pair(word, 1);
                pairs.add(pair);
                hm.put(word, pairs.size()-1);
            }
        }
        Collections.sort(pairs,(a,b)->{
            if(a.freq != b.freq) return b.freq - a.freq;
            return a.word.compareTo(b.word);
        });
        List<String> ans = new ArrayList<>();
        for(int i = 0;i<k;i++){
            ans.add(pairs.get(i).word);
        }
        return ans;
    }
}