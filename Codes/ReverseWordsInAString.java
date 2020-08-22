public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] strs= s.trim().split(" ");
        StringBuilder sentence = new StringBuilder();
        
        for( int i = strs.length; i >=0; i++){
            if (strs[i] != " "){
                sentence.append(strs[i]);
                sentence.append(' ');
            }
        }
        
        
        String ans = new String(sentence);
        return ans.trim();
        
    }

    public static void main(String[] args) {
        ReverseWordsInAString solution = new ReverseWordsInAString();
        String s = "the sky is blue";

        solution.reverseWords(s);
    }
}