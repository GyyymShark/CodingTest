#include <iostream>

using namespace std;

void GCD(int*, int);

int main() {

	ios_base::sync_with_stdio(false);

	int t;
	int n;
	int* arr;

	cin >> t;

	for (int i = 0; i < t; i++) {
		cin >> n;
		arr = new int[n];
		for (int j = 0; j < n; j++) {
			cin >> arr[j];
		}
		GCD(arr, n);
	}


	

	return 0;
}

void GCD(int* arr, int n) {

	
	int min;
	int gcd;
	int gcdsum = 0;
	for (int i = 0; i < n; i++) {
		for (int j = i + 1; j < n; j++) {
			gcd = 1;
			if (arr[i] > arr[j]) {		//ÃÖ¼Ú°ª °áÁ¤
				min = arr[j];
			}
			else {
				min = arr[i];
			}

			if (arr[i] % min == 0 && arr[j] % min == 0) {
				gcdsum += min;
				continue;
			}


			for (int k = 1; k <= min; k++) {
				if (arr[i] % k == 0 && arr[j] % k == 0) {
					if (gcd < k)
						gcd = k;
				}
			}
			gcdsum += gcd;
		}
	}

	cout << gcdsum<<"\n";

}