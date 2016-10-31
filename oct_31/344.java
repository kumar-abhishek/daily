/*
344. Reverse String   QuestionEditorial Solution  My Submissions
Write a function that takes a string as input and returns the string reversed.
*/
//accepted
public class Solution {
    public String reverseString(String s) {
        char[] str = s.toCharArray();
        int n = s.length();
        int lo=0, hi = n-1;
        while(lo<hi){
            char temp = str[lo];
            str[lo] = str[hi];
            str[hi] = temp;
            ++lo;
            --hi;
        }
        return new String(str);
    }
}

