class MovingAverage {
    private int[] array;
    private int tail = 0, count = 0, windowSum = 0,size;

    public MovingAverage(int size) {
        array = new int[size];
        this.size = size;
    }
    
    public double next(int val) {
        tail = count++ % size;
        
        windowSum = windowSum - array[tail] + val;
        array[tail] = val;   

        int currLen = Math.min(count, size);
        return windowSum * 1.0 / currLen;
    
    }
}