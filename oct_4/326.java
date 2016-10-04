/*
326. Power of Three
Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?
*/
//accepted
public class Solution {
    public boolean isPowerOfThree(int n) {
        if(n==1) return true;
        if(n%3 != 0) return false;
        while(n > 3){
            if(n%3 != 0) return false;
            n /= 3;
        }
        if(n != 3) return false;
        return true;
    }

// without loops 
//accepted
    public boolean isPowerOfThreeWithoutLoops(int n) {
        String base3 = Integer.toString(n, 3);
        if(base3.matches("^10*")) return true;
        return false;
    }

}

