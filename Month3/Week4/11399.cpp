#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


int main() {
	int n,count=0;
	cin >> n;
	vector<int> v;

	for (int i = 0; i < n; i++) {
		int temp;
		cin >> temp;
		v.push_back(temp);
	}
	sort(v.begin(), v.end());

	for (int i = 0; i < n; i++) {
		for (int j = 0; j <= i; j++) {
			count += v[j];
			cout << "count=" << count << endl;
			cout << v[j] << endl;
		}
	}


	cout << count;



	return 0;
}