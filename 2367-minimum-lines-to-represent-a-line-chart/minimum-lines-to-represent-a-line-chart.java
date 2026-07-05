class Solution {
    public int minimumLines(int[][] sP) {
        int n = sP.length;
        if(n <= 1) return 0;
        Arrays.sort(sP, (a,b) -> Integer.compare(a[0],b[0]));
        int totalLines = 1;
        for(int i = 2; i < n; i++){
            int x1 = sP[i-1][0] - sP[i][0];
            int y1 = sP[i-1][1] - sP[i][1];
            int x2 = sP[i-2][0] - sP[i-1][0];
            int y2 = sP[i-2][1] - sP[i-1][1];
            if( x1 * y2 != y1 * x2) totalLines++;
        }
        return totalLines;
    }
}