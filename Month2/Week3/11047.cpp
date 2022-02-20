#include <iostream>

using namespace std;

int arr[10];
int coincount=0;

 int main() {
	 ios_base::sync_with_stdio(false);
	
	int count = 0;
	int n, k;
	cin >> n >> k;

	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	for (int j = n - 1; j >= 0; j--) {
		if (arr[j] <= k)
		{
			count=k / arr[j];
			coincount += count;
			k -= arr[j] * count;
		}
	}
	printf("%d", coincount);

	return 0;
}

