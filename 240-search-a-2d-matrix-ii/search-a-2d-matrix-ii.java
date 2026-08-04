class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int mr = matrix.length, mc = matrix[0].length, r = mr-1, c = 0;
        while(r >= 0 && c < mc){
            if(matrix[r][c] == target) return true;
            else if( matrix[r][c] < target) c++;
            else r--;
        }
        return false;
    }
}