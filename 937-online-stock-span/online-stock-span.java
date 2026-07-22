class StockSpanner {
    private Stack<int[]> st;
    private int days;
    public StockSpanner() {
        this.st = new Stack<>();
        this.days = 0;
    }
    
    public int next(int price) {
        days++;
        while(!st.isEmpty() && st.peek()[0] <= price) st.pop();
        int last = 0;
        if(!st.isEmpty()) last = st.peek()[1];
        st.push(new int[]{price,days});
        return days-last;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */