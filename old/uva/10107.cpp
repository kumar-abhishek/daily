// accepted: 10107	What is the Median?
// Use max-heap/min-heap solution when you want median in O(1)
// nth_element used here is O(n) time
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
	int n;
	vector<int> v;
	while(cin>>n) {
		v.push_back(n);
		if(v.size() % 2 == 0) {
			nth_element(v.begin(), v.begin() + v.size()/2, v.end());
			nth_element(v.begin(), v.begin() + v.size()/2 - 1, v.end());
			int m1 = v[v.size()/2];
			int m2 = v[v.size()/2 -1];
			cout << (m1+m2)/2 << endl;
		}
		else {
			nth_element(v.begin(), v.begin() + v.size()/2, v.end());
			cout << v[v.size()/2] <<endl;
		}
	}
}
