public class StringToInt {
    public int strToInt(String str) {
        str = str.trim();

        if (str.length() == 0) return 0;
        int curr, first = str.charAt(0), boundary = Integer.MAX_VALUE/10;
        int ans = 0;

        if( first >= '0' && first <= '9' || first == '+' || first == '-'){
            if (first >= '0' && first <= '9'){
                ans = first - '0';
            }
            
            for( int i = 1; i < str.length(); i++){
                curr = str.charAt(i) - '0' ;
                if( curr < 0 || curr > 9) 
                    break;
                if ( ans > boundary || ans == boundary && curr > 7)
                    return (first == '-') ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                ans = ans*10 + curr;
            }
            ans = (first == '-') ? -ans : ans; 
        }
        return ans;             
    }

    public static void main(String[] args) {
        StringToInt s = new StringToInt();
        String str = "2147483647";
        s.strToInt(str);
    }
}