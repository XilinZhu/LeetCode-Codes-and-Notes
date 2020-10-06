public class Add {
    public int add(int a, int b) {
        class Solution {
            public int add(int a, int b) {
                while(b != 0){
                    int c = (a & b) << 1;
                    a ^=  b;
                    b = c;
                }
                return a;
            }
        }
    }

    public static void main(String[] args) {
        Add s = new Add();
        s.add(7, 555);
    }
}
