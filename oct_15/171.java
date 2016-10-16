/*
171. Excel Sheet Column Number
Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
*/

//accepted
public class Solution {
    public int titleToNumber(String s) {
        int ans = 0, j = 0;
        for(int i=s.length()-1;i>=0;i--){
            ans += Math.pow(26, j) * (s.charAt(i) - 'A' + 1);
            ++j;
        }
        return ans;
    }
}
