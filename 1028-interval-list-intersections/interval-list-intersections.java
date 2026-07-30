class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0, fLen = firstList.length, sLen = secondList.length;
        List<int[]> ls = new ArrayList<>();
        while(i< fLen && j < sLen){
            int[] l1 = firstList[i];
            int[] l2 = secondList[j];
            int st1 = l1[0], ed1 = l1[1], st2 = l2[0], ed2 = l2[1];
            int maxSt = Math.max(st1, st2), minEd = Math.min(ed1, ed2);
            if(maxSt <= minEd){
                ls.add(new int[]{maxSt, minEd});
            }
            if(ed1 <= ed2) i++;
            else j++;
        }
        int[][] ans = new int[ls.size()][];
        for(int k = 0;k<ls.size();k++){
            ans[k] = ls.get(k);
        }
        return ans;
    }
}