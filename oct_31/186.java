/*
186. Reverse Words in a String II
Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

The input string does not contain leading or trailing spaces and the words are always separated by a single space.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Could you do it in-place without allocating extra space?
*/

//accepted
public class Solution {
        private void reverseString(char[] str, int lo, int hi){
        while(lo<hi){
            char temp = str[lo];
            str[lo] = str[hi];
            str[hi] = temp;
            ++lo;
            --hi;
        }
    }
    
    public String reverseWords(char[] str) {
        if(str.length == 0 || str==null) return new String(str);
        //reverse full string
        reverseString(str, 0, str.length-1);
        
        //reverse word by word
        int i=0, lo=i;
        while(i<str.length) {
            lo = i;
            while(i<str.length && str[i] != ' ') i+=1;
            if(i>=str.length) break;
            reverseString(str, lo, i-1);
            ++i;
        }
        reverseString(str, lo, i-1);
        return new String(str);
    }
}

