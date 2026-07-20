class Solution {
    class Pair{
        int st;
        double t;
        Pair(int st, double t){
            this.st = st;
            this.t = t;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        List<Pair> ls = new ArrayList<>();
        for(int i = 0;i<n; i++){
            double dis = target - position[i];
            double t = (double)(dis / speed[i]);
            ls.add(new Pair(position[i], t));
        }
        Collections.sort(ls, (a,b)->{
            if(a.st != b.st) return Double.compare(a.st, b.st) ;
            return Double.compare(a.t, b.t);
        });
        
        int fleets = 0;
        double maxTime = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (ls.get(i).t > maxTime) {
                fleets++;
                maxTime = ls.get(i).t;
            }
        }

        return fleets;
    }
}