/*
345. Reverse Vowels of a String
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".
*/

//accepted
public class Solution {
    public String reverseVowels(String s) {
        char[] str = s.toCharArray();
        int n = s.length();
        int lo=0, hi = n-1;
        while(lo<hi){
            while(lo < hi && "aeiou".indexOf(Character.toLowerCase(str[lo])) == -1) ++lo;
            while(lo < hi && "aeiou".indexOf(Character.toLowerCase(str[hi])) == -1) --hi;
            if(lo >= hi) break;
            char temp = str[lo];
            str[lo] = str[hi];
            str[hi] = temp;
            ++lo;
            --hi;
        }
        return new String(str);    
    }
}

