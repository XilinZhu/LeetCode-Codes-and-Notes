import java.util.LinkedList;
import java.util.List;

public class RestoreIpAddresses {
    List<String> addresses = new LinkedList<>();
    int[] segs = new int[4];
    public List<String> restoreIpAddresses(String s) {
        if(s.length() > 12 || s.length() < 4) return addresses; 
        
        dfs(s.toCharArray(), 0, 0);
        return addresses;
    }

    private int getValidValue(char[] cs, int left, int right){
        if(left == right) return cs[left] - '0';
        if(cs[left] == '0') return -1;
        
        int val = 0;
        for(int i = left; i <= right; i++){
            val = val * 10 + cs[i];
        }
        if(val > 255) return -1;
        return val;
    }

    private void dfs(char[] cs, int left, int segId){
        if(segId == 4){
            if(left == cs.length){
                StringBuilder address = new StringBuilder();
                for(int i = 0; i < 4;i++){
                    address.append(segs[i]);
                }
                addresses.add(address.toString());
            }
            return;
        }
        if(cs.length - left < 4 - segId || cs.length - left > 3 * (4 - segId)) return;

        for(int right = left; right - left < 3; right++){
            int val = getValidValue(cs, left, right);
            if(val != -1){
                segs[segId] = val;
                dfs(cs, right+1, segId+1);
            }
        }
    }

    public static void main(String[] args) {
        RestoreIpAddresses s = new RestoreIpAddresses();
        String str = "25525511135";
        s.restoreIpAddresses(str);
    }
}
