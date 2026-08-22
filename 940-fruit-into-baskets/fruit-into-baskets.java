class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int max = 0;
        for (int i = 0; i < fruits.length; i++) {
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
            while (map.size() > 2) {
                int temp = fruits[l];
                map.put(temp, map.get(temp) - 1);    
                if (map.get(temp) == 0) map.remove(temp);    
                l++;
            }
            max = Math.max(max, i - l + 1);
        }
        return max;
    }
}