class Solution {
    public void helper(int idx, int n, int k, List<List<Integer>> ans, List<Integer> temp){
        if(temp.size() == k){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = idx; i <= n; i++){
            temp.add(i);
            helper(i+1, n, k, ans, temp);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(1,n,k,ans,temp);
        return ans;
    }
}