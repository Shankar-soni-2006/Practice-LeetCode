class Solution {
    public void helper(int idx, int sum,int n, List<List<Integer>> ans, List<Integer> temp, int k){
        if(temp.size() == k && sum == n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(sum > n || temp.size() > k) return;
        for(int i = idx; i <= 9; i++){
            temp.add(i);
            helper(i+1, sum+i, n, ans, temp, k);  
            temp.remove(temp.size()-1);   
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(1, 0, n, ans, temp, k);
        return ans;
    }
}