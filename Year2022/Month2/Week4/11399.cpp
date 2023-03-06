#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


int main() {
	vector<int> v;
	int n,temp;
	int sum = 0;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> temp;
		v.push_back(temp);
	}
	sort(v.begin(), v.end());

	for (int i = 0; i < n; i++) {
		sum += v[i] * (n - i);
	}
	cout << sum;
	return 0;
}