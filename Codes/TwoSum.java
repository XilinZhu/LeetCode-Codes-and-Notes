public class TwoSum {
    public double[] twoSum(int n) {
        double[] curr = {1.0/6, 1.0/6, 1.0/6, 1.0/6, 1.0/6, 1.0/6}; //初始状态
        double[] prev = curr;  
        

        for(int i = 2; i <= n; i++){
            curr = new double[5*i+1];
            int minValue = n;
            int prevStart = n - 1;
            int prevEnd = 6*(n-1);
            for(int p = 1; p <= 6; p++){
                for(int q = prevStart; q <= prevEnd; q++){
                    curr[p+q-minValue] += 1.0/6*prev[q-prevStart];
                }
            }
            prev = curr;
        }

        return curr;

    }

    public static void main(String[] args) {
        TwoSum s = new TwoSum();
        s.twoSum(3);
    }
}
