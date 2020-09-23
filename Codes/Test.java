public class Test {
    public int myAtoi(String str) {
        str =  str.trim();
        char c;
        int sign = 1;
        int i = 1;
        int sum = 0;
        c = str.charAt(0);
        if(c >= '0' && c <='9') i =0; 
        else if (c == '-') sign = -1;
        else if (c == '+') sign = 1;
        else return 0;

        for(; i < str.length(); i++){
            c = str.charAt(i);
            if (c < '0' || c >'9') break;
            sum = sum*10 + c-'0';
        }

        return sum * sign;
        
    }
}
