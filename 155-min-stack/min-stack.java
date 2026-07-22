import java.util.Stack;

class MinStack {
    Stack<Integer> st;
    Stack<Integer> minst;

    public MinStack() {
        this.st = new Stack<>();
        this.minst = new Stack<>();
    }
    
    public void push(int value) {
        st.push(value);
        if (minst.isEmpty() || value <= minst.peek())  minst.push(value);  
    }
    
    public void pop() {
        if (st.isEmpty()) return;
        if (st.peek().equals(minst.peek()))  minst.pop();
        st.pop();    
    }
    
    public int top() {
        if (st.isEmpty()) return -1;
        return st.peek();
    }
    
    public int getMin() {
        if (minst.isEmpty()) return -1;
        return minst.peek();
    }
}
