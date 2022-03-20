#include <iostream>
#include <vector>
#include <algorithm>



using namespace std;

int MaxWeight(int n,vector<int>& v) {
	int sum = 0;
	int max = 0;
	for (int i = 1; i <= n; i++) {
		sum = v[n - i]*i;
		if (sum > max)
			max = sum;
	}
	
	return max;

}

int main() {
	vector<int> v;
	int n,max;
	cin >> n;

	for (int i = 1; i <= n; i++) {
		int temp;
		cin >> temp;
		v.push_back(temp);
	}
	sort(v.begin(), v.end());
	max=MaxWeight(n,v);
	cout << max;


	return 0;
}