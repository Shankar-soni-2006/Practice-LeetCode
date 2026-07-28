class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Queue<Integer> q = new ArrayDeque<>();
        Arrays.sort(deck);
        int[] ans = new int[deck.length];
        for(int i = 0; i < deck.length; i++) q.add(i);
        
        for(int i = 0; i < deck.length; i++){
            ans[q.poll()] = deck[i];
            if(!q.isEmpty()) q.add(q.poll());
        }
        return ans;
    }
}