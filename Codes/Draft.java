public class Draft {
    public static void main(String[] args) {
        int i = 3, j;
        outer: while(i > 0){
            j = 3;
            inner: while(j > 0){
                if(j < 2) break outer;
                System.out.println(j + " and " + i);
                j--;
            }
            i--;
        }
        Draft.test();
    }
    public static void test() {  
        String s = "a";  
        for(int i = 0; i < 100000; i++) {  
            s += "a";  
        }  
        /****************toCharArray遍历*************/  
        long start1 = System.currentTimeMillis();  
        char[] arr = s.toCharArray();  
        for (int i = 0; i < arr.length; i++) {
             char c = arr[i];
             System.out.println(c);
        }
        long end1 = System.currentTimeMillis();  
        /****************charAt遍历******************/    
        long start2 = System.currentTimeMillis();  
        for(int i = 0; i < s.length(); i++) {  
            char c = s.charAt(i);  
            System.out.println(c);  
        }  
        long end2 = System.currentTimeMillis();  
          
        System.out.println(end1 - start1);  //503
        System.out.println(end2 - start2);  //453
    }
}