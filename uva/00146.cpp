// accepted
#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {
	string s;
	cin>>s;
	while(s != "#"){
		if(next_permutation(begin(s), end(s))){
			cout <<s<<endl;
		}
		else {
			cout <<"No Successor"<<endl;
		}
		cin>>s;
	}

}
