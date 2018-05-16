/*
70. Climbing Stairs
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/
//accepted
public class Solution {
    public int climbStairs(int n) {
        if(n==0) return 1;
        if(n ==1) return 1;
        int a=1, b = 1, c = 2;
        while(n > 2) {
            a = b;
            b = c;
            c = a+b;
            --n;
        }
        return c;
    }
}
