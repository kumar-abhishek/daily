/*
67. Add Binary
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/
public class Solution {
    public String addBinary(String a, String b) {
        int i = Integer.parseInt(a, 2);
        int j = Integer.parseInt(b, 2);
        int k = i+j;
        return Integer.toString(k, 2);
    }
}
