/*
165. Compare Version Numbers
Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
Credits:
Special thanks to @ts for adding this problem and creating all test cases.
*/

//NOT accepted

public class Solution {
    public int compareVersion(String version1, String version2) {
        int i=0, j =0;
        while(i < version1.length() && version1.charAt(i) == '0') ++i;
        while(j < version2.length() && version2.charAt(j) == '0') ++j;
        while(i<version1.length() && j < version2.length()) {
            int v1 = version1.charAt(i)-'0';
            int v2 = version2.charAt(j)-'0';
            if(v1 < v2) return -1;    
            else if(v2 < v1) return 1;
            ++i;
            ++j;
        }
        if(i < version1.length()) return 1; 
        else if(j< version2.length()) return -1;
        return 0;
    }
}
