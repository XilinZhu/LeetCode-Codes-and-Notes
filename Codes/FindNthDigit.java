class FindNthDigit {
    public int findNthDigit(int n) {
        long start = 1;
        int digit = 1;
        long count = 9;

        while( n > count){
            n -= count;
            digit += 1;
            start *= 10;
            count = start * 9 * digit;
        }

        long num = start + (n-1) / digit ;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
