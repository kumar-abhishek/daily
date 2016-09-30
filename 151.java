/*
151. Reverse Words in a String  QuestionEditorial Solution  My Submissions
Total Accepted: 120969
Total Submissions: 766769
Difficulty: Medium
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".
*/

public class Solution {
    public void reverseWord(char[] str, int lo, int hi){
        while(lo < hi){
            char temp = str[lo];
            str[lo] = str[hi];
            str[hi] = temp;
            lo += 1;
            hi -= 1;
        }
    }
    
    public String reverseWords(String s) {
        if(s == null){
            return null;
        }
        int n = s.length();
        if (n == 1){
            return s;
        }
        char[] str = s.toCharArray();
        
        //reverse the whole str
        reverseWord(str, 0, str.length-1);
        
        //reverse word by word
        int start =0, end = 1;
        while(start < n){
            while(start<n && str[start] == ' '){
                start += 1;
            }
            if(start == n){
                break;
            }
            while(end < n && str[end] != ' ' && start < end){
                end += 1;
            }
            end -= 1;
            reverseWord(str, start, end);
            start = end+1;
        }
        return new String(str);
    }
}

