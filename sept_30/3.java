/*
3. Longest Substring Without Repeating Characters  QuestionEditorial Solution
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int ans = 0;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                start = Math.max(start, map.get(s.charAt(i)) + 1);
            } 
            ans = Math.max(ans, i-start+1);        
            map.put(s.charAt(i), i);
        }
        return ans;
    }
}
