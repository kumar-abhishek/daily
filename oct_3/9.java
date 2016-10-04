/*

9. Palindrome Number
Determine whether an integer is a palindrome. Do this without extra space.
*/
//accepted
public class Solution {
    public boolean isPalindrome(int x) {
        if(x<0 || (x!=0 && x%10==0)) return false;
        int reverse = 0;
        while(x > reverse){
            reverse = reverse*10 + x%10;
            x /= 10;
        }
        if(x == reverse || x == reverse/10) return true;
        return false;
    }
}

