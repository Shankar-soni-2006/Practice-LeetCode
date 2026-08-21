class Solution {
    public boolean canArrange(int[] arr, int k) {
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:arr){
            int rem = ((i%k)+k)%k;
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        if(map.getOrDefault(0,0)%2!=0) return false;
        for(int j:map.keySet()){
            int count = map.get(j);
            if(j==0) continue;
            else if(2*j==k){
                if(count%2!=0) return false;
            }
            else {
                int comp = map.getOrDefault(k-j,0);
                if(comp!=count) return false;
            }
        }
        return true;
    }
}