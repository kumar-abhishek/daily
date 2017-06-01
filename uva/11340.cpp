//gets WA, but looks fine to me.
#include <iostream>
#include <string>
using namespace std;

int main() {
	int N, K, M;
	char ch;
	int val;
	cin>>N;
	for(int t=0;t<N;t++){
		cin>>K;
		int mp[10000] = {0};
		fill(mp, mp+10000, 0);
		for(int j=0;j<K;j++) {
			cin>>ch>>val;
			mp[ch] = val;
		}
		cin>>M;
		// next line is critical to this problem, won't get right answer without using this ignore() !!!
		cin.ignore(); 
		double money=0;
		for(int i=0;i<M;i++) {
			string line;
			getline(cin, line);
			for(char ch: line){
				money += mp[ch];
			}
		}
		printf("%0.2lf$\n", money/100);
	}
}
