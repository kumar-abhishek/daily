/*
 * :
We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.

Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
Example:
Input: 28
Output: True
Explanation: 28 = 1 + 2 + 4 + 7 + 14
Note: The input number n will not exceed 100,000,000. (1e8)

*/

class Solution {
private:
    vector<int> findDivisors(int num) {
        vector<int> v;
        if(num != 1) v.push_back(1);
        for(int i=2;i<=sqrt(num);i++) {
            if(num%i ==0) {
                v.push_back(i);
                v.push_back(num/i);
            }
        }
        return v;
    }
public:
    bool checkPerfectNumber(int num) {
        vector<int> v = findDivisors(num);        
        if(accumulate(v.begin(), v.end(), 0) == num) return true;
        return false;
    }
};