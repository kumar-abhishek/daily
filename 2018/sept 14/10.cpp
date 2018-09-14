/*
regular exp matching
*/
#include<bits/stdc++.h>
using namespace std;


bool dp(string s, string p, int i, int j){
    if(i==s.size()){ 
        if(j== p.size() || (j==p.size()-1 && p[j]=='*'))
            return true;
        if(j==p.size()-2 && p[j+1] =='*') return true;
        else return false;
    }
    if(j<p.size()-1 && p[j+1]=='*') 
        return dp(s, p, i, j+2) || dp(s, p, i+1, j);
    
    else if((s[i]==p[j] && j<p.size()-1  && p[j+1]!='*' )
                 || (p[j]=='.') || (j==p.size()-1 && s[i]==p[j]))
        return dp(s,p,i+1,j+1);    
    else if(p[j]=='*'){
        if(s[i]==p[j-1]) return dp(s, p, i+1, j);
        else return dp(s, p, i, j+1);
    }
    return false;
}
bool isMatch(string s, string p) {
    return dp(s, p, 0, 0);
}
int main() {
    //cout<<isMatch("aab", "a*b");
    //cout<<isMatch("ab", ".*b");
    //cout<<isMatch("a", "a*");
    cout<<isMatch("mississippi","mis*is*p*.");
}
