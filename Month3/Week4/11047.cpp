#include <iostream>


using namespace std;

int arr[11];

int main() {
	int n, k,count=0;
	cin >> n >> k;

	for (int i = 1; i <= n; i++) {
		cin >> arr[i];
	}


	for (int i = n; i >= 1; i--) {
		int temp = k / arr[i];
		k = k - (arr[i] * temp);
		count += temp;
	}


	cout << count;



	return 0;
}