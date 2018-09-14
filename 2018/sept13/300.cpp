/*
LIS
*/
class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        multiset<int>s;
        multiset<int>::iterator it;
        for(int i: nums) {
            s.insert(i);
            it =s.find(i);++it;
            if(it !=s.end()) {s.erase(it);}
        }
        return s.size();
    }
};
