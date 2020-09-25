import java.util.LinkedHashSet;
import java.util.Set;

public class Permutation {
    public String[] permutation(String s) {
        int len = s.length();
        char[] cs = s.toCharArray();
        Set<String> combines = new LinkedHashSet<>();
        StringBuilder combine = new StringBuilder();
        int ind = 0;
        dfs(cs, combines, combine, ind);

        String[] ans = new String[combines.size()];
        int count = 0;
        for(String s1 : combines){
            ans[count++] = s1;
        }
        return ans;
    }

    private void dfs(char[] cs, Set<String> combines, StringBuilder combine, int ind){
        if (ind == cs.length){
            combines.add(combine.toString());
            return;
        }
        
        //不交换
        combine.append(cs[ind]);
        dfs(cs, combines, combine, ind+1);
        combine.deleteCharAt(ind);

        //交换
        for(int i = ind+1; i < cs.length; i++){
            swap(cs, i, ind);
            dfs(cs, combines, combine, ind);
            swap(cs, i, ind);
        }
        
    }

    private void swap(char[] cs, int i, int j){
        char tmp = cs[i];
        cs[i] = cs[j];
        cs[j] = tmp;
    }

    public static void main(String[] args) {
        Permutation t = new Permutation();
        String s = "abc";
        t.permutation(s);
    }
}
