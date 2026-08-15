class Solution {
    public class Pair{
        int start;
        int end;
        Pair(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    public int[][] intervalIntersection(int[][] first, int[][] second) {
        List<Pair> l = new ArrayList<>();
        int i = 0, j = 0;
        while(i < first.length && j < second.length){
            int st = Math.max(first[i][0], second[j][0]);
            int ed = Math.min(first[i][1], second[j][1]);
            if(st <= ed) l.add(new Pair(st,ed));
            if(first[i][1] < second[j][1]) i++;
            else j++;
        }

        int[][] res = new int[l.size()][2];
        for(int k = 0; k < l.size(); k++){
            res[k][0] = l.get(k).start;
            res[k][1] = l.get(k).end;
        }
        return res;
    }
}