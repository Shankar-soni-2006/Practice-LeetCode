class MyCalendar {
    private List<int[]> ans;
    public MyCalendar() {
        this.ans = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        for(int[] x : ans){
            if(startTime < x[1] && endTime > x[0]) return false;
        }
        ans.add(new int[]{startTime,endTime});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */