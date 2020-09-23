import java.util.Stack;

class CQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public CQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void appendTail(int value) {
        s1.push(value);
    }

    
    public int deleteHead() {
        if(s2.isEmpty()){
            while(!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        return s2.empty() ? -1 : s2.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */