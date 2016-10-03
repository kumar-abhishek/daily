/*
5. Longest Palindromic Substring  QuestionEditorial Solution
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.

Show Company Tags
Show Tags
Show Similar Problems

*/
//accepted
public class Solution {
    public String maxPalindromeLen(String S, int j, int i){
        if(S.length() == 1){
            return S;
        }
        while(i < S.length() && j >=0 && (S.charAt(i) == S.charAt(j))){
                i += 1;   
                j -= 1;
        }
        return S.substring(j+1, i);
    }
    
    public String longestPalindrome(String s) {
        int maxLength = 0;
        int l = s.length();
        String maxS = "", odd_palindrome, even_palindrome;
        for(int i = 0; i< l; i++){
            even_palindrome = maxPalindromeLen(s, i, i+1);
            odd_palindrome = maxPalindromeLen(s, i, i);
            if(maxS.length() < even_palindrome.length()){
                maxS = even_palindrome;   
            }
            if(maxS.length() < odd_palindrome.length()){
                maxS = odd_palindrome;   
            }
        }
        return maxS;
    }
}
