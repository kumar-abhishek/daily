#include<iostream>
#include<cstdio>
#include<cstdlib>
using namespace std;

int main(){
    int n;
    while(scanf("%d", &n) == 1) {
        bool seq[n]={false};
        int prev, cur;
        scanf("%d", &prev);
        for(int i=1;i<n;i++) {
            scanf("%d", &cur);
            seq[abs(cur-prev)] = true;
            prev = cur;
        }
        bool is_jolly = true;
        for(int i=1;i<n         ;i++) {
            if(seq[i] == false) {
                is_jolly = false;
                break;
            }
        }
        if(is_jolly) printf("Jolly\n");
        else printf("Not jolly\n");
    }
    return 0;
}
