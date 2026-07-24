class Solution {
    class Pair{
        int num, idx, sum;
        Pair(int num, int idx, int sum){
            this.num = num;
            this.idx = idx;
            this.sum = sum;
        }
    }
    public int getDigitSum(int num){
        int sum = 0;
        while(num != 0){
            int rem = num % 10;
            sum+=rem;
            num/=10;
        }
        return sum;
    }
    public int minSwaps(int[] nums) {
        int n = nums.length, count = 0;
        List<Pair> ls = new ArrayList<>();
        for(int i = 0;i<n;i++){
            int num = nums[i];
            int sum = getDigitSum(num);
            ls.add(new Pair(num, i, sum));
        }
        Collections.sort(ls, (a,b)->{
            if(a.sum != b.sum) return a.sum - b.sum;
            return a.num - b.num;
        });
        for(int i = 0;i<n;i++){
            Pair curr = ls.get(i);
            while(curr.idx != i){
                Pair next = ls.get(curr.idx);
                Pair temp = new Pair(next.num, next.idx, next.sum);
                next.num = curr.num; 
                next.idx = curr.idx;
                next.sum = curr.sum;
                curr.num = temp.num; 
                curr.idx = temp.idx;
                curr.sum = temp.sum;
                count++;
            }
        }
        return count;
    }
}