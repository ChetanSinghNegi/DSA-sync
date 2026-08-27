class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> freqHm = new HashMap<>();
        int st = 0, maxCnt = 0;
        for(int i = 0; i < fruits.length; i++){
            int fruit = fruits[i];
            freqHm.put(fruit, freqHm.getOrDefault(fruit,0)+1);
            while(freqHm.size() > 2){
                int stFruit = fruits[st];
                int stFruitFreq = freqHm.get(stFruit) - 1;
                if(stFruitFreq == 0) freqHm.remove(stFruit);
                else freqHm.put(stFruit, stFruitFreq);
                st++;
            }
            maxCnt = Math.max(maxCnt, i - st + 1 );
        }
        return maxCnt;
    }
}