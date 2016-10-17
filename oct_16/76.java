/*
76. Minimum Window Substring
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
*/

//accepted
public class Solution {
    public String minWindow(String s, String t) {
        int[] expected_count = new int[60];
        int[] current_count = new int[60];
        for(int i=0;i<t.length();i++) expected_count[t.charAt(i)-'A'] += 1;
        
        int start=0, minStart=0, minWin=Integer.MAX_VALUE, count=0;
        for(int i=0;i<s.length();i++) {
            int j = s.charAt(i)-'A';
            current_count[j] += 1;
            if(current_count[j] <= expected_count[j]) ++count;
            if(count == t.length()){
                int k = s.charAt(start)-'A';
                while((current_count[k] > expected_count[k]) || (expected_count[k]==0)) {
                    current_count[k] -= 1;
                    start += 1;
                    k = s.charAt(start)-'A';
                }                
                if(minWin > i-start+1){
                    minWin = i-start+1;
                    minStart = start;
                }
            }
        }
        
        if(minWin == Integer.MAX_VALUE) return "";
        return s.substring(minStart, minStart+minWin);
    }
}

