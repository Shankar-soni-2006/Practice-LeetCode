class Solution {
    public double largestTriangleArea(int[][] p) {
        double area = 0.0;
        int n = p.length;

        for(int i = 0; i < n-2; i++){
            for(int j = i+1; j < n-1; j++){
                for(int k = j+1; k < n; k++){
                    double curr = 0.5 * Math.abs(
                        p[i][0] * (p[j][1] - p[k][1]) +
                        p[j][0] * (p[k][1] - p[i][1]) +
                        p[k][0] * (p[i][1] - p[j][1]) 
                    );
                    area = Math.max(area, curr);    
                }
            }
        }
        return area;
    }
}