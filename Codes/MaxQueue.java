import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class MaxQueue {
    Queue<Integer> lis;
    Deque<Integer> max;
    public MaxQueue() {
        lis = new LinkedList<>();
        max = new LinkedList<>();
        max.add(Integer.MIN_VALUE);
    }
    
    public int max_value() {
        return lis.isEmpty() ? -1 : max.getFirst();
    }
    
    public void push_back(int value) {
        lis.add(value);
        if(value > max.getFirst()){
            max = new LinkedList<>();
            max.addFirst(value);
            max.addLast(Integer.MIN_VALUE);
        }else if (value > max.getLast()){
            while(max.size() > 1 || value > max.getLast()){
                max.removeLast();
            }
            max.addLast(value);
        }
        

    }
    
    public int pop_front() {
        if (lis.isEmpty()) return -1;
        if(lis.element() == max.getFirst()){
            max.removeFirst();
        }
        return lis.remove();
    }

    public static void main(String[] args) {
        MaxQueue obj = new MaxQueue();
        obj.max_value();
        obj.pop_front();
        obj.pop_front();
        obj.push_back(94);
        obj.push_back(16);
        obj.push_back(89);
        obj.pop_front();
        obj.push_back(22);
        obj.pop_front();
    }
}


// Your MaxQueue object will be instantiated and called as such:

