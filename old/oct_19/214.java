/*
214. Shortest Palindrome
Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd".

*/


//accepted
public class Solution {
    public String shortestPalindrome(String s) {
        long B=29, mod=1000_000_007, pow=1;
        int pos=-1; // -1 so that it would work for empty strings too.
        long hash1=0, hash2=0;
        for(int i=0;i<s.length();i++, pow = pow * B % mod) {
            int val = s.charAt(i) - 'a' + 1;
            hash1 = (hash1 * B + val) % mod;
            hash2 = (hash2 + val * pow) % mod;
            if(hash1 == hash2) pos = i;
        }
        return new StringBuilder().append(s.substring(pos+1)).reverse().append(s).toString();
    }
}
