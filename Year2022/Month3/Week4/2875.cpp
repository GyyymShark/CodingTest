#include <iostream>
#define MIN(a,b) a<b ? a : b
using namespace std;


int main() {
	int n, m, k;
	int a, b;
	int max = 0,min;

	cin >> n >> m >> k;

	for (int i = 0; i <= k; i++) {
		a = (n - i) / 2;
		b = m - (k - i);
		min = MIN(a, b);
		if (max < min)
			max =min;
	}
	cout << max;


	return 0;
}