import java.util.ArrayList;

class MinStack {
    ArrayList<Integer> st;
    ArrayList<Integer> minSt;

    public MinStack() {
        this.st = new ArrayList<>();
        this.minSt = new ArrayList<>();
    }

    public void push(int value) {
        st.add(value);
        if (minSt.isEmpty() || value <= minSt.get(minSt.size() - 1)) minSt.add(value);
        
    }

    public void pop() {
        if (!st.isEmpty() &&st.get(st.size() - 1).equals(minSt.get(minSt.size() - 1))) minSt.remove(minSt.size() - 1);
        st.remove(st.size() - 1);
    }

    public int top() {
        if (!st.isEmpty()) return st.get(st.size() - 1);
        return -1;  
    }

    public int getMin() {
        if (!minSt.isEmpty())  return minSt.get(minSt.size() - 1);
        return -1;
    }
}
