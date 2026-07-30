class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0, fLen = firstList.length, sLen = secondList.length;
        List<int[]> ls = new ArrayList<>();
        while(i< fLen && j < sLen){
            int[] l1 = firstList[i];
            int[] l2 = secondList[j];
            int st1 = l1[0], ed1 = l1[1], st2 = l2[0], ed2 = l2[1];
            if(st1 <= st2 && ed1 >= st2){
                int ansEd = Math.min(ed1, ed2);
                int[] currAns = new int[]{st2, ansEd};
                ls.add(currAns);
            }else if(st2 <= st1 && ed2 >= st1){
                int ansEd = Math.min(ed1, ed2);
                int[] currAns = new int[]{st1, ansEd};
                ls.add(currAns);
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