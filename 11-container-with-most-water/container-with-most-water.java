class Solution {
    public int maxArea(int[] height) {
        int mostWater = 0;
        int st = 0, ed = height.length - 1;
        while(st < ed){
            int h1 = height[st], h2 = height[ed];
            int minH = Math.min(h1, h2);
            int currMostWater = minH * (ed - st);
            mostWater = Math.max(mostWater, currMostWater);
            if(h1 <= h2) st++;
            else ed--;
        }
        return mostWater;
    }
}