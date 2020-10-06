import java.util.PriorityQueue;

class MedianFinder {
    /** initialize your data structure here. */
    PriorityQueue<Integer> large;
    PriorityQueue<Integer> small;
    double mid;

    public MedianFinder() {
        large = new PriorityQueue<>();
        small = new PriorityQueue<>((x,y) -> (y-x));
    }
    
    public void addNum(int num) {
        if(large.size() == small.size()){
            large.add(num);
            small.add(large.remove());
        }else{
            small.add(num);
            large.add(small.remove());
        }
    }
    
    public double findMedian() {
        return (small.size() > large.size()) ? small.element() : (small.element() + large.element())/2;
    }

    public static void main(String[] args) {
        MedianFinder s = new MedianFinder();
        s.addNum(1);
        s.addNum(2);
        s.findMedian();
        s.addNum(3);
        s.findMedian();
    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */