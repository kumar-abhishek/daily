/*
14. Longest Common Prefix
Write a function to find the longest common prefix string amongst an array of strings.

*/

import java.util.Arrays;
public class Solution {
    public String getCommonStr(String s1, String s2){
        StringBuilder s= new StringBuilder("");
        for(int i=0;i<s1.length() && i<s2.length();i++){
            if(s1.charAt(i) != s2.charAt(i)) return s.toString();
            else{
                s.append(s1.charAt(i));
            }
        }
        return s.toString();
    }
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        Arrays.sort(strs);
        String commonStr=strs[0];
        for(int i=1;i<strs.length;i++){
            commonStr = getCommonStr(commonStr, strs[i]);
        }
        return commonStr;
    }
}
