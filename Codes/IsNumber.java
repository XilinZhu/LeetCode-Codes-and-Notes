public class IsNumber {
    int ind;

    public boolean isNumber(String s) {
        if(s.length() == 0) return false;

        int len = s.length();
        ind = 0;

        //头部的零
        while(ind < len && s.charAt(ind) == ' '){
            ind++;
        }
        //第一部分数字
        boolean numeric = scanInt(s);
        //小数
        if(ind < len && s.charAt(ind) == '.'){
            ind++;
            numeric = scanUnsignedInt(s) || numeric;
        }
        //指数计数
        else if( ind < len && (s.charAt(ind) == 'e' || s.charAt(ind) == 'E')){
            ind++;
            numeric = numeric && scanInt(s);
        }
        //尾部的零
        while(ind < len && s.charAt(ind) == ' '){
            ind++;
        }

        return numeric && (ind == len);
        
    }

    private boolean scanInt(String s){
        if(ind >= s.length()) return false;
        if(s.charAt(ind) == '+' || s.charAt(ind) == '-'){
            ind++;
        }
        
        return scanUnsignedInt(s);
    }

    private boolean scanUnsignedInt(String s){
        int before = ind;
        while(ind < s.length() && s.charAt(ind) >= '0' && s.charAt(ind) <= '9'){
            ind++;
        }

        return ind > before; 
    }

    public static void main(String[] args) {
        IsNumber s = new IsNumber();
        String str = "0.8";
        s.isNumber(str);
    }
}