/*
58. Length of Last Word
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
*/

//accepted
public class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0, j = s.length()-1, i;
        while(j>=0 && s.charAt(j) == ' ') --j;
        for(i=j;i>=0;i--){
            if(s.charAt(i) == ' ') break;
        }
        return j-i;
    }
}
