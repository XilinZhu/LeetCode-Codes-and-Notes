```java
class Solution {
    // sunday算法
    public int sunday(String haystack, String needle) {
        // 考虑各种边界情况
        
		
        // 主要逻辑
        int m = haystack.length();
        int n = needle.length();
        int i = 0;
        int j = 0;
        while(i + n <= m){
            //常规双指针
            j = 0; 
            while(j < n && haystack.charAt(i + j) == needle.charAt(j)){
                j++;
            }
            if(j == n){
                return i;
            }
            //Sunday的核心思想，总是从当前匹配字符串的后一位（暴力搜索中的下一次终点）向前寻找下一次的起点。最优情况下，总从暴力搜索的下一次终点作为下一次的起点，时间复杂度为不大于O(n)；最糟糕的情况下，时间复杂度为O(m+n)。
            int k = n - 1;
            while(k >= 0 && i + n < m && needle.charAt(k) != haystack.charAt(i+n)){//关键句子
                k--;
            }
            i = k >= 0 ? i + n - k : i + n; //关键句子
        }
        return -1;
    }
}


```

