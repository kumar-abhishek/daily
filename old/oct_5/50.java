/*
50. Pow(x, n)
Implement pow(x, n).
*/

//accepted
public class Solution {
    public double myPow(double x, int n) {
        if(n ==0) return 1;
        if(n==-1) return 1.0/x;
        if(n%2==0){
            double even_pow = myPow(x, n/2);
            return even_pow * even_pow;
        } else{
            double p = myPow(x, (n-1)/2);
            return p*p*x;
        }
        
    }
}
