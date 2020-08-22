# O-58. Reverse-Words-In-A-String

## Information

- DATE: 2020.08.21
- LINK: [剑指 offer 58](https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/)
- TAG: `string`

## Description

> 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
>
> **示例** 1：
>
> **输入**: `"the sky is blue"`
> **输出**: `"blue is sky the"`
>
> **示例** 2：
>
> **输入**: `"  hello world!  "`
> **输出**: `"world! hello"`
> **解释**: *输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。*
>
> **示例** 3：
>
> **输入**: `"a good   example"`
> **输出**: `"example good a"`
> **解释**: *如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。*

## My Answer

```java
class Solution {
    public String reverseWords(String s) {
        StringBuilder word = new StringBuilder();
        StringBuilder sentence = new StringBuilder();

        for ( int i = 0; i < s.length(); i++){
            char letter = s.charAt(i);
            if (letter == ' '){
                if (word.length() == 0) 
                    continue;
                word.append(' ');
                sentence.insert(0, word);
                word.delete(0, word.length());
            }
            else{
                word.append(letter);
            } 
        }
        
        if(word.length() != 0){
            word.append(' ');
            sentence.insert(0, word);
        }
            
        if(sentence.length() == 0) 
            return "";
        sentence.delete(sentence.length() - 1, sentence.length());
        String ans = new String(sentence);
        return ans;
    }
}
```

## My Better Answer

- 减少一个 `StringBuilder` 的使用，使用索引范围替代实际内容。

```java
class Solution {
    public String reverseWords(String s) {
        StringBuilder sentence = new StringBuilder();
        int start = 0,end = 0;
        int len = s.length();

        while( end < len ){
            if ( s.charAt(end) == ' ')
                end++;
            else{
                start = end;
                while( end < len ){
                    if ( s.charAt(end) != ' ')
                        end++;
                    else{
                        sentence.insert(0, s, start, end);
                        sentence.insert(0, ' ');
                        break;
                    }
                }
            }
        }
        if (end == 0) return "";

        if(s.charAt(end - 1) != ' '){
            sentence.insert(0, s, start, end);
            sentence.insert(0, ' ');
        }
        

        sentence.delete(0, 1);
        String ans = new String(sentence);
        return ans;
        
    }
}
```

- 时间复杂度：访问输入字符串元素复杂度为$O(N)$，向输出字符串中插入元素的时间复杂度为$O(N)$，总复杂度为$O(N)$
- 空间复杂度：$O(N)$

## Better Answer

- 使用 `String.trim()` 来完成头尾 0 的去除
- 倒序访问原字符串，好处是可以正序地向输出中插入字符串

```java
class Solution {
    public String reverseWords(String s) {
        s= s.trim();
        StringBuilder sentence = new StringBuilder();
        int start = s.length() - 1 ,end = s.length();

        while( start >= 0 ){
            while ( start >= 0 && s.charAt(start) != ' ')
                start--;
            
            sentence.append(s, start + 1, end);
            sentence.append(' ');

            while ( start >= 0 && s.charAt(start) == ' ')
                start--;
            end = start + 1;
        }
        
        String ans = new String(sentence);
        return ans.trim();
    }
}
```

## Faster Answer

- 使用 `String.split()` 来实现分割，达到了更快的速度.

```java
class Solution {
    public String reverseWords(String s) {
        StringBuilder sentence = new StringBuilder();
        String[] strs= s.trim().split(" ");
             
        for( int i = strs.length - 1; i >=0; i--){
            if (!strs[i].equals("")){
                sentence.append(strs[i]);
                sentence.append(' ');
            }
        }
             
        String ans = new String(sentence);
        return ans.trim();
        
    }
}
```

## Notes

- 内置方法达到了更快的速度（如 `String.trim()` `String.split()`），体现了“不要自己造轮子”的正确性，但面试中应避免在核心算法处使用内置方法。