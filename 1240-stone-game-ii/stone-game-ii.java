class Solution {
    public int dfs(int i, int m, int n, int[] suff, int[][] freq){
        if(m*2 >= n-i) return suff[n] - suff[i];
        if(freq[i][m] != 0) return freq[i][m];
        int ans = 0;
        for(int j = 1; j <= m*2; j++){
            ans = Math.max(ans,suff[n]-suff[i] - dfs(i+j,Math.max(m,j),n,suff,freq));
        }
        return freq[i][m] = ans;
    }

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suff = new int[n + 1];
        int[][] freq = new int[n][n + 1];
        for (int i = 0; i < n; i++)
            suff[i + 1] = suff[i] + piles[i];
        return dfs(0, 1, n, suff, freq);
    }
}
