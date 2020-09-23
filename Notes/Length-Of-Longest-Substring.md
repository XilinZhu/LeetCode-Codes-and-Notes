# Length Of Longest Substring

## Description

> 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
>
>  
>
> **示例** 1:
>
> 输入: `"abcabcbb"`
> 输出: `3` 
> 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
>
> **示例** 2:
>
> 输入: `"bbbbb"`
> 输出: `1`
> 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
>
> **示例** 3:
>
> 输入: `"pwwkew"`
> 输出: `3`
> 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
>      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
>
> **提示**：
>
> `s.length <= 40000`

## Answer 1: 双指针+HashSet

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int count = 0;
        int ans = 0;
        char[] cs = s.toCharArray();

        for(int i =0; i < cs.length; i++){
            count = 0;
            set.clear();
            for (int j = i; j < cs.length; j++){
                if (set.add(cs[j])){
                    count++;
                }else{
                    ans = Math.max(count, ans);
                    break;
                }
                ans = Math.max(count, ans);
            }
        }

        return ans;
    }
}
```

## Answer 2: 双指针 + `HashMap`加速慢指针更新速度

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = -1;
        int ans = 0;
        char c;

        for(int j =0; j < s.length(); j++){
            c = s.charAt(j);
            if (map.containsKey(c)){
                i = Math.max(i, map.get(c));
            }
            map.put(c, j);
            ans = Math.max(j-i, ans);
        }

        return ans;
    }
}
```

## Note

- 双指针 + `HashMap`加速慢指针更新速度