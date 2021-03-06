/*
7. Reverse Integer  QuestionEditorial Solution
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.

Have you thought about this?
Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

*/
//accepted
public class Solution {
    public int reverse(int x) {
        boolean isNeg = false;
        if(x <0){
            isNeg = true;
            x *= -1;
        }
        int ans = 0;
        while(x>0){
            int temp=ans;
            ans= ans* 10 + x%10;
            //overflow
            if((ans-x%10)/10 != temp){
                return 0;
            }
            x /= 10;
        }
        if(isNeg){
            ans *= -1;
        }
        return ans;
    }
}
