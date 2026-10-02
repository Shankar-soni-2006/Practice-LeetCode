
class Solution {
    public int numTrees(int n) {
        int[] cntTree = new int[n+1];
        for (int i = 0; i <= n; i++) cntTree[i] = 1;
        for (int i = 2; i <= n; i++) {
            int total = 0;
            for (int root = 1; root <= i; root++) {
                total += cntTree[root - 1] * cntTree[i - root];
            }
            cntTree[i] = total;
        }
        return cntTree[n];        
    }
}