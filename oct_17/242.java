/*
242. Valid Anagram
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets
*/

public class Solution {
    public boolean isAnagram(String s, String t) {
        char[] s1 = s.toCharArray(), t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        return Arrays.equals(s1, t1);
    }
}
